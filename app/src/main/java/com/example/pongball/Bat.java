package com.example.pongball;

import android.graphics.Bitmap;

public class Bat extends Sprite{

    public enum Position{
        BOTTOM
    }

    private Position position;

    public Bat(int screeenwidth, int screenheight,Position position) {
        super(screeenwidth, screenheight);
        this.position=position;
    }

    @Override
    public void init(Bitmap image, Bitmap shadow, int shadowoffsetX, int shadowoffsetY) {
        super.init(image, shadow, shadowoffsetX, shadowoffsetY);
    }
}
