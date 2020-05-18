package controller.commands;

import controller.SystemController;
import models.VotingSubject;

import java.util.Map;

public class UndoVote implements Command{
    public UndoVote(){
    }

    public void undo(){
        int pos = SystemController.savedVoted.size()-1;
        if(pos > 0){
            Map<String, VotingSubject> newCandidates = SystemController.savedVoted.get(SystemController.savedVoted.size()-1).getSavedCandidates();
            SystemController.observer.setCandidates(newCandidates);
            SystemController.savedVoted.remove(SystemController.savedVoted.size()-1);
        }
    }

    @Override
    public void execute() {
        undo();
    }
}
