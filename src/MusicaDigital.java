public class MusicaDigital implements ActivoDigital {
    private final String id;
    private final int duracion; // en segundos
    private final String genero;
    private final boolean tieneLicencia;
    private final double precioBase;

    public MusicaDigital(String id, int duracion, String genero, boolean tieneLicencia, double precioBase) {
        this.id = id;
        this.duracion = duracion;
        this.genero = genero;
        this.tieneLicencia = tieneLicencia;
        this.precioBase = precioBase;
    }

    @Override
    public String obtenerId() {
        return id;
    }

    @Override
    public double calcularValor() {
        return precioBase * (duracion / 180.0) * (tieneLicencia ? 2.0 : 1.0);
    }

    @Override
    public String obtenerMetadatos() {
        return String.format("Género: %s, Duración: %ds, Licencia: %s", genero, duracion, tieneLicencia ? "Sí" : "No");
    }

    @Override
    public void validar() throws ValidacionExcepcion {
        if (duracion <= 0) throw new ValidacionExcepcion("Duración inválida.");
        if (precioBase <= 0) throw new ValidacionExcepcion("Precio base inválido.");
    }
}