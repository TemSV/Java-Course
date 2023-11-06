package com.example.coursefx.lab1;

import javafx.scene.image.ImageView;

public class Hero {
    Movement movement;

    public Hero(Movement src) {
        this.movement = src;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public void executeMovement(ImageView imageView) {
        movement.move(imageView);
    }


}
