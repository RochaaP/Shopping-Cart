package com.company.userinterface;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UserInterface extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();

        MenuBar menuBar = new MenuBar();
//        VBox vBox = new VBox(menuBar);

        MainMenu menuClass = new MainMenu();
        menuClass.addMenu(menuBar);

        root.setTop(menuBar);
        root.setCenter(menuClass.content());
        Scene scene = new Scene(root ,600, 300);

        scene.setFill(Color.LIGHTGRAY);
        primaryStage.setTitle("Shopping Cart");
        primaryStage.setScene(scene);   //Adding the scene to Stage
        primaryStage.show();    //Displaying the contents of the stage
    }

    public void launching() {
        launch();
    }


}