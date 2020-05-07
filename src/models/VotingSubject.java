package models;

public class VotingSubject {
    private String name;
    private String subjectDescription;
    private int votes;

    public VotingSubject(String name, String subjectDescription) {
        this.name = name;
        this.subjectDescription = subjectDescription;
        this.votes = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubjectDescription() {
        return subjectDescription;
    }

    public void setSubjectDescription(String subjectDescription) {
        this.subjectDescription = subjectDescription;
    }

    public int getVotes() {
        return votes;
    }

    public void addVote(){
        votes++;
    }
}
