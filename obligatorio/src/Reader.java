import Entidades.CastMenber;
import Entidades.Movie;
import Entidades.MovieCastMember;
import Tads.CloseHashImpl;
import Tads.MyHash;
import Tads.OpenHash;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader<K, V> {

    public static String path1;
    public static String path2;
    public static String path3;
    public static String path4;


    public static OpenHash<String, CastMenber> castMemberHash = new OpenHash<>(370000);
    public static OpenHash<String, Movie> movieHash = new OpenHash<>(110000);
    public static OpenHash<String, MovieCastMember> movieCastMemeberHash = new OpenHash<>(110000);


    public void cargaDatos() {

        System.out.println("Cargando datos...");

        String linea = null;

        try {

            BufferedReader bufer1 = new BufferedReader(new FileReader(path1));

            while ((linea = bufer1.readLine()) != null) {
                String[] lecturaLinea = separarPeroBien(linea);
                //aca iria la carga del path 1 a su hash

            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }

        try {

            BufferedReader bufer2 = new BufferedReader(new FileReader(path2));

            while ((linea = bufer2.readLine()) != null) {
                String[] lecturaLinea = separarPeroBien(linea);
                //aca iria la carga del path 2 a su hash

            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }

        try {

            BufferedReader bufer3 = new BufferedReader(new FileReader(path3));

            while ((linea = bufer3.readLine()) != null) {
                String[] lecturaLinea = separarPeroBien(linea);
                //aca iria la carga del path 3 a su hash

            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }

        try {

            BufferedReader bufer4 = new BufferedReader(new FileReader(path4));

            while ((linea = bufer4.readLine()) != null) {
                String[] lecturaLinea = separarPeroBien(linea);
                //aca iria la carga del path 4 a su hash

            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }

        System.out.println("Datos cargados");

    }

    public String[] separarPeroBien (String entrada){
        final String regex = ",(\"([^\"]*)\"|[^,]*)";
        final String text = entrada;

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher("," + text);

        String elemento;
        String[] separado = new String[17];
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

