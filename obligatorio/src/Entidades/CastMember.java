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
        separarLugar(lectura[7],this.birthCity,this.birthState,this.birthCountry);
        separarLugar(lectura[9],this.deathCity,this.deathState,this.deathCountry);
        try {
            this.deathDate = new SimpleDateFormat("yyyy-MM-dd").parse(lectura[9]);
        } catch (Exception e) {}
        Integer shift = 0;
        this.spousesList = new MyLinkedListimpl<String>();
        if((lectura[12] != null && lectura[13] != null && lectura[14] == null)||lectura[17]!=null){
            lectura[12] = lectura[12] + lectura[13];
            shift=1;
        }
        if(lectura[12].length() != 0) {
            this.spousesList.add(lectura[12]);
        }
        if (lectura[13+shift] != null){
            this.spouses = Integer.parseInt(lectura[13+shift]);
            this.divorces = Integer.parseInt(lectura[14+shift]);
            this.spousesWithChildren = Integer.parseInt(lectura[15+shift]);
            this.children = Integer.parseInt(lectura[16+shift]);
        }
        this.causeOfDeaths = new MyLinkedListimpl<CauseOfDeath>();
        if(lectura[11].length() != 0){
            this.causeOfDeaths.add(new CauseOfDeath(lectura[11]));
        }

    }

    public void continueCastMember(String[] lectura){
        Integer shift = 0;
        if((lectura[0] != null && lectura[1] != null && lectura[2] == null)||lectura[5]!=null){
            lectura[0] = lectura[1] + lectura[2];
            shift= 1;
        }
        this.spousesList.add(lectura[0]);
        if (lectura[1+shift] != null){
            this.spouses = Integer.parseInt(lectura[1+shift]);
            this.divorces = Integer.parseInt(lectura[2+shift]);
            this.spousesWithChildren = Integer.parseInt(lectura[3+shift]);
            this.children = Integer.parseInt(lectura[4+shift]);
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

    public void separarLugar(String lugar, String ciudad, String region, String pais){
        if (lugar.length()==0){
            ciudad = null;
            region = null;
            pais = null;
            return;
        }
        String[] aux = lugar.split(",");
        pais = aux[aux.length-1];
        if (aux.length>2) {
            region = aux[aux.length - 2];
        } else{region=null;}
        if (aux.length>1){
            ciudad=aux[0];
            if (aux.length>=4){ciudad = ciudad + "," + aux[1];}
        }else{ciudad=null;}
    }

}
