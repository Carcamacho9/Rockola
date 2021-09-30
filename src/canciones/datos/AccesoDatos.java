package canciones.datos;

import canciones.domain.Cancion;
import canciones.excepciones.LecturaDatosEx;

import java.util.List;

public interface AccesoDatos {

    public List<Cancion> listar(String nombreCancion) throws LecturaDatosEx;

    public String buscar(String nombreCancion, String buscar) throws LecturaDatosEx;

    public String reproducir(String nombreCancion) throws LecturaDatosEx;
}
