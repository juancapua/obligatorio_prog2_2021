

import Entidades.CastMember;
import Entidades.Movie;
import Entidades.MovieCastMember;
import Entidades.MovieRating;
import Tads.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader{

    public static OpenHash<String, CastMember> castMemberHash = new OpenHash<>(370000);
    public static OpenHash<String, Movie> movieHash = new OpenHash<>(110000);


    public void cargaDatos() {

        System.out.println("Cargando datos...");

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
                String[] lecturaLinea = separarPeroBien(linea);
                if (lecturaLinea[6] != null) {
                    castMemberHash.put(lecturaLinea[0], new CastMember(lecturaLinea));
                    key = lecturaLinea[0];

                } else {

                    castMemberHash.get(key).continueCastMember(lecturaLinea);

                }

            }
            System.out.println("cargo castMembers");
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } catch (KeyNotFoundException e) {
            e.printStackTrace();
        }

        try {

            System.out.println("empezo movie");
            BufferedReader bufer2 = new BufferedReader(new FileReader(path2));
            bufer2.readLine();

            while ((linea = bufer2.readLine()) != null) {
                String[] lecturaLinea2 = separarPeroBien(linea);
                System.out.println(linea);
                movieHash.put(lecturaLinea2[0],new Movie(lecturaLinea2));


            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("termino movie");

        try {

            System.out.println("empezo movieCastMembers");
            BufferedReader bufer3 = new BufferedReader(new FileReader(path3));
            bufer3.readLine();

            while ((linea = bufer3.readLine()) != null) {
                String[] lecturaLinea3 = separarPeroBien(linea);
                System.out.println(linea);
                movieHash.get(lecturaLinea3[0]).setListaMovieCastMember(new MovieCastMember(lecturaLinea3));
                int aux = Integer.parseInt(lecturaLinea3[1]);
                movieHash.get(lecturaLinea3[0]).getListaMovieCastMember().get(aux).setCastMemeber(castMemberHash.get(lecturaLinea3[2]));

            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } catch (KeyNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("termino movieCastMember");

        try {

            BufferedReader bufer4 = new BufferedReader(new FileReader(path4));
            bufer4.readLine();

            while ((linea = bufer4.readLine()) != null) {
                String[] lecturaLinea4 = separarPeroBien(linea);
                movieHash.get(lecturaLinea4[0]).setMovieRating(new MovieRating(lecturaLinea4));

            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } catch (KeyNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Datos cargados");

    }

    public String[] separarPeroBien (String entrada){
        final String regex = ",(\"([^\"]*)\"|[^,]*)";
        final String text = entrada.replace("\"\"","'").replace(",'\"",",\"'");

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher("," + text);

        String elemento;
        String[] separado = new String[50];
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

