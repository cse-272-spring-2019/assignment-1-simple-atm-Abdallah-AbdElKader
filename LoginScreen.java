/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Dell
 */
public class LoginScreen extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Welcome!");
        Login login = new Login(primaryStage);
        homeScreen homescreen = new homeScreen(primaryStage);
        login.Draw();
        homescreen.Draw();

        login.setHomescreen(homescreen);
        homescreen.setLogin(login);

        primaryStage.setScene(login.getscene());
        primaryStage.show();
    }

}
