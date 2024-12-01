import java.time.LocalDateTime;

public class Transaccion<T extends ActivoDigital> {
    private final T activo;
    private final Usuario comprador;
    private final LocalDateTime fechaHora;
    private final double valorTransaccion;

    public Transaccion(T activo, Usuario comprador) {
        this.activo = activo;
        this.comprador = comprador;
        this.fechaHora = LocalDateTime.now();
        this.valorTransaccion = activo.calcularValor();
    }

    @Override
    public String toString() {
        return String.format("Activo: %s, Comprador: %s, Valor: %.2f, Fecha: %s",
                activo.obtenerId(), comprador.getNombre(), valorTransaccion, fechaHora);
    }
}