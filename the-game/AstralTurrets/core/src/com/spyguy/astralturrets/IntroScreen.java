package com.spyguy.astralturrets;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.spyguy.astralturrets.util.ImgResize;
import com.spyguy.astralturrets.util.Logger;

public class IntroScreen implements Screen {
    final TheGame game;

    OrthographicCamera camera;

    Texture spyguyLogo;

    long startTime = System.currentTimeMillis();
    long lastLogTime = 0;


    public IntroScreen(final TheGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        this.create();
    }

    public void create(){
        // Creates the assets that are used in the render function
        spyguyLogo = ImgResize.scaleImage("spyguy_logo.png",0.9f);

    }
    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);

        long clock = System.currentTimeMillis() - startTime;
        if (clock - lastLogTime >= 1000){
            lastLogTime = clock;
            Logger.log("Time Elapsed: " + clock + "ms");
        }


        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();

        // Calculate the position of the logo (center of the screen)
        int logoX = (int)(camera.viewportWidth / 2 - spyguyLogo.getWidth() / 2);
        int logoY = (int)(camera.viewportHeight / 2 - spyguyLogo.getHeight() / 2);

        //Slowly zoom in for 2 seconds while showing the logo
        if (clock < 2000){
            camera.zoom += 0.002f;
        }

        game.batch.draw(spyguyLogo, logoX, logoY);
        game.batch.end();

        if(clock > 2000){
            game.setScreen(new MainMenuScreen(game));
            dispose();
        }
    }

    @Override
    public void show() {

    }


    @Override
    public void resize(int width, int height) {
        // MainMenu can't be resized, so this function is empty
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    public void dispose(){
        // Disposes of the assets when the astralturrets is closed
        // spyguyLogo.dispose();
    }
}

//    Array<TextureRegion> frames = new Array<TextureRegion>();
//for (int i = 0; i < numOfFrames; i++) {
//        frames.add(new TextureRegion(yourSpriteSheet, i * frameWidth, 0, frameWidth, frameHeight));
//        }
//        Animation<TextureRegion> animation = new Animation<TextureRegion>(frameDuration, frames);

