package canciones.reproduccion;

public interface CatalogoCanciones {

    public void listarCanciones(String nombreCancion);

    public void buscarCancion(String nombreCancion, String buscar);

    public void reproducirCancion(String nombreCancion);
}
