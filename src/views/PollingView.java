package views;

import controller.SystemController;
import models.VotingSubject;

import java.util.Map;

public class PollingView implements Observable {

    PollingViewController pvc;

    public void init(PollingViewController pvc){
        SystemController.observer.addObserver(this);
        this.pvc = pvc;
    }

    @Override
    public void update(Map<String, VotingSubject> candidates) {
        pvc.displayData();
    }
}
