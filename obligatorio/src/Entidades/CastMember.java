package Entidades;

import Tads.MyLinkedListimpl;
import Tads.MyList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CastMember {

    private String imdbNameid;
    private String name;
    private String birthName;
    private int height;
    private String bio;
    private  Date birthDate;
    private String birthState;
    private String birthCountry;
    private String birthCity;
    private Date deathDate;
    private String deathState;
    private String deathCountry;
    private String deathCity;
    private MyList<String> spousesList;
    private int spouses;
    private int divorces;
    private int spousesWithChildren;
    private int children;
    private MyList<CauseOfDeath> causeOfDeaths;

    public CastMember(String imdbNameid, String name, String birthName, int height, String bio, Date birthDate, String birthState, String birthCountry, String birthCity, Date deathDate, String deathState, String deathCountry, String deathCity, String spouse, int spouses, int divorces, int spousesWithChildren, int children) {
        this.imdbNameid = imdbNameid;
        this.name = name;
        this.birthName = birthName;
        this.height = height;
        this.bio = bio;
        this.birthDate = birthDate;
        this.birthState = birthState;
        this.birthCountry = birthCountry;
        this.birthCity = birthCity;
        this.deathDate = deathDate;
        this.deathState = deathState;
        this.deathCountry = deathCountry;
        this.deathCity = deathCity;
        this.spousesList = new MyLinkedListimpl<String>();
        this.spousesList.add(spouse);
        this.spouses = spouses;
        this.divorces = divorces;
        this.spousesWithChildren = spousesWithChildren;
        this.children = children;
        this.causeOfDeaths = new MyLinkedListimpl<>();


    }

    public CastMember(String[] lectura) {

        System.out.println("entro constructor");
        this.imdbNameid = lectura[0];
        this.name = lectura[1];
        this.birthName = lectura[2];
        if(lectura[3].length() != 0) {
            this.height = Integer.parseInt(lectura[3]);
        }else{this.height = 0;}
        this.bio = lectura[4];
        try {
            this.birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(lectura[6]);
        }catch (Exception e){}
        String[] lugar = separarLugar(lectura[7]);
        System.out.println(lugar.length);
        if(lugar.length == 1) {
            this.birthCity = null;
            this.birthCountry = lugar[0];
            this.birthState = null;
        }if(lugar.length == 2){
            this.birthCity = lugar[0];
            this.birthCountry = lugar[1];
            this.birthState = null;
        }if(lugar.length == 3){
            this.birthState = lugar[1];
            this.birthCountry = lugar[2];
            this.birthCity = lugar[0];
        }

        if(lectura[9].length() != 0) {
            try {
                this.deathDate = new SimpleDateFormat("yyyy-MM-dd").parse(lectura[9]);
            } catch (Exception e) {}
            if(separarLugar(lectura[10]).length == 3) {
                this.deathState = separarLugar(lectura[10])[1];
                this.deathCountry = separarLugar(lectura[10])[2];
                this.deathCity = separarLugar(lectura[10])[0];
            }else{
                this.deathCountry = lectura[10];
            }
        }else{
            this.deathDate = null;
            this.deathState = null;
            this.deathCountry = null;
            this.deathCity = null;
        }
        this.spousesList = new MyLinkedListimpl<String>();
        if(lectura[12] != null && lectura[13] != null && lectura[14] == null){
            lectura[12] = lectura[12] + lectura[13];
            lectura[13] = null;
        }
        if(lectura[12].length() != 0) {
            this.spousesList.add(lectura[12]);
        }
        if (lectura[13] != null){
            this.spouses = Integer.parseInt(lectura[13]);
            this.divorces = Integer.parseInt(lectura[14]);
            this.spousesWithChildren = Integer.parseInt(lectura[15]);
            this.children = Integer.parseInt(lectura[16]);
        }
        this.causeOfDeaths = new MyLinkedListimpl<CauseOfDeath>();
        if(lectura[11].length() != 0){
            this.causeOfDeaths.add(new CauseOfDeath(lectura[11]));
        }
        System.out.println("termino constructor");


    }

    public void continueCastMember(String[] lectura){
        this.spousesList.add(lectura[0]);
        if (lectura[1] != null){
            this.spouses = Integer.parseInt(lectura[1]);
            this.divorces = Integer.parseInt(lectura[2]);
            this.spousesWithChildren = Integer.parseInt(lectura[3]);
            this.children = Integer.parseInt(lectura[4]);
        }
    }

    public String getImdbNameid() {
        return imdbNameid;
    }

    public void setImdbNameid(String imdbNameid) {
        this.imdbNameid = imdbNameid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthName() {
        return birthName;
    }

    public void setBirthName(String birthName) {
        this.birthName = birthName;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthState() {
        return birthState;
    }

    public void setBirthState(String birthState) {
        this.birthState = birthState;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public String getDeathState() {
        return deathState;
    }

    public void setDeathState(String deathState) {
        this.deathState = deathState;
    }

    public String getDeathCountry() {
        return deathCountry;
    }

    public void setDeathCountry(String deathCountry) {
        this.deathCountry = deathCountry;
    }

    public String getDeathCity() {
        return deathCity;
    }

    public void setDeathCity(String deathCity) {
        this.deathCity = deathCity;
    }

    public MyList getSpousesList() {
        return spousesList;
    }

    public void setSpousesString(String spouse) {
        this.spousesList.add(spouse);
    }

    public int getSpouses() {
        return spouses;
    }

    public void setSpouses(int spouses) {
        this.spouses = spouses;
    }

    public int getDivorces() {
        return divorces;
    }

    public void setDivorces(int divorces) {
        this.divorces = divorces;
    }

    public int getSpousesWithChildren() {
        return spousesWithChildren;
    }

    public void setSpousesWithChildren(int spousesWithChildren) {
        this.spousesWithChildren = spousesWithChildren;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public MyList<CauseOfDeath> getCauseOfDeaths() {
        return causeOfDeaths;
    }

    public void addCauseOfDeaths(CauseOfDeath causa) {
        this.causeOfDeaths.add(causa);
    }

    public String[] separarLugar(String lugar){

        String[] aux = lugar.split(",");

        return aux;

    }

}
