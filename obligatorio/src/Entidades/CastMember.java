package Entidades;

import Tads.HashNode;
import Tads.MyLinkedListimpl;
import Tads.MyList;
import Tads.Nodo;

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
    private CauseOfDeath causeOfDeath;
    private int apariciones=0;

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


    }

    public CastMember() {
    }

    public CastMember(String[] lectura,MyList<CauseOfDeath> listaDeLaMuerte) {

        this.imdbNameid = lectura[0];
        this.name = lectura[1];
        this.birthName = lectura[2];
        if (lectura[3].length() != 0) {
            this.height = Integer.parseInt(lectura[3]);
        } else {
            this.height = 0;
        }
        this.bio = lectura[4];
        try {
            this.birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(lectura[6]);
        } catch (Exception e) {
        }
        if (lectura[7].length()!=0){
            String[] aux = lectura[7].split(", ");
            this.birthCountry = aux[aux.length-1];
            if (aux.length>2) {
                this.birthState = aux[aux.length - 2];
            }
            if (aux.length>1){
                this.birthCity=aux[0];
                if (aux.length>=4){this.birthCity = birthCity + "," + aux[1];}
            }
        }
        if (lectura[10].length()!=0){
            String[] aux = lectura[10].split(", ");
            this.deathCountry = aux[aux.length-1];
            if (aux.length>2) {
                this.deathState = aux[aux.length - 2];
            }
            if (aux.length>1){
                this.deathCity=aux[0];
                if (aux.length>=4){this.deathCity = deathCity + "," + aux[1];}
            }
        }
        try {
            this.deathDate = new SimpleDateFormat("yyyy-MM-dd").parse(lectura[9]);
        } catch (Exception e) {
        }
        Integer shift = 0;
        this.spousesList = new MyLinkedListimpl<String>();
        if ((lectura[12] != null && lectura[13] != null && lectura[14] == null) || lectura[17] != null) {
            lectura[12] = lectura[12] + lectura[13];
            shift = 1;
        }
        if (lectura[12].length() != 0) {
            this.spousesList.add(lectura[12]);
        }
        if (lectura[13 + shift] != null) {
            this.spouses = Integer.parseInt(lectura[13 + shift]);
            this.divorces = Integer.parseInt(lectura[14 + shift]);
            this.spousesWithChildren = Integer.parseInt(lectura[15 + shift]);
            this.children = Integer.parseInt(lectura[16 + shift]);
        }
        if (lectura[11].length() != 0) {
            CauseOfDeath causa = new CauseOfDeath(lectura[11]);
            if (listaDeLaMuerte.size()!=0 && listaDeLaMuerte.contains(causa)) {
                Nodo<CauseOfDeath> NodoActual = listaDeLaMuerte.getPrimero();
                while(NodoActual!=null){
                    if(NodoActual.getValue().getName().equals(lectura[11])){this.causeOfDeath=NodoActual.getValue();}
                    NodoActual=NodoActual.getSiguiente();
                }
            } else {
                this.causeOfDeath=new CauseOfDeath(lectura[11]);
                listaDeLaMuerte.add(causeOfDeath);
            }

        }else{this.causeOfDeath=null;}
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

    public CauseOfDeath getCauseOfDeath() {
        return causeOfDeath;
    }

    public void addCauseOfDeath(CauseOfDeath causa) {
        this.causeOfDeath=causa;
    }

    public void separarLugar(String lugar, String ciudad, String region, String pais){
        if (lugar.length()==0){
            System.out.println("Esto esta mal");
            ciudad = null;
            region = null;
            pais = null;
            return;
        }
        String[] aux = lugar.split(", ");
        System.out.println(aux[2]);
        pais = aux[aux.length-1];
        if (aux.length>2) {
            region = aux[aux.length - 2];
        } else{region=null;}
        if (aux.length>1){
            ciudad=aux[0];
            if (aux.length>=4){ciudad = ciudad + "," + aux[1];}
        }else{ciudad=null;}
    }

    public int getApariciones() {
        return apariciones;
    }

    public void addApariciones() {
        this.apariciones++;
    }

    public void setApariciones(int apariciones){this.apariciones=apariciones;}


}
