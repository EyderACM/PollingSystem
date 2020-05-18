package views;

import controller.SystemController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.VotingSubject;

import java.io.IOException;
import java.util.Map;

public class PieChartView implements Observable {

    PieChartController pc;

    public void init(FXMLLoader fxmlLoader, Stage stage) throws IOException {
        Pane root = fxmlLoader.load(getClass().getResource("pieChartView.fxml").openStream());
        stage.setScene(new Scene(root, 300, 275));
        this.pc = fxmlLoader.getController();
        stage.setWidth(600);
        stage.setHeight(450);
        stage.setResizable(true);
        stage.show();
        SystemController.observer.addObserver(this);
        pc.displayData();
    }

    @Override
    public void update(Map<String, VotingSubject> candidates) {
        pc.displayData();
    }
}
