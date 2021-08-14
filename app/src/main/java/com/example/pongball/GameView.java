package com.example.pongball;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private Bitmap button;
    private GameRunner runner;
    private Game game;


    public GameView(Context context, AttributeSet attrs) {
            super(context, attrs);

            SurfaceHolder holder = getHolder();
            holder.addCallback(this);

    }

        @Override
        public boolean onTouchEvent (MotionEvent event){
            return true;
        }

    public void update(long elapsed){

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        Log.d("JWP", "Created");
        game=new Game(getWidth(),getHeight(),holder,getResources());
        runner = new GameRunner(game);
        runner.start();
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        if(runner!=null){
            runner.shutdown();
            while(runner!=null){
                try {
                    runner.join();
                    runner=null;
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
