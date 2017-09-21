package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableLayout {

   public static TableView<Product> tableView;

    public static void display(String title){
        Stage window=new Stage();
        window.setTitle(title);

        TableColumn<Product,String> nameColumn=new TableColumn("Name");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product,String> priceColumn=new TableColumn("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product,String> quantityColumn=new TableColumn("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        tableView=new TableView<>();
        tableView.setItems(getObservableList());
        tableView.getColumns().addAll(nameColumn,priceColumn,quantityColumn);

        HBox hBox=new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);

        TextField nameField=new TextField();
        nameField.setPromptText("Name");

        TextField priceField=new TextField();
        priceField.setPromptText("Price");

        TextField quantityField=new TextField();
        quantityField.setPromptText("Quantity");

        Button add =new Button("Add");
        add.setOnAction(e->addButtonClicked(nameField,priceField,quantityField));

        Button delete =new Button("Delete");
        delete.setOnAction(e->deleteButtonClicked(nameField,priceField,quantityField));

        hBox.getChildren().addAll(nameField,priceField,quantityField,add,delete);

        VBox vBox=new VBox();
        vBox.getChildren().addAll(tableView,hBox);

        Scene scene=new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    private static void deleteButtonClicked(TextField nameField, TextField priceField, TextField quantityField) {
//        ObservableList<Product> allProductList;
//        ObservableList<Product> finalList=FXCollections.observableArrayList();
//
//        allProductList=tableView.getItems();
//        Product deleteProduct=new Product();
//        deleteProduct.setName(nameField.getText());
//        deleteProduct.setPrice(Integer.parseInt(priceField.getText()));
//        deleteProduct.setQuantity(Integer.parseInt(quantityField.getText()));
//        for(int i=0;i<allProductList.size();i++){
//            if(deleteProduct.getName().equals(allProductList.get(i).getName())){
//                continue;
//            }
//            finalList.add(allProductList.get(i));
//        }
//
//        tableView.getItems().clear();
//
//        tableView.getItems().addAll(finalList);

        ObservableList<Product> allProduct,selectedProduct;

        allProduct=tableView.getItems();
        selectedProduct=tableView.getSelectionModel().getSelectedItems();

        selectedProduct.forEach(allProduct::remove);


    }

    private static void addButtonClicked(TextField nameField, TextField priceField, TextField quantityField) {
        Product product=new Product();
        product.setName(nameField.getText());
        product.setPrice(Integer.parseInt(priceField.getText()));
        product.setQuantity(Integer.parseInt(quantityField.getText()));
        tableView.getItems().addAll(product);
        nameField.clear();
        priceField.clear();
        quantityField.clear();
    }

    public static ObservableList<Product> getObservableList(){

        ObservableList<Product> products= FXCollections.observableArrayList();

        products.add(new Product("A",1,2));
        products.add(new Product("B",3,4));
        products.add(new Product("C",5,6));

        return products;
    }
}
