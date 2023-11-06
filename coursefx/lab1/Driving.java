package com.example.coursefx.lab1;

import javafx.scene.image.ImageView;

public class Driving implements Movement {

    private String imageViewPath = new String("C:\\polytech\\Java\\courseFX\\src\\drawable\\driving.gif");

    @Override
    public void move(ImageView imageView) {
        imageView.setImage(new ImageView(imageViewPath).getImage());
    }
}
