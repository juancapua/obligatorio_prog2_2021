package Entidades;

import java.util.List;

public class MovieRating {

    private float weightedAverage;
    private int totalVotes;
    private float meanVote;
    private float medianVote;
    private List<String> votesRating;

    public MovieRating(float weightedAverage, int totalVotes, float meanVote, float medianVote, List<String> votesRating) {
        this.weightedAverage = weightedAverage;
        this.totalVotes = totalVotes;
        this.meanVote = meanVote;
        this.medianVote = medianVote;
        this.votesRating = votesRating;
    }

    public float getWeightedAverage() {
        return weightedAverage;
    }

    public void setWeightedAverage(float weightedAverage) {
        this.weightedAverage = weightedAverage;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }

    public float getMeanVote() {
        return meanVote;
    }

    public void setMeanVote(float meanVote) {
        this.meanVote = meanVote;
    }

    public float getMedianVote() {
        return medianVote;
    }

    public void setMedianVote(float medianVote) {
        this.medianVote = medianVote;
    }

    public List<String> getVotesRating() {
        return votesRating;
    }

    public void setVotesRating(List<String> votesRating) {
        this.votesRating = votesRating;
    }
}
