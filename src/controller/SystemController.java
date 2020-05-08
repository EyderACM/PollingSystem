package controller;

import models.VotingSubject;

import java.util.Map;

public class SystemController {

    public static PollingObserver observer = new PollingObserver();

    public static void vote(String candidateName){
        Map<String, VotingSubject> candidates = observer.getCandidates();
        candidates.get(candidateName).addVote();
        observer.setCandidates(candidates);
    }

}
