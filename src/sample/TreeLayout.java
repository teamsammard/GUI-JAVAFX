package sample;

import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TreeLayout {
    public static void display(String title){
        Stage window=new Stage();
        window.setTitle(title);

        TreeItem<String> me;

        TreeItem<String> root = new TreeItem<>();
        root.setExpanded(true);
        
        me=makeChildItems("ME",root);
        makeChildItems("1",me);
        makeChildItems("2",me);
        makeChildItems("3",me);

        TreeView<String> tree =new TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty().addListener((o,oldValue,newValue)->{
            System.out.println("old value: "+oldValue);
            System.out.println("new value: "+newValue);
        });

        StackPane treeView=new StackPane();
        treeView.getChildren().addAll(tree);

        Scene scene=new Scene(treeView,300,300);

        window.setScene(scene);
        window.show();

    }

    private static TreeItem<String> makeChildItems(String me, TreeItem<String> root) {
        TreeItem<String> treeItem=new TreeItem<>(me);
        treeItem.setExpanded(true);
        root.getChildren().add(treeItem);
        return treeItem;
    }
}
