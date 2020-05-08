package views;

import controller.SystemController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;

public class PollingViewController{
    @FXML
    public Text bowieCounterC, radioheadCounterC, tylerCounterC;

    public LinkedList<Text> candidatesList = new LinkedList<>();


    public void initialize(){
        candidatesList.add(bowieCounterC);
        candidatesList.add(radioheadCounterC);
        candidatesList.add(tylerCounterC);

        Stage pieStage = new Stage();
        FXMLLoader fxmlLoaderPie = new FXMLLoader();
        PieChartView pieView = new PieChartView();

        Stage barsStage = new Stage();
        FXMLLoader fxmlLoaderBars = new FXMLLoader();
        BarsChartView barsView = new BarsChartView();

        try {
            pieView.init(fxmlLoaderPie, pieStage);
            barsView.init(fxmlLoaderBars, barsStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void vote(ActionEvent event){
        String candidateName = ((Button)event.getSource()).getId();
        SystemController.vote(candidateName);
        candidatesList.forEach(x -> {
            if((x.getId().substring(0, x.getId().length()-1).equals(candidateName)))
                x.setText((Integer.toString(SystemController.observer.getCandidates().get(candidateName).getVotes())));
        });
    }

}
