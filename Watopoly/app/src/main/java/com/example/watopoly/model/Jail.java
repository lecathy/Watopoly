package com.example.watopoly.model;

import android.graphics.Canvas;

import com.example.watopoly.enums.TileDirection;

public class Jail extends Tile {
    @Override
    public void drawOn(Canvas canvas) {

    }

    public Jail() {
        maxNumberOfPlayers = 4;
        tileDirection = TileDirection.CORNER;
        this.name = "Jail";
    }

}
