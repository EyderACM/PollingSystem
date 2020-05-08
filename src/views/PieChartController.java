package views;

import controller.SystemController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import models.VotingSubject;

import java.util.Map;

public class PieChartController {
    @FXML
    PieChart pieChart;

    public void initialize(){
    }

    public void displayData(){
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for(Map.Entry<String, VotingSubject> entry : SystemController.observer.getCandidates().entrySet()){
            pieChartData.add(new PieChart.Data(entry.getValue().getName(), entry.getValue().getVotes()));
        }
        pieChart.setData(pieChartData);
    }
}
