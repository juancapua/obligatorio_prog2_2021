import java.util.Scanner;

public class Principal {


    public static void main(String[] args){

        boolean auxiliar = true;
        boolean entre = false;
        while(auxiliar){

            Scanner sc = new Scanner(System.in);
            Reader reader = new Reader();

            System.out.println("Seleccione la opción que desee:");
            System.out.println("1. Carga de datos\n" + "2. Ejecutar consultas\n" + "3. salir");

            try {
               int aux = Integer.parseInt(sc.nextLine());

                switch (aux){

                    case 1:
                        if(!entre){
                            entre = true;
                            reader.cargaDatos();

                        }else{System.out.println("ERROR, ya se han cargado los datos");}

                        break;



                    case 2:
                        if(entre){

                            boolean bucle = true;

                            while (bucle) {

                                System.out.println("1. Indicar el Top 5 de actores/actrices que más apariciones han tenido a lo largo de los años.\n" + "2. Indicar el Top 5 de las causas de muerte más frecuentes en directores y productores nacidos en Italia, Estados Unidos, Francia y UK\n" + "3. Mostrar de las 14 películas con más weightedAverage, el promedio de altura de sus actores/actrices si su valor es distinto de nulo.\n" + "4. Indicar el año más habitual en el que nacen los actores y las actrice\n" + "5. Indicar el Top 10 de géneros de películas más populares, en las cuales al menos un actor/actriz tiene 2 o más hijos.\n" + "6. Salir");

                                try {
                                    int entrada = Integer.parseInt(sc.nextLine());

                                    switch (entrada) {

                                        case 1:
                                            reader.consulta1();
                                            break;

                                        case 2:
                                            reader.consulta2();
                                            break;

                                        case 3:
                                            reader.consulta3();
                                            break;

                                        case 4:
                                            reader.consulta4();
                                            break;

                                        case 5:
                                            reader.consulta5();
                                            break;

                                        case 6:
                                            bucle = false;
                                            break;

                                        default:
                                            System.out.println("Opcion incorrecta");
                                            break;
                                    }

                                } catch (Exception e) {
                                }

                            }
                            
                        }else{System.out.println("ERROR, no se han cargado los datos aun");}

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
