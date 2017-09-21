package sample;


import javafx.scene.control.Button;

public class Controller {

    public Button button;

    public  boolean flag=false;

    public  void handleAction(){
        System.out.println("working");
        if(!flag){
            button.setText("stop touching");
            flag=true;
        }else{
            button.setText("good to go");
            flag=false;
        }
    }


}
