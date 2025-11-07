package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseDragEvent;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class HelloController {

    @FXML
    private PasswordField confirmpasstf;

    @FXML
    private PasswordField passwordtf;

    @FXML
    private TextField textl;

    @FXML
    private TextField usernametf;

    @FXML
    private TextField userwrong;
    @FXML
    private TextField match2pass;

    @FXML
    private TextField passless8;
    @FXML
    private Button enrollid;
    @FXML
    private TextField resulttxt;

    @FXML
    public void Enrollbtn(ActionEvent event) {
        try {
            String user = usernametf.getText();
            String pass = passwordtf.getText();
            FileWriter fw = new FileWriter("member.txt",true);
            if (user_check(event)==null && pass_check(event) && match_check(event)) {
                fw.write(user + "\n");
                fw.write(pass + "\n");
                fw.close();
                resulttxt.setText("Your enroll committed successfully");
                resulttxt.setStyle("-fx-background-color: black;-fx-text-inner-color: #00ff00");
           } else {
                resulttxt.setText("You must fill the blanks correctly");
                resulttxt.setStyle("-fx-background-color: black;-fx-text-inner-color: red");
            }

        } catch (Exception e) {

        }
    }

    public String user_check(ActionEvent event) {
        try {
            String user = usernametf.getText();
            FileReader fr = new FileReader("member.txt");
            Scanner fs = new Scanner(fr);
            String c = fs.next();
            while (c.compareTo("null") != 0) {
                if (user.compareTo(c) == 0) {
                    userwrong.setText("Username already exists");
                    userwrong.setStyle("-fx-background-color: black;-fx-text-inner-color: red");
                    passwordtf.setEditable(false);
                    confirmpasstf.setEditable(false);
                    String pu = fs.next();
                    return pu;
                }
                fs.next();
                c = fs.next();
            }
        } catch (Exception e) {

        }
        userwrong.setText("");
        passwordtf.setEditable(true);
        confirmpasstf.setEditable(true);
        return null;
    }

    @FXML
    public boolean pass_check(ActionEvent event) {
        String pass = passwordtf.getText();
        char[] c = pass.toCharArray();
        if (c.length < 8) {
            passless8.setText("Your password is less than 8 char");
            passless8.setStyle("-fx-background-color: black;-fx-text-inner-color: red");
            confirmpasstf.setEditable(false);
            return false;
        } else {
            passless8.setText("");
            confirmpasstf.setEditable(true);
            return true;
        }
    }

    @FXML
    public boolean match_check(ActionEvent event) {
        String pass2 = confirmpasstf.getText();
        String pass = passwordtf.getText();
        if (pass2.compareTo(pass) != 0) {
            match2pass.setText("Passwords do NOT match");
            match2pass.setStyle("-fx-background-color: black;-fx-text-inner-color: red");
            return false;
        } else {
            match2pass.setText("");
            return true;
        }
    }
}
