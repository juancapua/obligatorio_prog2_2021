package Entidades;

import java.util.ArrayList;

public class MovieCastMember {

    private int ordering;
    private String category;
    private String job;
    private ArrayList<String> characters;
    private CastMenber castMemeber;
    private Movie movie;

    public MovieCastMember(int ordering, String category, String job, CastMenber castMemeber, Movie movie) {
        this.ordering = ordering;
        this.category = category;
        this.job = job;
        this.characters = new ArrayList<>();
        this.castMemeber = castMemeber;
        this.movie = movie;
    }

    public int getOrdering() {
        return ordering;
    }

    public void setOrdering(int ordering) {
        this.ordering = ordering;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public ArrayList<String> getCharacters() {
        return characters;
    }

    public void setCharacters(String character) {
        this.characters.add(character);
    }

    public CastMenber getCastMemeber() {
        return castMemeber;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setCastMemeber(CastMenber castMemeber) {
        this.castMemeber = castMemeber;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
