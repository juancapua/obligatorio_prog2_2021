import java.util.Scanner;

public class Principal {


    public static void main(String[] args){

        boolean auxiliar = true;
        while(auxiliar){

            Scanner sc = new Scanner(System.in);

            System.out.println("Seleccione la opción que desee:");
            System.out.println("1. Carga de datos\n" + "2. Ejecutar consultas\n" + "3. salir");

            try {
               int aux = Integer.parseInt(sc.nextLine());
                boolean entre = false;

                switch (aux){

                    case 1:
                        if(entre){
                            System.out.println("ERROR, ya se han cargado los datos");
                        }
                        entre = true;

                        Reader reader = new Reader();
                        reader.cargaDatos();


                    case 2:
                        if(entre = false){
                            System.out.println("ERROR, no se han carhado los datos aun");
                            break;
                        }

                        break;


                    case 3:
                        System.out.println("Programa finalizado");
                        auxiliar = false;
                        break;

                    default:
                        System.out.println("Opcion incorrecta");
                        break;
                }
            }catch (Exception e){}


        }



    }
}
