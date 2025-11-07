package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.FileReader;
import java.util.Scanner;

public class HelloController {

    @FXML
    private PasswordField pass_check_log;

    @FXML
    private TextField pass_log;

    @FXML
    private TextField text_button_login;

    @FXML
    private TextField user_check_log;

    @FXML
    private TextField user_log;

    @FXML
    void button_login(ActionEvent event) {
        String pu = "notExist";
        try {
            String user = user_check_log.getText();
            FileReader fr = new FileReader("member.txt");
            Scanner fs = new Scanner(fr);
            String c = fs.next();
            while (c.compareTo("null") != 0) {
                if (user.compareTo(c) == 0) {
                    pu = fs.next();
                    break;
                }
                fs.next();
                c = fs.next();
            }
        } catch (Exception e) {

        }
        String pass = pass_check_log.getText();
        if (pass.compareTo(pu) == 0) {
            text_button_login.setText("Welcome");
            text_button_login.setStyle("-fx-background-color: black;-fx-text-inner-color: green");
            user_log.setText("");
            pass_log.setText("");
        } else {
            text_button_login.setStyle("-fx-background-color: black;-fx-text-inner-color: red");
            text_button_login.setText("");
            if (pu.compareTo("notExist") == 0 && pass.compareTo(pu) != 0) {
                user_log.setText("Username is not valid");
                pass_log.setText("Password didn't detected");
                pass_log.setStyle("-fx-background-color: black;-fx-text-inner-color: red");
                user_log.setStyle("-fx-background-color: black;-fx-text-inner-color: red");
            } else if (pu.compareTo("notExist") == 0) {
                user_log.setText("Username is not valid");
                pass_log.setText("");
                user_log.setStyle("-fx-background-color: black;-fx-text-inner-color: red");
            } else if (pass.compareTo(pu) != 0) {
                pass_log.setText("Password didn't detected");
                user_log.setText("");
                pass_log.setStyle("-fx-background-color: black;-fx-text-inner-color: red");
            }
        }
    }
}


