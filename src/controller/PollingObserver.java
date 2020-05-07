package controller;

import models.VotingSubject;
import views.CandidateView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PollingObserver {
    private Map<String, VotingSubject> candidates;
    private List<CandidateView> views = new ArrayList<>();

    public void addObserver(CandidateView view){
        this.views.add(view);
    }

    public void removeObserver(CandidateView view){
        this.views.remove(view);
    }

    public Map<String, VotingSubject> getCandidates(){
        return candidates;
    }

    public void setCandidates(Map<String, VotingSubject> candidates){
        this.candidates = candidates;
        for(CandidateView view : this.views){
            view.update(this.candidates);
        }
    }
}
