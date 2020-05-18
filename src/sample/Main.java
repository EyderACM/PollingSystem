package sample;

import controller.SystemController;
import controller.commands.Command;
import controller.commands.CommandInvoker;
import controller.commands.UndoVote;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import models.VotingSubject;

import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../views/pollingView.fxml"));
        primaryStage.setTitle("Hello World");
        Scene myScene = new Scene(root, 300, 275);
        myScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.isControlDown() && (keyEvent.getCode()) == KeyCode.Z){
                    SystemController.voter = new CommandInvoker(new UndoVote());
                    SystemController.voter.press();
                }
            }
        });
        primaryStage.setScene(myScene);
        primaryStage.setWidth(660);
        primaryStage.setHeight(430);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        Map<String, VotingSubject> candidates = new HashMap<>();
        candidates.put("bowieCounter", new VotingSubject("David Bowie"));
        candidates.put("radioheadCounter", new VotingSubject("Radiohead"));
        candidates.put("tylerCounter", new VotingSubject("Tyler The Creator"));
        SystemController.observer.setCandidates(candidates);
        launch(args);
    }
}
