public class ServicioValidacion {
    public void validarActivo(ActivoDigital activo) throws ValidacionExcepcion {
        activo.validar();
        validarMetadatos(activo.obtenerMetadatos());
    }

    private void validarMetadatos(String metadatos) throws ValidacionExcepcion {
        if (metadatos == null || metadatos.trim().isEmpty()) {
            throw new ValidacionExcepcion("Metadatos inválidos.");
        }
    }
}