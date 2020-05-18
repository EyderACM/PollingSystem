package utils;

import controller.SystemController;
import models.VotingSubject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapCloner {
    public static Map<String, VotingSubject> buildCopy(){
        Map<String, VotingSubject> copyMap = new HashMap<>();
        VotingSubject bowie = new VotingSubject("David Bowie");
        bowie.setVotes(SystemController.observer.getCandidates().get("bowieCounter").getVotes());
        VotingSubject radiohead = new VotingSubject("Radiohead");
        radiohead.setVotes(SystemController.observer.getCandidates().get("radioheadCounter").getVotes());
        VotingSubject tyler = new VotingSubject("Tyler The Creator");
        tyler.setVotes(SystemController.observer.getCandidates().get("tylerCounter").getVotes());
        copyMap.put("bowieCounter", bowie);
        copyMap.put("radioheadCounter", radiohead);
        copyMap.put("tylerCounter", tyler);
        return copyMap;
    };
}
