package com.example.pongball;

import android.util.Log;

public class GameRunner extends Thread{
    private Game game;
    private volatile boolean running=true;

    public GameRunner(Game game){
        this.game=game;
    }
    @Override
    public void run(){
        game.init();
        long lasttime = System.currentTimeMillis();
        //Game Loop
        while (running){
            //draw stuff.
            long now=System.currentTimeMillis();
            long elapsed=now-lasttime;

            if(elapsed<100) {
                game.update(elapsed);
                game.draw();
            }

            lasttime=now;
        }
    }
    public void shutdown(){
        running=false;
    }
}
