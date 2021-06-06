package Entidades;

import Tads.MyLinkedListimpl;
import Tads.MyList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Movie {

    private String imdbTitleld;
    private String title;
    private String originalTitle;
    private int year;
    private Date datePublished;
    private String[] genre;
    private int duration;
    private String[] country;
    private String language;
    private String[] director;
    private String[] writer;
    private String productionCompany;
    private String[] actors;
    private String description;
    private float avgVote;
    private int votes;
    private String budget;
    private String usaGrossIncome;
    private String worldwideGrossIncome;
    private float metaScore;
    private float reviewsFromUsers;
    private float reviewsFromCritics;
    private MovieRating movieRating;
    private MyList<MovieCastMember> listaMovieCastMember;

    public Movie(String imdbTitleld, String title, String originalTitle, int year, Date datePublished, String[] genre, int duration, String[] country, String language, String[] director, String[] writer, String productionCompany, String[] actors, String description, float avgVote, int votes, String budget, String usaGrossIncome, String worldwideGrossIncome, float metaScore, float reviewsFromUsers, float reviewsFromCritics, MyList<MovieCastMember> listaMovieCastMember) {
        this.imdbTitleld = imdbTitleld;
        this.title = title;
        this.originalTitle = originalTitle;
        this.year = year;
        this.datePublished = datePublished;
        this.genre = genre;
        this.duration = duration;
        this.country = country;
        this.language = language;
        this.director = director;
        this.writer = writer;
        this.productionCompany = productionCompany;
        this.actors = actors;
        this.description = description;
        this.avgVote = avgVote;
        this.votes = votes;
        this.budget = budget;
        this.usaGrossIncome = usaGrossIncome;
        this.worldwideGrossIncome = worldwideGrossIncome;
        this.metaScore = metaScore;
        this.reviewsFromUsers = reviewsFromUsers;
        this.reviewsFromCritics = reviewsFromCritics;
        this.listaMovieCastMember = listaMovieCastMember;
        this.movieRating = null;
    }

    public Movie(String[] datos) {
        this.imdbTitleld = datos[0];
        this.title = datos[1];
        this.originalTitle = datos[2];
        System.out.println("estoy");
        this.year = Integer.parseInt(datos[3]);
        try {
            this.datePublished = new SimpleDateFormat("yyyy-MM-dd").parse(datos[4]);
        }catch (Exception e){}
        this.genre = datos[5].replace("\"", "").split(",");
        if(datos[6].length() != 0) {
            this.duration = Integer.parseInt(datos[6]);
        }
        this.country = datos[7].replace("\"", "").split(",");
        this.language = datos[8];
        this.director = datos[9].replace("\"", "").split(",");
        this.writer = datos[10].replace("\"", "").split(",");
        this.productionCompany = datos[11];
        this.actors = datos[12].replace("\"", "").split(",");
        this.description = datos[13];
        if(datos[14].length() != 0) {
            this.avgVote = Float.parseFloat(datos[14]);
        }else{this.avgVote = 0;}
        if(datos[15].length() != 0) {
            this.votes = Integer.parseInt(datos[15]);
        }else {this.votes = 0;}
        if(datos[16].length() != 0) {
            this.budget = datos[16];
        }else {this.budget = null;}
        if(datos[17].length() != 0) {
            this.usaGrossIncome = datos[17];
        }else {this.usaGrossIncome = null;}
        if(datos[18].length() != 0) {
            this.worldwideGrossIncome = datos[18];
        }else {this.worldwideGrossIncome = null;}
        if(datos[19].length() != 0) {
            this.metaScore = Float.parseFloat(datos[19]);
        }else{this.metaScore = 0;}
        if(datos[20].length() != 0) {
            this.reviewsFromUsers = Float.parseFloat(datos[20]);
        }else {this.reviewsFromUsers = 0;}
        if(datos[21].length() != 0) {
            this.reviewsFromCritics = Float.parseFloat(datos[21]);
        }else {this.reviewsFromCritics = 0;}
        this.movieRating = null;
        this.listaMovieCastMember = new MyLinkedListimpl<MovieCastMember>();
    }

    public String getImdbTitleld() {
        return imdbTitleld;
    }

    public void setImdbTitleld(String imdbTitleld) {
        this.imdbTitleld = imdbTitleld;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public String[] getGenre() {
        return genre;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String[] getCountry() {
        return country;
    }

    public void setCountry(String[] country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String[] getDirector() {
        return director;
    }

    public void setDirector(String[] director) {
        this.director = director;
    }

    public String[] getWriter() {
        return writer;
    }

    public void setWriter(String[] writer) {
        this.writer = writer;
    }

    public String getProductionCompany() {
        return productionCompany;
    }

    public void setProductionCompany(String productionCompany) {
        this.productionCompany = productionCompany;
    }

    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getAvgVote() {
        return avgVote;
    }

    public void setAvgVote(float avgVote) {
        this.avgVote = avgVote;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getUsaGrossIncome() {
        return usaGrossIncome;
    }

    public void setUsaGrossIncome(String usaGrossIncome) {
        this.usaGrossIncome = usaGrossIncome;
    }

    public String getWorldwideGrossIncome() {
        return worldwideGrossIncome;
    }

    public void setWorldwideGrossIncome(String worldwideGrossIncome) {
        this.worldwideGrossIncome = worldwideGrossIncome;
    }

    public float getMetaScore() {
        return metaScore;
    }

    public void setMetaScore(float metaScore) {
        this.metaScore = metaScore;
    }

    public float getReviewsFromUsers() {
        return reviewsFromUsers;
    }

    public void setReviewsFromUsers(float reviewsFromUsers) {
        this.reviewsFromUsers = reviewsFromUsers;
    }

    public float getReviewsFromCritics() {
        return reviewsFromCritics;
    }

    public void setReviewsFromCritics(float reviewsFromCritics) {
        this.reviewsFromCritics = reviewsFromCritics;
    }

    public MovieRating getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(MovieRating movieRating) {
        this.movieRating = movieRating;
    }

    public MyList<MovieCastMember> getListaMovieCastMember() {
        return listaMovieCastMember;
    }

    public void setListaMovieCastMember(MovieCastMember nuevo) {
        this.listaMovieCastMember.add(nuevo);
    }

}
