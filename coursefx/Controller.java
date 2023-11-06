package com.example.coursefx;

import com.example.coursefx.lab1.*;
import com.example.coursefx.lab2.RunLab2;
import com.example.coursefx.lab3.RunLab3;
import com.example.coursefx.lab4.Lab4Runner;
import com.example.coursefx.lab5.Lab5Runner;
import com.example.coursefx.lab6.Lab6Runner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;


public class Controller {

    @FXML
    private ImageView movementIcon;

    @FXML
    private TextArea lab2TextArea;

    @FXML
    private TextArea lab3TextArea;

    @FXML
    private TextArea lab4TranslatedText;

    @FXML
    private TextArea lab5TextArea;

    @FXML
    private TextArea lab6TextArea;

    @FXML
    private AnchorPane lab4Pane;

    @FXML
    private Button walkButton;

    @FXML
    private Button driveButton;

    @FXML
    private Button cycleButton;

    @FXML
    private Button rideButton;

    @FXML
    private Button startLab2Button;

    @FXML
    private Button lab3StartButton;

    @FXML
    private Button chooseDictionaryButton;

    @FXML
    private Button chooseFileToTranslateButton;

    @FXML
    private Button translateButton;

    @FXML
    private Button startLab5Button;

    @FXML
    private Button startLab6Button;

    Hero hero = new Hero(new Walking());

    @FXML
    void setWalkingMovement(ActionEvent event) {
        hero.setMovement(new Walking());
        hero.executeMovement(movementIcon);
    }

    @FXML
    void setCyclingMovement(ActionEvent event) {
        hero.setMovement(new Cycling());
        hero.executeMovement(movementIcon);
    }

    @FXML
    void setDrivingMovement(ActionEvent event) {
        hero.setMovement(new Driving());
        hero.executeMovement(movementIcon);
    }

    @FXML
    void setRidingMovement(ActionEvent event) {
        hero.setMovement(new Riding());
        hero.executeMovement(movementIcon);
    }

    @FXML
    void startLab2(ActionEvent event) {
        lab2TextArea.clear();
        RunLab2.main(lab2TextArea);
    }

    @FXML
    void startLab3(ActionEvent event) {
        lab3TextArea.clear();
        RunLab3.main(lab3TextArea);
    }

    private File dictionary;
    private File textToTranslate;

    @FXML
    private TextArea dictionaryPath;

    @FXML
    void chooseDictionary(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        dictionary = fileChooser.showOpenDialog(lab4Pane.getScene().getWindow());
        dictionaryPath.clear();
        dictionaryPath.appendText(dictionary.getPath());
    }

    @FXML
    private TextArea textPath;


    @FXML
    void chooseFileToTranslate(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        textToTranslate = fileChooser.showOpenDialog(lab4Pane.getScene().getWindow());
        textPath.appendText(textToTranslate.getPath());
    }

    @FXML
    void translate(ActionEvent event) {
        lab4TranslatedText.clear();
        Lab4Runner.main(dictionary, textToTranslate, lab4TranslatedText);
    }

    @FXML
    void startLab5(ActionEvent event) {
        lab5TextArea.clear();
        Lab5Runner.main(lab5TextArea);
    }

    @FXML
    void startLab6(ActionEvent event) {
        lab6TextArea.clear();
        Lab6Runner.main(lab6TextArea);
    }

}
