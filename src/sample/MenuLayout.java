package sample;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MenuLayout {

    public static void display(String title){
        Stage window =new Stage();
        window.setTitle(title);
        BorderPane borderPane=new BorderPane();

        Menu file=new Menu("File");

        Menu edit=new Menu("Edit");
        edit.getItems().add(new MenuItem("Cut..."));
        edit.getItems().add(new MenuItem("Copy..."));
        edit.getItems().add(new MenuItem("Paste..."));

        file.getItems().add(new MenuItem("Import..."));
        file.getItems().add(new MenuItem("Expot..."));
        file.getItems().add(new MenuItem("New..."));
        file.getItems().add(new SeparatorMenuItem());
        file.getItems().add(new MenuItem("Save And Exit"));
        MenuItem close=new MenuItem("Close Project");
        close.setDisable(true);
        file.getItems().add(close);

        Menu help=new Menu("Help");
        CheckMenuItem autoSave = new CheckMenuItem("Enable Autosave");
        autoSave.setSelected(true);
        help.getItems().add(autoSave);


        Menu difficultyMenu = new Menu("Difficulty");
        ToggleGroup difficultyToggle = new ToggleGroup();

        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem medium = new RadioMenuItem("Medium");
        RadioMenuItem hard = new RadioMenuItem("Hard");

        easy.setToggleGroup(difficultyToggle);
        medium.setToggleGroup(difficultyToggle);
        hard.setToggleGroup(difficultyToggle);

        difficultyMenu.getItems().addAll(easy, medium, hard);

        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().add(file);
        menuBar.getMenus().add(edit);
        menuBar.getMenus().add(difficultyMenu);
        menuBar.getMenus().add(help);

        borderPane.setTop(menuBar);

        Scene scene=new Scene(borderPane,300,200);
        window.setScene(scene);
        window.show();
    }
}
