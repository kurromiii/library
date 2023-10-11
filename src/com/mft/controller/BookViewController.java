package com.mft.controller;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class BookViewController implements Initializable {
    @FXML
    private Button submitBtn,exitBtn;
    @FXML
    private TextField bookTxt,writerTxt,countTxt;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        submitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                BookController.add(bookTxt.getText(),writerTxt.getText(), Integer.parseInt(countTxt.getText()));
            }
        });
        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });

    }
}
