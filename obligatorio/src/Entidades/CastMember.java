package Entidades;

import Tads.MyLinkedListimpl;
import Tads.MyList;




public class CastMember {

    private String imdbNameid;
    private String name;
    private String birthName;
    private int height;
    private String bio;
    private  int birthYear;
    private String placeOfBirth;
    private int deathYear;
    private String placeOfDeath;
    private MyList<String> spousesList;
    private int spouses;
    private int divorces;
    private int spousesWithChildren;
    private int children;
    private CauseOfDeath causeOfDeath;
    private int apariciones=0;
    private boolean isDirector_producer = false;
    private MyList<MovieCastMember> listaMovieCastMember;

    public CastMember(String imdbNameid, String name, String birthName, int height, String bio, int birthYear, String placeOfBirth, int deathYear, String placeOfDeath, String spouse, int spouses, int divorces, int spousesWithChildren, int children) {
        this.imdbNameid = imdbNameid;
        this.name = name;
        this.birthName = birthName;
        this.height = height;
        this.bio = bio;
        this.birthYear = birthYear;
        this.placeOfBirth = placeOfBirth;
        this.deathYear = deathYear;
        this.placeOfDeath = placeOfDeath;
        this.spousesList = new MyLinkedListimpl<String>();
        this.spousesList.add(spouse);
        this.spouses = spouses;
        this.divorces = divorces;
        this.spousesWithChildren = spousesWithChildren;
        this.children = children;


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
            this.birthYear = Integer.parseInt(lectura[6].substring(0,4));
        } catch (Exception e) {
        }
        this.placeOfBirth = lectura[7];
        this.placeOfDeath = lectura[10];
        try {
            this.deathYear = Integer.parseInt(lectura[9].substring(0,4));
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
//                Nodo<CauseOfDeath> NodoActual = listaDeLaMuerte.getPrimero();
//                while(NodoActual!=null){
//                    if(NodoActual.getValue().getName().equals(lectura[11])){this.causeOfDeath=NodoActual.getValue();}
//                    NodoActual=NodoActual.getSiguiente();
//                }
                for(CauseOfDeath causaMuerte:listaDeLaMuerte){
                    if(causaMuerte.getName().equals(lectura[11])){this.causeOfDeath=causaMuerte;}
                }
            } else {
                this.causeOfDeath=new CauseOfDeath(lectura[11]);
                listaDeLaMuerte.add(causeOfDeath);
            }

        }else{this.causeOfDeath=null;}
        this.listaMovieCastMember=new MyLinkedListimpl<>();
    }

    public MyList<MovieCastMember> getListaMovieCastMember() {
        return listaMovieCastMember;
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

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }

    public String getPlaceOfDeath() {
        return placeOfDeath;
    }

    public void setPlaceOfDeath(String placeOfDeath) {
        this.placeOfDeath = placeOfDeath;
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

    public boolean isDirector_producer() {
        return isDirector_producer;
    }

    public void setDirector_producer() {
        isDirector_producer = true;
    }

    public int getApariciones() {
        return apariciones;
    }

    public void addApariciones() {
        this.apariciones++;
    }

    public void setApariciones(int apariciones){this.apariciones=apariciones;}


}
