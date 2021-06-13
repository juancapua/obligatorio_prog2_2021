

import Entidades.CastMember;
import Entidades.Movie;
import Entidades.MovieCastMember;
import Entidades.MovieRating;
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

    boolean entre_consulta1 = false;


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
                    castMemberHash.put(lecturaLinea[0], new CastMember(lecturaLinea));
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
        MyList<HashNode<String, Movie>>[] hashMovies = movieHash.getHash();

        int n=movieHash.size();

        if(!entre_consulta1) {

            for (MyList<HashNode<String, Movie>> i : hashMovies) {
                if (i != null) {
                    Nodo<HashNode<String, Movie>> movie = i.getPrimero();
                    while (movie != null) {
                        MyLinkedListimpl<MovieCastMember> listaCastMembersPorPelicula = (MyLinkedListimpl<MovieCastMember>) movie.getValue().getValue().getListaMovieCastMember();
                        Nodo<MovieCastMember> movieCastMember = listaCastMembersPorPelicula.getPrimero();
                        while (movieCastMember != null) {
                            if (movieCastMember.getValue().getCategory().equals("actor") || movieCastMember.getValue().getCategory().equals("actress")) {
                                movieCastMember.getValue().getCastMemeber().addApariciones();
                            }
                            movieCastMember = movieCastMember.getSiguiente();
                        }
                        movie = movie.getSiguiente();
                    }
                }
            }
            entre_consulta1 = true;
        }


        MyList<HashNode<String, CastMember>>[] hashCastMembers = castMemberHash.getHash();
        n =castMemberHash.getSize();
        while(hashCastMembers[n-1]==null){n--;}
        Nodo<HashNode<String, CastMember>> actor=hashCastMembers[n-1].getPrimero();
        CastMember[] top5=new CastMember[6];
        while(n>=0){
            int j=4;
            while(j>=0 && top5[j]==null){j--;}
            while(j>=0&&top5[j].getApariciones()<actor.getValue().getValue().getApariciones()){
                top5[j+1]=top5[j];
                j--;
            }
            top5[j+1]=actor.getValue().getValue();
            if(actor.getSiguiente()!=null){actor=actor.getSiguiente();
            } else{
                if (n==0){break;}
                while(hashCastMembers[n-1]==null){n--;}
                if (n<0){break;}
                actor=hashCastMembers[--n].getPrimero();
            }
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

        //consulta 2

    }
    public void consulta3(){

        //consulta 3

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

