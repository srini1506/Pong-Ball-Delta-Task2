 package com.example.pongball;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Sprite {
    private float x;
    private float y;

    private int screenwidth;
    private int screenheight;

    private Bitmap image;
    private Bitmap shadow;

    private Rect bounds;

    private int shadowoffsetX;
    private int shadowoffsetY;

    public Sprite(int screeenwidth,int screenheight){
        this.x=130;
        this.y=130;

        this.screenwidth=screeenwidth;
        this.screenwidth=screenheight;

    }

    public void init(Bitmap image,Bitmap shadow,int shadowoffsetX,int shadowoffsetY){
          this.image=image;
          this.shadow=shadow;
          this.shadowoffsetX=shadowoffsetX;
          this.shadowoffsetY=shadowoffsetY;
          bounds=new Rect(0,0,image.getWidth(),image.getHeight());
    }


    public void draw(Canvas canvas){
         canvas.drawBitmap(shadow,x,y,null);
         canvas.drawBitmap(image,x,y,null);
    }

    public Rect getRect(){
        return bounds;
    }


    public Rect getScreenRect(){
        return new Rect((int)x,(int)y,(int)x+getRect().width(),(int)y+getRect().height());
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getScreenwidth() {
        return screenwidth;
    }

    public int getScreenheight() {
        return screenheight;
    }

}
