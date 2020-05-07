package sample;

import views.PollingView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application implements PollingView {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../views/view.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.setMinWidth(660);
        primaryStage.setMaxWidth(660);
        primaryStage.setMinHeight(425);
        primaryStage.setMaxHeight(425);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
