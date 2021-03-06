package com.example.watopoly.model;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.watopoly.enums.TileDirection;
import com.example.watopoly.util.BoardTiles;

import java.util.List;

public class Building extends Property {
    private int numberOfHouses = 0;
    private boolean hasHotel = false;
    private String hexCode;
    private double housePrice;

    @Override
    public double getRentPrice() {
        if(owner == null) {
            return baseRentPrice;
        }
        return hasHotel ? getRentPriceWithHotel() : getRentPrice(numberOfHouses, owner.ownsFullSet(hexCode));
    }

    public double getHousePrice(){ return housePrice; }

    public double getRentPrice(int numOfHouses, boolean isFullSet) {
        if (isFullSet) {
            switch (numOfHouses) {
                case 0:
                    return Math.ceil((2 * baseRentPrice) / 10) * 10;
                case 1:
                    return Math.ceil((4.94 * baseRentPrice) / 10) * 10;
                case 2:
                    return Math.ceil((14.3 * baseRentPrice) / 10) * 10;
                case 3:
                    return Math.ceil((37.8 * baseRentPrice) / 10) * 10;
                case 4:
                    return Math.ceil((54.1 * baseRentPrice) / 10) * 10;
                default:
                    return 0;
            }
        } else {
            return baseRentPrice;
        }
    }

    public int getNumberOfHouses(){ return numberOfHouses; }

    public boolean isHasHotel(){ return hasHotel; }

    public double getRentPriceWithHotel() {
        return Math.ceil((69.8 * baseRentPrice) / 10) * 10;
    }

    public String getPropertyHex() {
        return hexCode;
    }

    @Override
    public void drawOn(Canvas canvas) {
        Paint insideFill = new Paint();
        insideFill.setColor(Color.parseColor(hexCode));
        int fillOffset = 125;

        // offset for thickness of gameboard lines, which is currently 4
        int thicknessOffset = 2;

        if (tileDirection == TileDirection.LEFT) {
            canvas.drawRect(coordinates.left + fillOffset,
                    coordinates.top,
                    coordinates.right - thicknessOffset,
                    coordinates.bottom - thicknessOffset,
                    insideFill);
        } else if (tileDirection == TileDirection.TOP) {
            canvas.drawRect(coordinates.left + thicknessOffset,
                    coordinates.top + fillOffset,
                    coordinates.right - thicknessOffset,
                    coordinates.bottom - thicknessOffset,
                    insideFill);
        } else if (tileDirection == TileDirection.RIGHT) {
            canvas.drawRect(coordinates.left + thicknessOffset,
                    coordinates.top - thicknessOffset,
                    coordinates.right - fillOffset,
                    coordinates.bottom - thicknessOffset,
                    insideFill);
        } else if (tileDirection == TileDirection.BOTTOM) {
            canvas.drawRect(coordinates.left + thicknessOffset,
                    coordinates.top - fillOffset,
                    coordinates.right - thicknessOffset,
                    coordinates.bottom + thicknessOffset,
                    insideFill);
        }
    }

    //TODO: find what this needs
    public void upgrade() {

    }

    public void buyHouses(int numHouses){
        Game game = Game.getInstance();
        owner.payAmount(numHouses * housePrice);
        numberOfHouses += numHouses;
    }

    public void sellHouses(int numHouses){
        Game game = Game.getInstance();
        owner.receiveAmount(numHouses * housePrice);
        numberOfHouses -= numHouses;
    }

    public void buyHotel(){
        Game game = Game.getInstance();
        owner.payAmount(housePrice);
        hasHotel = true;
    }

    public void sellHotel(){
        Game game = Game.getInstance();
        owner.receiveAmount(housePrice);
        hasHotel = false;
    }

    public Building(String name, TileDirection direction, double baseRentPrice, double purchasePrice, double housePrice, String hexCode) {
        super(name, direction, baseRentPrice, purchasePrice);
        this.hexCode = hexCode;
        this.housePrice = housePrice;
    }
}
