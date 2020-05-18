package controller;

import models.VotingSubject;
import utils.MapCloner;

import java.util.Map;

public class Memento {

    private Map<String, VotingSubject> candidates;

    public Memento(Map<String, VotingSubject> candidates){
        this.candidates = candidates;
    }

    public Map<String, VotingSubject> getSavedCandidates(){
        return candidates;
    }

}
