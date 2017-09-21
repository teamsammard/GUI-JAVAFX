package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridLayout {

    public static void display(String title){
        Stage window=new Stage();
        window.setTitle(title);

        GridPane gridPane=new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10,10,10,10));

        Label userLabel=new Label("Username");
        GridPane.setConstraints(userLabel,0,0);

        TextField userField=new TextField("Mayank");
        GridPane.setConstraints(userField,1,0);

        Label passLabel=new Label("Username");
        GridPane.setConstraints(passLabel,0,1);

        TextField passField=new TextField();
        passField.setPromptText("password");
        GridPane.setConstraints(passField,1,1);

        ChoiceBox<String> choiceBox=new ChoiceBox<>();

        choiceBox.getItems().add("Male");
        choiceBox.getItems().add("Female");
        choiceBox.getItems().add("Not to disclose");

        //set defalut
        choiceBox.setValue("Male");

        choiceBox.getSelectionModel().selectedItemProperty().addListener((o,oldValue,newValue)->{
            System.out.println("old value: "+oldValue);
            System.out.println("new value: "+newValue);
        });

        GridPane.setConstraints(choiceBox,1,2);

        Button button=new Button("Login");
        GridPane.setConstraints(button,1,3);



        gridPane.getChildren().addAll(userField,userLabel,passField,passLabel,button,choiceBox);


        Scene scene=new Scene(gridPane,300,200);
        window.setScene(scene);
        window.show();
    }

    //choicebox<string>
    //checkbox
    //textfield
    //label
    //button
    //stage
    //scene
    //gridpane
    //hbox
    //vbox
    //stackpane
    //listview
    //observablelist
    //combobox
    //togglegroup
    //radiomenuitm
    //menu
    //border pane
    //tableview
    //observablelist
    //forEach::remove
    //menubar

}
