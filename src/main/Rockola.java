package main;

import canciones.domain.Cancion;
import canciones.reproduccion.CatalogoCanciones;
import canciones.reproduccion.CatalogoCancionesImpl;
import static canciones.similitud.Levenshtein.porcentajeDeSimilitud;
import static canciones.datos.AccesoDatosImpl.*;

import java.io.*;
import java.util.Scanner;

public class Rockola {

    private static final Scanner scanner = new Scanner(System.in);
    private static int opcion = -1;
    private static final String nombreCancion = "c:\\catalogoCanciones\\canciones.txt";
    private static final CatalogoCanciones catalogoCanciones = new CatalogoCancionesImpl();

    public static void main(String[] args) {

        while(opcion != 0){
            System.out.println();
            System.out.println("Bienvenid@ a tu Rockola de confianza");
            System.out.println();
            System.out.println("Escoge una opción:\n1. Ver todas las canciones" +
                    "\n2. Buscar canción" +
                    "\n0. Salir");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion){
                case 1:
                    catalogoCanciones.listarCanciones(nombreCancion);
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la canción que deseas buscar:");
                    String buscar = scanner.nextLine();
                    catalogoCanciones.buscarCancion(nombreCancion, buscar);
                    break;
                case 0:
                    System.out.println("¡Te espero de vuelta pronto!");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
//        System.out.println("Escribe algo");
//        String buscar = scanner.nextLine();
//        File archivo = new File(nombreCancion);
//        String resultado = null;
//        try {
//            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
//            String linea = entrada.readLine();
//            while(linea != null){
//                int res = porcentajeDeSimilitud(buscar, linea);
//                if(res >= 80 && res < 100){
//                    resultado = "Encontré la canción que quieres, " + linea ;
//                    System.out.println(resultado);
//                    break;
//                }else if(res >= 40 && res <= 79){
//                    System.out.println("No estoy seguro si es ésta la canción que quieres, pero aquí hay algunas similares a tu busqueda: ");
//                    if( res > 50){
//                        for (int i = 0; i <= 9; i ++) {
//                            if(porcentajeDeSimilitud(buscar, linea) > 50)
//                                System.out.println(linea);
//                                linea = entrada.readLine();
//                        }
//                    }else{
//                        System.out.println(linea);
//                    }
//
//                    break;
//                }else if( res <= 20 && res == 0 ){
//                    System.out.println("Creo que conozco esa canción, pero no la encuentro, ¿Si está bien escrita?" +
//                            "\nSí si está bien escrita, prueba escribiendo el nombre completo");
//                    break;
//                }else {
//                    System.out.println("No encontré la canción que quieres, revisa nuestra lista para verificar si la tengo agregada:\n " + linea);
//                }
//                linea = entrada.readLine();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}