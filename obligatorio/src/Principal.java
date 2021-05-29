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

                switch (aux){

                    case 1:
                        break;

                    case 2:
                        break;

                    case 3:
                        System.out.println("Programa finalizado");
                        auxiliar = false;

                    default:
                        System.out.println("Opcion incorrecta");
                        break;
                }
            }catch (Exception e){}




        }


    }
}
