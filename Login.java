/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Dell
 */
public class Login {

    confirmation Confirme;
    homeScreen homescreen;
    Scene scene;
    Stage stage;

    public Login(Stage stage) {
        this.stage = stage;
    }

    public void Draw() {
        Confirme = new confirmation();

        Label usernameLabel = new Label("Username: ");
        Label passwordLabel = new Label("Password: ");
        Label validationLabel = new Label();

        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();

        Button btn = new Button("Login");

        GridPane grid = new GridPane();
        grid.add(usernameLabel, 0, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(usernameField, 1, 0);
        grid.add(passwordField, 1, 1);
        grid.add(btn, 1, 2);
        grid.add(validationLabel, 1, 3);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String username = usernameField.getText();
                String password = passwordField.getText();

                boolean valid = Confirme.confirm(username, password);
                if (valid) {
                    stage.setScene(homescreen.getscene());
                } else {
                    validationLabel.setText("Wrong Username or Password !");
                }
            }
        });
        scene = new Scene(grid, 300, 150);
    }

    public Scene getscene() {

        return this.scene;
    }

    public void setHomescreen(homeScreen homescreen) {
        this.homescreen = homescreen;
    }

}