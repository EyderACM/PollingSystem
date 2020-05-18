package views;

import models.VotingSubject;

import java.util.Map;

public interface Observable {
    public void update(Map<String, VotingSubject> candidates);
}
