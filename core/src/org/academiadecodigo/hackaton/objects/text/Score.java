package org.academiadecodigo.hackaton.objects.text;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static org.academiadecodigo.hackaton.screens.GameScreen.SCREEN_SIZE_X;
import static org.academiadecodigo.hackaton.screens.GameScreen.SCREEN_SIZE_Y;

/**
 * Created by codecadet on 27/07/2017.
 */

public class Score {

    private final int DOOR_POSITION_X = Gdx.graphics.getWidth() / 2 - 120;
    private final int DOOR_POSITION_Y = Gdx.graphics.getHeight() / 4;

    private int score;
    private SpriteBatch doorBatch;
    private Texture doorTexture;
    private float brightness;

    private float green = 0;
    private float blue = 0;
    private float alpha = 1f;

    public Score() {
        brightness = 0.75F;
        doorBatch = new SpriteBatch();
        score = SCREEN_SIZE_X / 8;

        doorTexture = new Texture(Gdx.files.internal("red_door.jpg"));
        doorBatch.begin();
        doorBatch.setColor(brightness, green, blue, alpha);
        doorBatch.end();

    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {

        if (score > SCREEN_SIZE_X / 2) {
            return;
        }

        brightness -= 0.024;
        if (brightness < 0.14f) {
            brightness = 0.14f;
        }

        score += 5;
    }

    public void updateScoreBar() {
        doorBatch.begin();
        doorBatch.setColor(1f, 0, 0, brightness);
        doorBatch.end();
    }


    public void decrementScore() {

        if (score < 0) {
            return;
        }

        brightness += 0.024;
        if (brightness > 1f) {
            brightness = 1f;
        }

        score -= 5;

        if (score < 0) {
            score = 0;
        }
    }

    public void dispose() {

    }

    public void draw() {
        doorBatch.begin();
        doorBatch.setColor(brightness, green, blue, alpha);
        doorBatch.draw(doorTexture, DOOR_POSITION_X, DOOR_POSITION_Y);
        doorBatch.end();
    }
}
