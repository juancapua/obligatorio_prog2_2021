package Entidades;

import Tads.MyLinkedListimpl;
import Tads.MyList;

import java.util.ArrayList;

public class MovieCastMember {

    private int ordering;
    private CastMember castMember;
    private String category;
    private String job;
    private MyList<String> characters;

    public MovieCastMember(int ordering, String category, String job, CastMember castMember) {
        this.ordering = ordering;
        this.category = category;
        this.job = job;
        this.characters = new MyLinkedListimpl<>();
        this.castMember = castMember;
    }

    public MovieCastMember(String[] lectura){

        this.ordering = Integer.parseInt(lectura[1]);
        this.castMember = null;
        this.category = lectura[3];
        this.job = lectura[4];
        this.characters = new MyLinkedListimpl<>();
        this.characters.add();

        //FIXME agregar los characters


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

    public MyList<String> getCharacters() {
        return characters;
    }

    public void setCharacters(String character) {
        this.characters.add(character);
    }

    public CastMember getCastMemeber() {
        return castMember;
    }


    public void setCastMemeber(CastMember castMemeber) {
        this.castMember = castMemeber;
    }


    public String[] separarCharacters(String lectura){

        // FIXME hacer la separacion

    }


}
