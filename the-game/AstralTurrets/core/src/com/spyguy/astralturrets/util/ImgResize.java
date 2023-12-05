package com.spyguy.astralturrets.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

public class ImgResize {
    public static Texture resizeImage(String path_to_image, int width, int height){
        Pixmap original_image = new Pixmap(Gdx.files.internal(path_to_image));
        Pixmap resized_image = new Pixmap(width, height, original_image.getFormat());
        resized_image.drawPixmap(original_image,
                0, 0, original_image.getWidth(), original_image.getHeight(),
                0, 0, resized_image.getWidth(), resized_image.getHeight()
        );
        return new Texture(resized_image);
    }

    public static Texture scaleImage(String path_to_image, float scale){
        Pixmap original_image = new Pixmap(Gdx.files.internal(path_to_image));
        Pixmap scaled_image = new Pixmap((int)(original_image.getWidth() * scale), (int)(original_image.getHeight() * scale), original_image.getFormat());
        scaled_image.drawPixmap(original_image,
                0, 0, original_image.getWidth(), original_image.getHeight(),
                0, 0, scaled_image.getWidth(), scaled_image.getHeight()
        );
        return new Texture(scaled_image);
    }
}
