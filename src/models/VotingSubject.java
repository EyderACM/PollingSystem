package models;

public class VotingSubject {
    private String name;
    private int votes;

    public VotingSubject(String name) {
        this.name = name;
        this.votes = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVotes() {
        return votes;
    }

    public void addVote(){
        votes++;
    }
}
