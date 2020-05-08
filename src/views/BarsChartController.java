package views;

import controller.SystemController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import models.VotingSubject;

import java.util.Map;

public class BarsChartController {
    @FXML
    public BarChart barsChart;


    public void initialize(){
    }

    public void displayData(){
        barsChart.getData().clear();
        XYChart.Series dataSeries = new XYChart.Series();
        for(Map.Entry<String, VotingSubject> entry : SystemController.observer.getCandidates().entrySet()){
            dataSeries.getData().add(new XYChart.Data(entry.getValue().getName(), entry.getValue().getVotes()));
        }
        barsChart.getData().add(dataSeries);
    }
}
