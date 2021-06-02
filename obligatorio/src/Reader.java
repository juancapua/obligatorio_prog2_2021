import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {

    private String path;
    private String line;

    public Reader(String path) {
        this.path = path;
        this.line = null;
    }

    public void cargaDatos(String path){

        try{

            BufferedReader bufer = new BufferedReader(new FileReader(path));
            int counter = 0;

            while((this.line = bufer.readLine()) != null){
                String[] linea = separarPeroBien(line);
                System.out.print(counter + ": ");
                for (int i = 0; i < linea.length; i++){
                    if( linea[i]==null){break;}
                    System.out.print(linea[i] + "| ");}
                System.out.print("\n");
                counter++;
                if (counter>2){break;}
                // FIXME falta devolver la linea

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
            {   // Elemento entre comillas?
                elemento = matcher.group(2); // Obtener el texto sin las comillas
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
