package com.mft.controller;

import com.sun.org.glassfish.gmbal.IncludeSubclass;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PersonViewController implements Initializable {
    @FXML
    private Button saveBtn, exitBtn;
    @FXML
    private TextField nameTxt,familyTxt;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        saveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //System.out.println(nameTxt.getText()+" "+familyTxt.getText());
                PersonController.add(nameTxt.getText(),familyTxt.getText());
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
