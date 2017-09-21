package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Button button,button2,alert,gridLayout,treeLayout,tableView,menuLayout;

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        window=primaryStage;
        window.setTitle("My APP");

        Label label= new javafx.scene.control.Label("Hey Scene 1");

        button= new javafx.scene.control.Button();
        button.setText("Go to scene 2");

        alert= new javafx.scene.control.Button();
        alert.setText("Open Alert");
        alert.setOnAction(e->AlertBox.display("Alert Window"));

        treeLayout= new javafx.scene.control.Button();
        treeLayout.setText("Tree View");
        treeLayout.setOnAction(e->TreeLayout.display("Tree Layout"));

        tableView= new javafx.scene.control.Button();
        tableView.setText("Table View");
        tableView.setOnAction(e->TableLayout.display("Table Layout"));

        gridLayout= new javafx.scene.control.Button();
        gridLayout.setText("Open Grid Pane");
        gridLayout.setOnAction(e->GridLayout.display("Grid Pane"));

        menuLayout= new javafx.scene.control.Button();
        menuLayout.setText("Open Menu");
        menuLayout.setOnAction(e->MenuLayout.display("Meny Page"));

        VBox layout1=new VBox();
        layout1.setSpacing(10);
        layout1.getChildren().add(button);
        layout1.getChildren().add(alert);
        layout1.getChildren().add(gridLayout);
        layout1.getChildren().add(treeLayout);
        layout1.getChildren().add(tableView);
        layout1.getChildren().add(menuLayout);
        layout1.getChildren().add(label);
        Scene scene1= new Scene(layout1,300,300);


        button2= new javafx.scene.control.Button();
        button2.setText("Go to scene 1");

        StackPane layout2=new StackPane();
        layout2.getChildren().add(button2);
        Scene scene2=new Scene(layout2,300,300);

        button.setOnAction(e->window.setScene(scene2));
        button2.setOnAction(e->window.setScene(scene1));

        window.setOnCloseRequest(e->{
            e.consume();
            System.out.println("File Saved!!");
            window.close();
        });

//        Parent root= FXMLLoader.load(getClass().getResource("sample.fxml"));
//        window.setScene(new Scene(root,300,200));

        window.setScene(scene1);
        window.show();

    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

}
