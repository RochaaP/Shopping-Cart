package com.company.userinterface;

import com.company.utill.Content;
import com.company.utill.DatabaseQuery;
import com.company.utill.Items;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;


class MainMenu {

    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://192.168.100.174/db";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    Content content = new Content();
    Items items = new Items();
    DatabaseQuery databaseQuery = new DatabaseQuery();
    public void addMenu(MenuBar menuBar) {
        Menu items = new Menu("Items");

        Menu addItem = new Menu("Add Items");
        MenuItem existingItems = new MenuItem("Add Existing Items");
        addItem.getItems().add(existingItems);


        MenuItem deleteItem = new MenuItem("Delete Items");
        MenuItem viewItem = new MenuItem("View Items");

        items.getItems().add(addItem);
        items.getItems().add(deleteItem);
        items.getItems().add(viewItem);

        Menu list = new Menu("List");

        menuBar.getMenus().add(items);
        menuBar.getMenus().add(list);
    }

    public GridPane content() {
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 200);

        //Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        //Setting the Grid alignment
        gridPane.setAlignment(Pos.TOP_LEFT);

        Text txtName = new Text("Name");
        TextField tfldName = new TextField();

        Text txtID = new Text("ID");
        TextField tfldID = new TextField();

        Text txtQuantity = new Text("Quantity");
        TextField tfldQuantity = new TextField();

        Button buttonRegister = new Button("Submit");
        Button buttonViewList = new Button("View All");

        gridPane.add(txtName, 0, 0);
        gridPane.add(tfldName, 1, 0);

        gridPane.add(txtID, 0, 1);
        gridPane.add(tfldID, 1, 1);

        gridPane.add(txtQuantity, 0, 2);
        gridPane.add(tfldQuantity, 1, 2);

        gridPane.add(buttonRegister, 2, 8);
        gridPane.add(buttonViewList, 4, 8);

        buttonRegister.setOnMouseClicked((mouseEvent -> {
            databaseQuery.addValues(tfldName.getText(),tfldID.getText(),Integer.parseInt(tfldQuantity.getText()));
        }));

        buttonViewList.setOnAction((actionEvent -> {
            newWindow();
        }));
        return gridPane;

    }

    public void newWindow() {
        // Specifies the owner Window (parent) for new window
//        newWindow.initOwner(primaryStage);
//
//        // Set position of second window, related to primary window.
//        newWindow.setX(primaryStage.getX() + 200);
//        newWindow.setY(primaryStage.getY() + 100);


        TableView tableView = new TableView();

        TableColumn<String, Items> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<String, Items> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Integer, Items> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        tableView.getColumns().add(nameColumn);
        tableView.getColumns().add(idColumn);
        tableView.getColumns().add(quantityColumn);
//
        ArrayList<Items> arrayList = databaseQuery.getValues();
        int count = 0;
        while (arrayList.size() > count) {
            tableView.getItems().add(new Items(
                    arrayList.get(count).getName(),
                    arrayList.get(count).getId(),
                    arrayList.get(count).getQuantity()
                    ));
            count++;
        }
//        System.out.println(arrayList.get(0).getName());
//        System.out.println(databaseQuery.getValues());
//        tableView.setItems(arrayList);

//        StackPane secondaryLayout = new StackPane();
////        secondaryLayout.getChildren().add(secondLabel);
//
//        Scene secondScene = new Scene(secondaryLayout, 500, 500);
//
//
        VBox vbox = new VBox(tableView);

        Scene scene = new Scene(vbox);
        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Second Stage");
        newWindow.setScene(scene);

        // Specifies the modality for new window.
        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.show();
    }


}
