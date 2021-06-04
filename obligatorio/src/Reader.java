import Entidades.CastMenber;
import Tads.CloseHashImpl;
import Tads.MyHash;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader<K, V> {

    private String path;
    private String line;

    public Reader(String path) {
        this.path = path;
        this.line = null;
    }

<<<<<<< HEAD
<<<<<<< Updated upstream
    public void cargaDatos(String path, Integer queCargo){
=======
    public void cargaDatos(MyHash<K, V> hashTable, int opcion){

        //FIXME hacer los casos para cada clase
>>>>>>> Stashed changes
=======
    public void cargaDatos(String path, Integer queCargo){
>>>>>>> main

        try{

            BufferedReader bufer = new BufferedReader(new FileReader(this.path));

            while((this.line = bufer.readLine()) != null){
                String[] linea = separarPeroBien(line);
<<<<<<< Updated upstream
                System.out.print(counter + ": ");
                for (int i = 0; i < linea.length; i++){
                    if( linea[i]==null){break;}
                    System.out.print(linea[i] + "| ");}
                System.out.print("\n");
                counter++;
                cargarAlSistema(linea, queCargo);
<<<<<<< HEAD
=======
>>>>>>> Stashed changes
=======
>>>>>>> main

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void cargarAlSistema(String[] linea, Integer queCargo) {
        switch (queCargo){
            case 0:
                if (linea[5]==null){}
                
            case 1:
                return;
            case 2:
                break;
            case 3:
                break;
        }
    }

    public String[] separarPeroBien(String entrada){
        final String regex = ",(\"([^\"]*)\"|[^,]*)";
        final String text= entrada;

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher("," + text);

        String elemento;
        String[] separado=new String[17];
        int n = -1;

        while (matcher.find()) {
            if (matcher.group(2) != null)
            {
                elemento = matcher.group(2);
            }
            else
            {
                elemento = matcher.group(1);
            }
             separado[++n]= elemento;
        }
        return separado;
    }

    public String getPath() {
        return path;
    }
}
