

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
    public static OpenHash<Integer,MyList<CastMember>> castMembersPorAño = new OpenHash<>(250);
    public static OpenHash<String, Generos> listaDeGeneros = new OpenHash<>(32);

    boolean entre_consulta1 = false;
    boolean entre_consulta2 = false;
    boolean entre_consulta3 = false;
    boolean entre_consulta4 = false;
    boolean entre_consulta5 = false;


    public void cargaDatos() {

        long TInicio = System.currentTimeMillis();

        System.out.println("Cargando datos...");

//        String path1 = "C:\\Users\\Ari 2.0\\IdeaProjects\\obligatorio_prog2_2021\\Data\\IMDb names.csv";
//        String path2 = "C:\\Users\\Ari 2.0\\IdeaProjects\\obligatorio_prog2_2021\\Data\\IMDb movies.csv";
//        String path3 = "C:\\Users\\Ari 2.0\\IdeaProjects\\obligatorio_prog2_2021\\Data\\IMDb title_principals.csv";
//        String path4 = "C:\\Users\\Ari 2.0\\IdeaProjects\\obligatorio_prog2_2021\\Data\\IMDb ratings.csv";

        String path1 = "Data/IMDb names.csv";
        String path2 = "Data/IMDb movies.csv";
        String path3 = "Data/IMDb title_principals.csv";
        String path4 = "Data/IMDb ratings.csv";

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
                    if (castMemberHash.get(key).getBirthYear()>0){
                        if (castMembersPorAño.contains(castMemberHash.get(key).getBirthYear())){
                            castMembersPorAño.get(castMemberHash.get(key).getBirthYear()).add(castMemberHash.get(key));
                        }else{
                            castMembersPorAño.put(castMemberHash.get(key).getBirthYear(),new MyLinkedListimpl<>(castMemberHash.get(key)));
                        }


                    }

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
                movieHash.put(lecturaLinea2[0],new Movie(lecturaLinea2, listaDeGeneros));


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
                MovieCastMember movieCastMember=new MovieCastMember(lecturaLinea3);
                movieHash.get(lecturaLinea3[0]).setListaMovieCastMember(movieCastMember);
                movieCastMember.setCastMemeber(castMemberHash.get(lecturaLinea3[2]));
                castMemberHash.get(lecturaLinea3[2]).getListaMovieCastMember().add(movieCastMember);


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
            for (Movie movie:movieHash){
                for(MovieCastMember movieCastMember: movie.getListaMovieCastMember()){
                    if (movieCastMember.getCategory().equals("actor") || movieCastMember.getCategory().equals("actress")) {
                        movieCastMember.getCastMemeber().addApariciones();
                    }
                }
            }

            entre_consulta1 = true;
        }

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


    public void consulta2(){
        long TInicio = System.currentTimeMillis();

        if(entre_consulta2==false) {
            entre_consulta2=true;
            int i=0;
            for (Movie movie:movieHash){
                for(MovieCastMember movieCastMember: movie.getListaMovieCastMember()){
                    if ((movieCastMember.getCastMemeber().getCauseOfDeath() != null) && (!movieCastMember.getCastMemeber().isDirector_producer()) && (movieCastMember.getCategory().equals("director") || movieCastMember.getCategory().equals("producer")) && (movieCastMember.getCastMemeber().getPlaceOfBirth().contains("USA") || movieCastMember.getCastMemeber().getPlaceOfBirth().contains("UK") || movieCastMember.getCastMemeber().getPlaceOfBirth().contains("Italy") || movieCastMember.getCastMemeber().getPlaceOfBirth().contains("France"))) {
                        movieCastMember.getCastMemeber().setDirector_producer();
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

        for (int j = 0; j < 5; j++) {
            System.out.println("Causa de muerte: " + top5[j].getName());
            System.out.println("Cantidad de personas: "+ top5[j].getVictimas());
        }
        long TFin = System.currentTimeMillis();
        long tiempo = TFin - TInicio;

        System.out.println("Tiempo de ejecución de la consulta:" + tiempo);

    }
    public void consulta3(){

        long TInicio = System.currentTimeMillis();
        Movie[] listaPeliculasConsulta3=new Movie[15];
        int i=-1;

            if(!entre_consulta3) {
                for (Movie movie : movieHash) {
                    if (movie.getYear() > 1949 && movie.getYear() < 1961) {
                        int j = i;
                        if (i < 13) {
                            i++;
                        }
                        while (j >= 0 && listaPeliculasConsulta3[j].getMovieRating().getWeightedAverage() < movie.getMovieRating().getWeightedAverage()) {
                            listaPeliculasConsulta3[j + 1] = listaPeliculasConsulta3[j];
                            j--;
                        }
                        listaPeliculasConsulta3[j + 1] = movie;
                    }

                }
                entre_consulta3 = true;
            }


        for (int j = 0; j < 14; j++) {
            Movie movie=listaPeliculasConsulta3[j];
            for(MovieCastMember movieCastMember: movie.getListaMovieCastMember()){
                if(movieCastMember.getCategory().equals("actor") || movieCastMember.getCategory().equals("actress")){movie.addAlturasCastMember(movieCastMember.getCastMemeber());}
            }
            if(movie.promedioAltura() != 0) {
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
        long TInicio = System.currentTimeMillis();
        Integer[] modaActor= new Integer[2];
        Integer[] modaActriz = new Integer[2];
        modaActriz[0]=0;
        modaActor[0]=0;
        for (MyList<CastMember> castMemberlista : castMembersPorAño) {
            int actores = 0;
            int actrices = 0;
            for (CastMember castMember : castMemberlista) {
                for (MovieCastMember movieCastMember : castMember.getListaMovieCastMember()) {
                    if (movieCastMember.getCategory().equals("actor")) {
                        actores++;
                        break;
                    } else if (movieCastMember.getCategory().equals("actress")) {
                        actrices++;
                        break;
                    }
                }
            }
            if (actores > modaActor[0]) {
                modaActor[0] = actores;
                modaActor[1] = castMemberlista.get(0).getBirthYear();
            }
            if (actrices > modaActriz[0]) {
                modaActriz[0] = actrices;
                modaActriz[1] = castMemberlista.get(0).getBirthYear();
            }

        }

        System.out.println("Actores:");
        System.out.println("\tAño: " + modaActor[1]);
        System.out.println("\tCantidad: " + modaActor[0]);
        System.out.println("Actrices:");
        System.out.println("\tAño: " + modaActriz[1]);
        System.out.println("\tCantidad: " + modaActriz[0]);
        long TFin = System.currentTimeMillis();
        long tiempo = TFin - TInicio;

        System.out.println("Tiempo de ejecución de la consulta:" + tiempo);

    }
    public void consulta5() throws KeyNotFoundException {
        long TInicio = System.currentTimeMillis();

        if(!entre_consulta5) {
            for (Movie movie : movieHash) {

                for (MovieCastMember movieCastMember : movie.getListaMovieCastMember()) {
                    if ((movieCastMember.getCategory().equals("actor") || movieCastMember.getCategory().equals("actress")) && movieCastMember.getCastMemeber().getChildren() > 1) {
                        for (String genero : movie.getGenre()) {
                            listaDeGeneros.get(genero).addCantidad();
                        }
                        break;
                    }
                }

            }
            entre_consulta5 = true;
        }

        Generos[] top10=new Generos[11];
        for(Generos genero:listaDeGeneros){
            int j=9;
            while(j>=0 && top10[j]==null){j--;}
            while(j>=0&&top10[j].getCantidad()< genero.getCantidad()){
                top10[j+1]=top10[j];
                j--;
            }
            top10[j+1]=genero;
        }

        for (int j = 0; j < 10; j++) {
            System.out.println("Genero pelicula: " + top10[j].getName());
            System.out.println("Cantidad: " + top10[j].getCantidad());
        }

        long TFin = System.currentTimeMillis();
        long tiempo = TFin - TInicio;

        System.out.println("Tiempo de ejecución de la consulta:" + tiempo);
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

