

import Entidades.*;
import Tads.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader{

    public static OpenHash<String, CastMember> castMemberHash = new OpenHash<>(370000);
    public static OpenHash<String, Movie> movieHash = new OpenHash<>(110000);
    public static MyList<CauseOfDeath> listaDeLaMuerte = new MyLinkedListimpl<>();

    boolean entre_consulta1 = false;
    boolean entre_consulta2 = false;
    boolean entre_consulta3 = false;


    public void cargaDatos() {

        long TInicio = System.currentTimeMillis();

        System.out.println("Cargando datos...");

        String path1 = "C:\\Users\\Ari 2.0\\IdeaProjects\\obligatorio_prog2_2021\\Data\\IMDb names.csv";
        String path2 = "C:\\Users\\Ari 2.0\\IdeaProjects\\obligatorio_prog2_2021\\Data\\IMDb movies.csv";
        String path3 = "C:\\Users\\Ari 2.0\\IdeaProjects\\obligatorio_prog2_2021\\Data\\IMDb title_principals.csv";
        String path4 = "C:\\Users\\Ari 2.0\\IdeaProjects\\obligatorio_prog2_2021\\Data\\IMDb ratings.csv";

//        String path1 = "Data/IMDb names.csv";
//        String path2 = "Data/IMDb movies.csv";
//        String path3 = "Data/IMDb title_principals.csv";
//        String path4 = "Data/IMDb ratings.csv";

        String linea = null;
        String key = null;

        try {

            BufferedReader bufer1 = new BufferedReader(new FileReader(path1));
            bufer1.readLine();

            while ((linea = bufer1.readLine()) != null) {
                String[] lecturaLinea = separarPeroBien(linea,18);
                if (lecturaLinea[6] != null) {
                    castMemberHash.put(lecturaLinea[0], new CastMember(lecturaLinea,listaDeLaMuerte));
                    key = lecturaLinea[0];

                } else {

                    castMemberHash.get(key).continueCastMember(lecturaLinea);

                }

            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } catch (KeyNotFoundException e) {
            e.printStackTrace();
        }


        try {

            BufferedReader bufer2 = new BufferedReader(new FileReader(path2));
            bufer2.readLine();

            while ((linea = bufer2.readLine()) != null) {
                String[] lecturaLinea2 = separarPeroBien(linea,22);
                movieHash.put(lecturaLinea2[0],new Movie(lecturaLinea2));


            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }

        try {

            BufferedReader bufer3 = new BufferedReader(new FileReader(path3));
            bufer3.readLine();

            while ((linea = bufer3.readLine()) != null) {
                String[] lecturaLinea3 = separarPeroBien(linea,6);
                movieHash.get(lecturaLinea3[0]).setListaMovieCastMember(new MovieCastMember(lecturaLinea3));
                int aux = Integer.parseInt(lecturaLinea3[1]);
                movieHash.get(lecturaLinea3[0]).getListaMovieCastMember().get(aux - 1).setCastMemeber(castMemberHash.get(lecturaLinea3[2]));

            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } catch (KeyNotFoundException e) {
            e.printStackTrace();
        }

        try {

            BufferedReader bufer4 = new BufferedReader(new FileReader(path4));
            bufer4.readLine();

            while ((linea = bufer4.readLine()) != null) {
                String[] lecturaLinea4 = separarPeroBien(linea,50);
                movieHash.get(lecturaLinea4[0]).setMovieRating(new MovieRating(lecturaLinea4));

            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } catch (KeyNotFoundException e) {
            e.printStackTrace();
        }

        long TFin = System.currentTimeMillis();
        long tiempo = TFin - TInicio;

        System.out.println("Carga de datos exitosa, tiempo de ejecución de la carga:" + tiempo);

    }

    public void consulta1(){
        long TInicio = System.currentTimeMillis();

        if(!entre_consulta1) {
//            MyList<HashNode<String, Movie>>[] hashMovies = movieHash.getHash();
//            for (MyList<HashNode<String, Movie>> i : hashMovies) {
//                if (i != null) {
//                    Nodo<HashNode<String, Movie>> movie = i.getPrimero();
//                    while (movie != null) {
//                        MyList<MovieCastMember> listaCastMembersPorPelicula = movie.getValue().getValue().getListaMovieCastMember();
//                        Nodo<MovieCastMember> movieCastMember = listaCastMembersPorPelicula.getPrimero();
//                        while (movieCastMember != null) {
//                            if (movieCastMember.getValue().getCategory().equals("actor") || movieCastMember.getValue().getCategory().equals("actress")) {
//                                movieCastMember.getValue().getCastMemeber().addApariciones();
//                            }
//                            movieCastMember = movieCastMember.getSiguiente();
//                        }
//                        movie = movie.getSiguiente();
//                    }
//                }
//            }
            for (Movie movie:movieHash){
                for(MovieCastMember movieCastMember: movie.getListaMovieCastMember()){
                    if (movieCastMember.getCategory().equals("actor") || movieCastMember.getCategory().equals("actress")) {
                        movieCastMember.getCastMemeber().addApariciones();
                    }
                }
            }

            entre_consulta1 = true;
        }


//        MyList<HashNode<String, CastMember>>[] hashCastMembers = castMemberHash.getHash();
//        int n =castMemberHash.getSize();
//        while(hashCastMembers[n-1]==null){n--;}
//        Nodo<HashNode<String, CastMember>> actor=hashCastMembers[n-1].getPrimero();
//        CastMember[] top5=new CastMember[6];
//        while(n>=0){
//            int j=4;
//            while(j>=0 && top5[j]==null){j--;}
//            while(j>=0&&top5[j].getApariciones()<actor.getValue().getValue().getApariciones()){
//                top5[j+1]=top5[j];
//                j--;
//            }
//            top5[j+1]=actor.getValue().getValue();
//            if(actor.getSiguiente()!=null){actor=actor.getSiguiente();
//            } else{
//                if (n==0){break;}
//                while(hashCastMembers[n-1]==null){n--;}
//                if (n<0){break;}
//                actor=hashCastMembers[--n].getPrimero();
//            }
//        }

        CastMember[] top5=new CastMember[6];
        for(CastMember actor:castMemberHash){
            int j=4;
            while(j>=0 && top5[j]==null){j--;}
            while(j>=0&&top5[j].getApariciones()<actor.getApariciones()){
                top5[j+1]=top5[j];
                j--;
            }
            top5[j+1]=actor;
        }

        for (int j = 0; j < 5; j++) {
            System.out.println("Nombre actor/actriz: " + top5[j].getName());
            System.out.println("Cantidad de apariciones: "+ top5[j].getApariciones());
        }
        long TFin = System.currentTimeMillis();
        long tiempo = TFin - TInicio;

        System.out.println("Tiempo de ejecución de la consulta:" + tiempo);

    }

//    private CastMember[] top5(Nodo<HashNode<String, CastMember>> actor, int posicion, MyList<HashNode<String, CastMember>>[] hashCastMembers) {
//        CastMember[] top5=new CastMember[6];
//        System.out.println(posicion);
//        if(actor.getSiguiente()!=null){top5=top5(actor.getSiguiente(),posicion,hashCastMembers);}
//        else if(posicion>=0){
//            while(hashCastMembers[posicion-1]==null){posicion--;}
//            if (posicion<0){return top5;}
//            top5=top5(hashCastMembers[posicion-1].getPrimero(),posicion-1,hashCastMembers);
//        }else{
//            return top5;}
//        int j=4;
//        while(top5[j]==null){j--;}
//        while(j>=0&&top5[j].getApariciones()<actor.getValue().getValue().getApariciones()){
//            top5[j+1]=top5[j];
//            j--;
//        }
//        top5[j+1]=actor.getValue().getValue();
//        return top5;
//
//    }

    public void consulta2(){
        long TInicio = System.currentTimeMillis();

        if(entre_consulta2==false) {
            entre_consulta2=true;
//            MyList<HashNode<String, Movie>>[] hashMovies = movieHash.getHash();
//
//            for (MyList<HashNode<String, Movie>> i : hashMovies) {
//                if (i != null) {
//                    Nodo<HashNode<String, Movie>> movie = i.getPrimero();
//                    while (movie != null) {
//                        MyList<MovieCastMember> listaCastMembersPorPelicula = movie.getValue().getValue().getListaMovieCastMember();
//                        Nodo<MovieCastMember> movieCastMember = listaCastMembersPorPelicula.getPrimero();
//                        while (movieCastMember != null) {
//                            if ((movieCastMember.getValue().getCastMemeber().getBirthCountry() != null) && (movieCastMember.getValue().getCastMemeber().getCauseOfDeath() != null) && (movieCastMember.getValue().getCastMemeber().getApariciones() == 0) && (movieCastMember.getValue().getCategory().equals("director") || movieCastMember.getValue().getCategory().equals("producer")) && (movieCastMember.getValue().getCastMemeber().getBirthCountry().equals("USA") || movieCastMember.getValue().getCastMemeber().getBirthCountry().equals("UK") || movieCastMember.getValue().getCastMemeber().getBirthCountry().equals("Italy") || movieCastMember.getValue().getCastMemeber().getBirthCountry().equals("France"))) {
//                                movieCastMember.getValue().getCastMemeber().setApariciones(-1);
//                                movieCastMember.getValue().getCastMemeber().getCauseOfDeath().addVictimas();
//                            }
//                            movieCastMember = movieCastMember.getSiguiente();
//                        }
//                        movie = movie.getSiguiente();
//                    }
//                }
//            }
            int i=0;
            for (Movie movie:movieHash){
                for(MovieCastMember movieCastMember: movie.getListaMovieCastMember()){
                    if ((movieCastMember.getCastMemeber().getBirthCountry() != null) && (movieCastMember.getCastMemeber().getCauseOfDeath() != null) && (movieCastMember.getCastMemeber().getApariciones() == 0) && (movieCastMember.getCategory().equals("director") || movieCastMember.getCategory().equals("producer")) && (movieCastMember.getCastMemeber().getBirthCountry().equals("USA") || movieCastMember.getCastMemeber().getBirthCountry().equals("UK") || movieCastMember.getCastMemeber().getBirthCountry().equals("Italy") || movieCastMember.getCastMemeber().getBirthCountry().equals("France"))) {
                        movieCastMember.getCastMemeber().setApariciones(-1);
                        movieCastMember.getCastMemeber().getCauseOfDeath().addVictimas();
                    }
                }
            }
        }
        CauseOfDeath[] top5=new CauseOfDeath[6];
        for(CauseOfDeath causa:listaDeLaMuerte){
            int j=4;
            while(j>=0 && top5[j]==null){j--;}
            while(j>=0&&top5[j].getVictimas()< causa.getVictimas()){
                top5[j+1]=top5[j];
                j--;
            }
            top5[j+1]=causa;
        }

//        Nodo<CauseOfDeath> causa = listaDeLaMuerte.getPrimero();
//        CauseOfDeath[] top5=new CauseOfDeath[6];
//
//        while(causa!=null){
//            int j=4;
//            while(j>=0 && top5[j]==null){j--;}
//            while(j>=0&&top5[j].getVictimas()<causa.getValue().getVictimas()){
//                top5[j+1]=top5[j];
//                j--;
//            }
//            top5[j+1]=causa.getValue();
//            causa=causa.getSiguiente();
//        }
        for (int j = 0; j < 5; j++) {
            System.out.println("Causa de muerte: " + top5[j].getName());
            System.out.println("Cantidad de personas: "+ top5[j].getVictimas());
        }
        long TFin = System.currentTimeMillis();
        long tiempo = TFin - TInicio;

        System.out.println("Tiempo de ejecución de la consulta:" + tiempo);
        //consulta 2

    }
    public void consulta3(){

        long TInicio = System.currentTimeMillis();
        Movie[] listaPeliculasConsulta3=new Movie[15];
        int i=-1;

        if(entre_consulta3==false) {
            entre_consulta3 = true;
//            MyList<HashNode<String, Movie>>[] hashMovies = movieHash.getHash();
//
//            for (MyList<HashNode<String, Movie>> i : hashMovies) {
//                if (i != null) {
//                    Nodo<HashNode<String, Movie>> movie = i.getPrimero();
//                    while (movie != null) {
//                        MyList<MovieCastMember> listaCastMembersPorPelicula = movie.getValue().getValue().getListaMovieCastMember();
//                        Nodo<MovieCastMember> movieCastMember = listaCastMembersPorPelicula.getPrimero();
//                        while (movieCastMember != null) {
//                            if ((movie.getValue().getValue().getYear() > 1949) && (movie.getValue().getValue().getYear() < 1961)) {
//                                movie.getValue().getValue().addAlturasCastMember(movieCastMember.getValue().getCastMemeber());
//                                listaPeliculasConsulta3.add(movie.getValue().getValue());
//                            }
//                            movieCastMember = movieCastMember.getSiguiente();
//                        }
//                        movie = movie.getSiguiente();
//                    }
//                }
//            }

            for (Movie movie:movieHash){
                for(MovieCastMember movieCastMember: movie.getListaMovieCastMember()){
                    if (movie.getYear()>1949&&movie.getYear()>1949){
                        movie.addAlturasCastMember(movieCastMember.getCastMemeber());
                    }
                }
                int j=i;
                if(i<13){i++;}
                while(j>=0&&listaPeliculasConsulta3[j].getMovieRating().getWeightedAverage()<movie.getMovieRating().getWeightedAverage()){
                    listaPeliculasConsulta3 [j+1]=listaPeliculasConsulta3[j];
                    j--;
                }
                listaPeliculasConsulta3[j+1]=movie;
            }
        }

//        Nodo<Movie> pelicula = listaPeliculasConsulta3.getPrimero();
//        Movie[] top14=new Movie[15];
//
//        while(pelicula!=null){
//            int j=13;
//            while(j>=0 && top14[j]==null){j--;}
//            while(j>=0&&top14[j].getMovieRating().getWeightedAverage()<pelicula.getValue().getMovieRating().getWeightedAverage()){
//                top14[j+1]=top14[j];
//                j--;
//            }
//            top14[j+1]=pelicula.getValue();
//            pelicula=pelicula.getSiguiente();
//        }

        for (int j = 0; j < 14; j++) {

            if(listaPeliculasConsulta3[j].promedioAltura() != 0) {
                System.out.println("Id película: " + listaPeliculasConsulta3[j].getImdbTitleld());
                System.out.println("Nombre: " + listaPeliculasConsulta3[j].getTitle());
                System.out.println("Altura promedio de actores: " + listaPeliculasConsulta3[j].promedioAltura());
            }
        }
        long TFin = System.currentTimeMillis();
        long tiempo = TFin - TInicio;

        System.out.println("Tiempo de ejecución de la consulta:" + tiempo);

    }
    public void consulta4(){

        //consulta 4

    }
    public void consulta5(){

        //consulta 5

    }


    public String[] separarPeroBien (String entrada,int largo){
        final String regex = ",(\"([^\"]*)\"|[^,]*)";
        final String text = entrada.replace("\"\"","'").replace(",'\"",",\"'");

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher("," + text);

        String elemento;
        String[] separado = new String[largo];
        int n = -1;

        while (matcher.find()) {
            if (matcher.group(2) != null) {
                elemento = matcher.group(2);
            } else {
                elemento = matcher.group(1);
            }
            separado[++n] = elemento;
        }
        return separado;
    }

}

