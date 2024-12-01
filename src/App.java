public class App {
    public static void main(String[] args) {
        ServicioValidacion validador = new ServicioValidacion();
        MercadoDigital<ArteDigital> mercadoArte = new MercadoDigital<>(validador);
        MercadoDigital<MusicaDigital> mercadoMusica = new MercadoDigital<>(validador);

        try {
            ArteDigital arte = new ArteDigital("ART001", "Paisaje Retro", 1080, "pixel", 150.0);
            mercadoArte.listarActivo(arte);

            MusicaDigital musica = new MusicaDigital("MUS001", 240, "electrónica", true, 50.0);
            mercadoMusica.listarActivo(musica);

            Usuario usuario = new Usuario("USR001", "Juan Pérez", 200.0);
            mercadoArte.comprarActivo("ART001", usuario)
                    .ifPresent(a -> System.out.println("Activo adquirido: " + a.obtenerMetadatos()));

        } catch (ValidacionExcepcion | FondosInsuficientesExcepcion e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}