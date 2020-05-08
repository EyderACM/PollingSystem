package views;

import controller.PollingObserver;
import controller.SystemController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import models.VotingSubject;

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
