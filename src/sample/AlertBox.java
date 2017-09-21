package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    public static void display(String title){
        Stage window=new Stage();
        window.setTitle(title);
        window.initModality(Modality.APPLICATION_MODAL);
        Button button=new Button();
        button.setText("Close Alert");
        button.setOnAction(e->window.close());
        StackPane layout=new StackPane();
        layout.getChildren().add(button);
        Scene scene=new Scene(layout,200,200);
        window.setScene(scene);
        window.showAndWait();
    }

}
