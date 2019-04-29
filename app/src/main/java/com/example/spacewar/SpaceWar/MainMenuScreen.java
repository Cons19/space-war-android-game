package com.example.spacewar.SpaceWar;

import android.graphics.Bitmap;

import com.example.spacewar.GameEngine;
import com.example.spacewar.Screen;

public class MainMenuScreen extends Screen
{
    Bitmap background;
    Bitmap startGame;
    float passedTime = 0;
    long startTime;

    public MainMenuScreen(GameEngine gameEngine)
    {
        super(gameEngine);
//        background = gameEngine.loadBitmap("spacewar/images/maps/map4.jpg");
        background = gameEngine.loadBitmap("spacewar/images/maps/bg_start.png");
        startGame = gameEngine.loadBitmap("spacewar/images/xstartgame.png");
        startTime = System.nanoTime();
    }

    @Override
    public void update(float deltaTime)
    {
        if (gameEngine.isTouchDown(0) && (passedTime) > 0.5f) // wait half a second after the main menu shows, then interact
        {
            gameEngine.setScreen(new GameScreen(gameEngine));
            return;
        }
        gameEngine.drawBitmap(background, 0, 0);
        passedTime = passedTime + deltaTime;
        if ((passedTime - (int)passedTime) > 0.5f )  // 1,55 - 1 > 0.5  blink every half seconds
        {
            gameEngine.drawBitmap(startGame, 320/2 - startGame.getWidth()/2, 480/2 - startGame.getHeight()/2);
        }

    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void dispose()
    {

    }
}