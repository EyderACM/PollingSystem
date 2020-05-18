package controller.commands;

import controller.Memento;
import controller.SystemController;
import models.VotingSubject;
import utils.MapCloner;

import java.util.HashMap;
import java.util.Map;

public class VoteCandidate implements Command{

    String candidateName;

    public VoteCandidate(String candidateName){
        this.candidateName = candidateName;
    }

    public void vote(String candidateName){
        Map<String, VotingSubject> candidates = SystemController.observer.getCandidates();
        SystemController.savedVoted.add(new Memento(MapCloner.buildCopy()));
        candidates.get(candidateName).addVote();
        SystemController.observer.setCandidates(candidates);
    }

    public void execute(){
        this.vote(candidateName);
    }
}
