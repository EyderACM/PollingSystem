package views;

import controller.SystemController;
import controller.commands.Command;
import controller.commands.CommandInvoker;
import controller.commands.VoteCandidate;
import dataaccess.PollDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.KeyEvent;
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

        SystemController.observer.addObserver(new PollDAO());
        PollingView pollingView = new PollingView();

        try {
            pieView.init(fxmlLoaderPie, pieStage);
            barsView.init(fxmlLoaderBars, barsStage);
            pollingView.init(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayData(){
        candidatesList.forEach(x -> {
            String candidateName = x.getId().substring(0, x.getId().length()-1);
            x.setText(Integer.toString(SystemController.observer.getCandidates().get(candidateName).getVotes()));
        });
    }

    public void vote(ActionEvent event){
        String candidateName = ((Button)event.getSource()).getId();
        Command vote = new VoteCandidate(candidateName);
        SystemController.voter = new CommandInvoker(vote);
        SystemController.voter.press();
    }

}
