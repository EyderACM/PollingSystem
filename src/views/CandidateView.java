package views;

import models.VotingSubject;

import java.util.Map;

public interface CandidateView {
    public void update(Map<String, VotingSubject> candidates);
}
