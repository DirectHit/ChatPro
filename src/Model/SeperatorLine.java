package Model;

import Controller.SeparatorController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mmursith on 1/4/2016.
 */
public class SeperatorLine {
    private SeparatorController separatorController;
    private Parent root;



    public SeperatorLine(BindOperator bindOperator, int tracker) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SeperatorLine.class.getResource("seperator.fxml"));
        root = fxmlLoader.load();
        separatorController = fxmlLoader.<SeparatorController>getController();
        separatorController.setBindOperator(bindOperator);
        separatorController.setTracker(tracker);
        separatorController.setHistoryMessages(bindOperator.getHistoryMessages());
        separatorController.setRoot(root);

        if(bindOperator.getHistoryMessages().isEmpty()){

            bindOperator.getChatHolder().getChildren().remove(root);
            separatorController.setTracker(tracker);
        }


        if(tracker ==0 && !bindOperator.getHistoryMessages().isEmpty()) {
            String time = bindOperator.getHistoryMessages().get(bindOperator.getHistoryMessages().size()-1).getTime();
            separatorController.setTime(time);
        }
        else {
            separatorController.setTime();

        }



        bindOperator.setHistoryMessages(new ArrayList<>());



    }

    public Parent getSeperator()  {

        System.out.println("sending seperator");
        return root;
    }

}
