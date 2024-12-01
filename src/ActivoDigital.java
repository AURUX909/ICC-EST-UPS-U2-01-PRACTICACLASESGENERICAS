public interface ActivoDigital {
    String obtenerId();
    double calcularValor();
    String obtenerMetadatos();
    void validar() throws ValidacionExcepcion;
}
