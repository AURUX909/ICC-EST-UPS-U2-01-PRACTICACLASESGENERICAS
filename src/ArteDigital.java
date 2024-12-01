import java.util.Locale;

public class ArteDigital implements ActivoDigital {
    private final String id;
    private final String titulo;
    private final int resolucion;
    private final String estilo;
    private final double precioBase;

    public ArteDigital(String id, String titulo, int resolucion, String estilo, double precioBase) {
        this.id = id;
        this.titulo = titulo;
        this.resolucion = resolucion;
        this.estilo = estilo;
        this.precioBase = precioBase;
    }

    @Override
    public String obtenerId() {
        return id;
    }

    @Override
    public double calcularValor() {
        return precioBase * (resolucion / 1000.0) * obtenerMultiplicadorPorEstilo();
    }

    private double obtenerMultiplicadorPorEstilo() {
        return switch (estilo.toLowerCase(Locale.ROOT)) {
            case "pixel" -> 1.2;
            case "vector" -> 1.5;
            case "3d" -> 2.0;
            default -> 1.0;
        };
    }

    @Override
    public String obtenerMetadatos() {
        return String.format("Título: %s, Resolución: %dpx, Estilo: %s", titulo, resolucion, estilo);
    }

    @Override
    public void validar() throws ValidacionExcepcion {
        if (resolucion <= 0) throw new ValidacionExcepcion("Resolución inválida.");
        if (precioBase <= 0) throw new ValidacionExcepcion("Precio base inválido.");
    }
}