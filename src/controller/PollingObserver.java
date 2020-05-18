package controller;

import models.VotingSubject;
import views.Observable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PollingObserver {
    private Map<String, VotingSubject> candidates = new HashMap<>();
    private List<Observable> views = new ArrayList<>();

    public void addObserver(Observable view){
        this.views.add(view);
    }

    public void removeObserver(Observable view){
        this.views.remove(view);
    }

    public Map<String, VotingSubject> getCandidates(){
        return candidates;
    }

    public void setCandidates(Map<String, VotingSubject> candidates){
        this.candidates = candidates;
        for(Observable view : this.views){
            view.update(this.candidates);
        }
    }
}
