package sample;

import javafx.application.Application;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Vincent Englebert
 */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // version for ONE view and ONE model

        Parent root = FXMLLoader.load(getClass().getResource("calculator.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        /*

        // version for TWO views and ONE model

        Parent vbox1 = FXMLLoader.load(getClass().getResource("calculator.fxml"));
        Parent vbox2 = FXMLLoader.load(getClass().getResource("calculator.fxml"));
        VBox vbox=new VBox();
        vbox.getChildren().addAll(vbox1,vbox2);
        primaryStage.setScene(new Scene(vbox));
        primaryStage.show();

        */

    }

    public static void main(String[] args) {
        launch(args);
    }
}
