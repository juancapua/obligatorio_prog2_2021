package Entidades;

import Tads.MyLinkedListimpl;
import Tads.MyList;

import java.util.ArrayList;

public class MovieCastMember {

    private int ordering;
    private CastMember castMember;
    private String category;
    private String job;
    private String[] characters;

    public MovieCastMember(int ordering, String category, String job,String[] characters, CastMember castMember) {
        this.ordering = ordering;
        this.category = category;
        this.job = job;
        this.characters =characters;
        this.castMember = castMember;
    }

    public MovieCastMember(String[] lectura){

        this.ordering = Integer.parseInt(lectura[1]);
        this.castMember = null;
        this.category = lectura[3];
        if(lectura[4].length() != 0) {
            this.job = lectura[4];
        }else{this.job = null;}
        if(lectura[5].length() != 0) {
            this.characters = lectura[5].replace("\"", "").replace("[", "").replace("]", "").replace("'", "").split(",");
        }

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

    public String[] getCharacters() {
        return characters;
    }

    public void setCharacters(String[] characters) {
        this.characters=characters;
    }

    public CastMember getCastMemeber() {
        return castMember;
    }


    public void setCastMemeber(CastMember castMemeber) {
        this.castMember = castMemeber;
    }


    public String[] separarCharacters(String lectura){

        // FIXME hacer la separacion

        return null;

    }


}
