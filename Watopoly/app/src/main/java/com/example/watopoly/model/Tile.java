package com.example.watopoly.model;

import android.graphics.Canvas;

import com.example.watopoly.enums.TileDirection;

import java.io.Serializable;

public abstract class Tile implements Serializable {
    protected String name;
    protected Coordinates coordinates = new Coordinates(0,0,0,0);
    protected int maxNumberOfPlayers;
    protected int currNumberOfPlayers = 0;
    protected TileDirection tileDirection;

    //Does nothing on default
    public void landOn(Player player) {}

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates c) {
        coordinates = c;
    }

    abstract public void drawOn(Canvas canvas);

    public String getName() {
        return name;
    }

    public TileDirection getTileDirection() {
        return tileDirection;
    }

    public int getCurrNumberOfPlayers() {
        return currNumberOfPlayers;
    }

    public int getMaxNumberOfPlayers() {
        return maxNumberOfPlayers;
    }

    public void decrementCurrNumberOfPlayers() { currNumberOfPlayers--;}

    public void incrementCurrNumberOfPlayers() { currNumberOfPlayers++;}
}
