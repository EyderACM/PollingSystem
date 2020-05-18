package dataaccess;

import controller.SystemController;
import database.Config;

import models.VotingSubject;
import utils.CSVHandler;
import views.Observable;

import java.io.File;
import java.util.Map;

public class PollDAO implements Observable {

    @Override
    public void update(Map<String, VotingSubject> candidates) {
        File pollfile = new File(Config.databasePath);
        pollfile.delete();
        for(Map.Entry<String, VotingSubject> entry : SystemController.observer.getCandidates().entrySet()){
            String[] flattenedSubject = new String[]{entry.getValue().getName(), Integer.toString(entry.getValue().getVotes())};
            CSVHandler.writeToCSV(pollfile, flattenedSubject);
        }
    }
}
