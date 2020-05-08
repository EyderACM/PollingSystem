package sample;

import controller.SystemController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.VotingSubject;

import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../views/pollingView.fxml"));

        Map<String, VotingSubject> candidates = new HashMap<>();
        candidates.put("bowieCounter", new VotingSubject("David Bowie"));
        candidates.put("radioheadCounter", new VotingSubject("Radiohead"));
        candidates.put("tylerCounter", new VotingSubject("Tyler The Creator"));
        SystemController.observer.setCandidates(candidates);

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
