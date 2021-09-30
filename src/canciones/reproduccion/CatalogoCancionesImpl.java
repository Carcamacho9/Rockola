package canciones.reproduccion;

import canciones.datos.*;
import canciones.domain.*;
import canciones.excepciones.LecturaDatosEx;
import static canciones.similitud.Levenshtein.porcentajeDeSimilitud;

import java.util.List;



public class CatalogoCancionesImpl implements CatalogoCanciones{

    private final AccesoDatos datos;

    public CatalogoCancionesImpl(){
        this.datos = new AccesoDatosImpl();
    }
    @Override
    public void listarCanciones(String nombreCancion) {
        try {
            List<Cancion> canciones = datos.listar(nombreCancion);
            for (Cancion cancion: canciones) {
                System.out.println(cancion);
            }
        } catch (LecturaDatosEx e) {
            System.out.println("Error de acceso a datos");
            e.printStackTrace();
        }
    }

    @Override
    public void buscarCancion(String nombreCancion, String buscar) {
        String resultado = null;
        try {
            resultado = datos.buscar(buscar, nombreCancion);
            if(resultado == null){
                resultado = "Lo siento, no encontré esa canción";
//            }else{
//                System.out.println("¿Deseas reproducir esta canción?\nY: Si\nN: No");
//                String respuesta = scanner.nextLine();
//                if(respuesta != null && respuesta.equalsIgnoreCase("Y")){
//                    catalogoCanciones.reproducirCancion(nombreCancion);
//                }else{
//                    System.out.println("Está bien");
//                }
            }
        } catch (LecturaDatosEx e) {
            System.out.println("Error al buscar la canción");
            e.printStackTrace(System.out);
        }
        System.out.println("Resultado búsqueda: " + resultado);
    }

    public void reproducirCancion(String nombreCancion){
        String resultado = null;
        try {
            resultado = datos.reproducir(nombreCancion);
        } catch (LecturaDatosEx e) {
            System.out.println("Error al reproducir esta canción");
            e.printStackTrace(System.out);
        }
    }
}
