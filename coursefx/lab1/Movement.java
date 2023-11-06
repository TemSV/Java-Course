package com.example.coursefx.lab1;

import javafx.scene.image.ImageView;

interface Movement {
     default void move(ImageView imageView) {
         System.out.println("Walk");
     }
}
