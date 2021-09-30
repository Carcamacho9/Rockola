package canciones.datos;

import canciones.domain.Cancion;
import canciones.excepciones.LecturaDatosEx;
import static canciones.similitud.Levenshtein.porcentajeDeSimilitud;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatosImpl implements AccesoDatos{

    public static List<Cancion> canciones = new ArrayList<>();

    @Override
    public List<Cancion> listar(String nombreCancion) throws LecturaDatosEx {
        File archivo = new File(nombreCancion);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = entrada.readLine();
            while(linea != null){
                Cancion cancion = new Cancion(linea);
                canciones.add(cancion);
                linea = entrada.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return canciones;
    }

    @Override
    public String buscar(String nombreCancion, String buscar) {
        File archivo = new File(nombreCancion);
        String resultado = null;

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = entrada.readLine();
            while(linea != null){
                int res = porcentajeDeSimilitud(buscar, linea);
                if( buscar != null && buscar.equalsIgnoreCase(linea)){
                    if(porcentajeDeSimilitud(buscar, (linea)) >40){
                        resultado = "Encontré la canción que quieres, " + linea ;
                        break;
                    }
                }
              if((porcentajeDeSimilitud(buscar, (linea)))>40){
                  resultado = "Creo que conozco esa canción, pero no la encuentro, ¿Si está bien escrita?" +
                              "\nSí si está bien escrita, prueba escribiendo el nombre completo";
                  break;
              }
                linea = entrada.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return resultado;
    }

    @Override
    public String reproducir(String nombreCancion) throws LecturaDatosEx {
        return "Reproduciendo " + nombreCancion;
    }
}
