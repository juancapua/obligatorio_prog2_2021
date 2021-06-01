import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

            while((this.line = bufer.readLine()) != null){
                String[] linea = this.line.split(",");
                // FIXME falta devolver la linea
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
