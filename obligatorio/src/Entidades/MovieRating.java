package Entidades;

import java.util.List;

public class MovieRating {

    private float weightedAverage;
    private int totalVotes;
    private float meanVote;
    private float medianVote;
    private List<String> votesRating;
    private Rating ratingTop1000_us;
    private Rating ratingTop1000_NonUs;
    private Rating ratingAllGenders;
    private Rating ratingMales;
    private Rating ratingFemales;

    public MovieRating(float weightedAverage, int totalVotes, float meanVote, float medianVote, List<String> votesRating, Rating ratingTop1000_us, Rating ratingTop1000_nonUs, Rating ratingAllGenders, Rating ratingMales, Rating ratingFemales) {
        this.weightedAverage = weightedAverage;
        this.totalVotes = totalVotes;
        this.meanVote = meanVote;
        this.medianVote = medianVote;
        this.votesRating = votesRating;
        this.ratingTop1000_us = ratingTop1000_us;
        this.ratingTop1000_NonUs = ratingTop1000_nonUs;
        this.ratingAllGenders = ratingAllGenders;
        this.ratingMales = ratingMales;
        this.ratingFemales = ratingFemales;
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

    public Rating getRatingTop1000_us() {
        return ratingTop1000_us;
    }

    public void setRatingTop1000_us(Rating ratingTop1000_us) {
        this.ratingTop1000_us = ratingTop1000_us;
    }

    public Rating getRatingTop1000_NonUs() {
        return ratingTop1000_NonUs;
    }

    public void setRatingTop1000_NonUs(Rating ratingTop1000_NonUs) {
        this.ratingTop1000_NonUs = ratingTop1000_NonUs;
    }

    public Rating getRatingAllGenders() {
        return ratingAllGenders;
    }

    public void setRatingAllGenders(Rating ratingAllGenders) {
        this.ratingAllGenders = ratingAllGenders;
    }

    public Rating getRatingMales() {
        return ratingMales;
    }

    public void setRatingMales(Rating ratingMales) {
        this.ratingMales = ratingMales;
    }

    public Rating getRatingFemales() {
        return ratingFemales;
    }

    public void setRatingFemales(Rating ratingFemales) {
        this.ratingFemales = ratingFemales;
    }
}
