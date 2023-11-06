package com.example.coursefx.lab1;

import javafx.scene.image.ImageView;

public class Walking implements Movement {

    private String imageViewPath = new String("C:\\polytech\\Java\\courseFX\\src\\drawable\\49A6.gif");
    @Override
    public void move(ImageView imageView) {
        imageView.setImage(new ImageView(imageViewPath).getImage());
    }
}
