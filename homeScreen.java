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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Dell
 */
public class homeScreen {

    Scene scene;
    Login login;
    Stage stage;

    String[] history2 = new String[10];
    String[] history = new String[10];
    double amount = 0;
    double num = 0;
    int i = 0;

    public homeScreen(Stage stage) {
        this.stage = stage;
    }

    /**
     *
     */
    public void Draw() {

        Button deposit = new Button("Deposit");
        Button withdraw = new Button("Withdraw");
        Button balance = new Button("Balance");
        Button next = new Button("Next");
        Button back = new Button("Back");
        Button logout = new Button("Logout");

        Label action = new Label("Choose the action you want to perform");
        Label type = new Label();

        TextField value = new TextField();

        GridPane grid = new GridPane();
        grid.add(action, 0, 0);
        grid.add(balance, 0, 2);
        grid.add(withdraw, 0, 3);
        grid.add(deposit, 0, 4);
        grid.add(next, 0, 5);
        grid.add(back, 0, 6);
        grid.add(logout, 0, 7);
        grid.add(value, 3, 4);
        grid.add(type, 3, 5);

        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(login.getscene());
            }
        });
        deposit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String result = value.getText();
                if (result.matches("[0-9]+")) {
                    num = Double.parseDouble(result);
                    amount = amount + num;
                    type.setText("Deposite: " + result);
                    history[i] = "Deposite: ";
                    history2[i] = result;
                    i++;

                } else {
                    type.setText("Invalid input!");

                }

            }
        });
        withdraw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String result = value.getText();
                if (!result.matches("[0-9]+")) {
                    type.setText("Invalid input!");

                } else {
                    num = Double.parseDouble(result);

                    if (num <= amount) {
                        amount = amount - num;
                        type.setText("Withdraw: " + result);
                        history[i] = "Withdraw: ";
                        history2[i] = result;
                        i++;

                    } else {
                        num = 0.0;
                        type.setText("Error not enough in balance.");
                    }

                }
            }
        });
        balance.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                type.setText("Balance: " + amount);
                history[i] = "Balance: ";
                history2[i] = Double.toString(amount);
                i++;
            }
        });
        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                i++;
                if (i < history.length && history[i] != null) {
                    type.setText(history[i] + history2[i]);
                } else {
                    i--;
                }
            }
        });
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                i--;
                if (i >= 0) {
                    type.setText(history[i] + history2[i]);
                } else {
                    i++;
                }

            }
        });

        scene = new Scene(grid, 500, 250);
    }

    public Scene getscene() {

        return scene;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

}
