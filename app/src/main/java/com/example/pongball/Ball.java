package com.example.pongball;

import android.graphics.Rect;
import android.util.Log;

public class Ball extends Sprite{
    private final float speedX=0.05f;
    private final float speedY=0.05f;

    private int directionX=1;
    private int directionY=1;

    public Ball(int screenwidth , int screenheight){
        super(screenwidth,screenheight);
    }

    public void update(long elapsed){
        float x=getX();
        float y=getY();


        Rect screenrect=getScreenRect();

        if(screenrect.left<=0){
            directionX=1;

        }
        else if(screenrect.right>= getScreenwidth()){
            directionX=-1;

        }

        if(screenrect.top<=0){
            directionY=1;

        }
        else if(screenrect.bottom>=getScreenheight()){
            directionY=-1;
        }

        x=x+(directionX * speedX * elapsed);
        y=y+(directionY * speedY * elapsed);



        setX(x);
        setY(y);
    }
}
