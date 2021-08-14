 package com.example.pongball;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;


public class Game {
    private SurfaceHolder holder;
    private Resources resources;
    private Ball ball;
    private Bat bat;

    public Game(int width,int height,SurfaceHolder holder, Resources resources){
        this.holder=holder;
        this.resources=resources;
        ball=new Ball(width,height);
        bat=new Bat(width,height,Bat.Position.BOTTOM);
    }
    public void init(){
         Bitmap ballImage = BitmapFactory.decodeResource(resources, R.drawable.ball);
         Bitmap ballShadow = BitmapFactory.decodeResource(resources, R.drawable.ballshadow);
         Bitmap batImage=BitmapFactory.decodeResource(resources,R.drawable.bat);
         Bitmap batShadow=BitmapFactory.decodeResource(resources,R.drawable.bat_shadow);
         ball.init(ballImage,ballShadow,-3,0);
         bat.init(batImage,batShadow,-3,0);

    }
    public void update(long elapsed){
         ball.update(elapsed);
    }
    public void draw(){
        Canvas canvas = holder.lockCanvas();
        if (canvas != null) {
            canvas.drawColor(Color.WHITE);
            ball.draw(canvas);
            bat.draw(canvas);
            holder.unlockCanvasAndPost(canvas);
        }
    }
}
