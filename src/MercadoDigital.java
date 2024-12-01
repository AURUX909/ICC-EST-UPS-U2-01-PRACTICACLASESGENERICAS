import java.util.*;
import java.util.stream.Collectors;

public class MercadoDigital<T extends ActivoDigital> {
    private final Map<String, T> activos;
    private final List<Transaccion<T>> transacciones;
    private final ServicioValidacion validador;

    public MercadoDigital(ServicioValidacion validador) {
        this.activos = new HashMap<>();
        this.transacciones = new ArrayList<>();
        this.validador = validador;
    }

    public void listarActivo(T activo) throws ValidacionExcepcion {
        validador.validarActivo(activo);
        activos.put(activo.obtenerId(), activo);
    }

    public Optional<T> comprarActivo(String id, Usuario comprador) throws FondosInsuficientesExcepcion {
        T activo = activos.get(id);
        if (activo != null && comprador.getSaldo() >= activo.calcularValor()) {
            activos.remove(id);
            transacciones.add(new Transaccion<>(activo, comprador));
            comprador.reducirSaldo(activo.calcularValor());
            return Optional.of(activo);
        } else if (activo != null) {
            throw new FondosInsuficientesExcepcion("Saldo insuficiente para realizar la compra.");
        }
        return Optional.empty();
    }

    public List<T> buscarPorRangoDeValor(double valorMinimo, double valorMaximo) {
        return activos.values().stream()
                .filter(a -> {
                    double valor = a.calcularValor();
                    return valor >= valorMinimo && valor <= valorMaximo;
                })
                .collect(Collectors.toList());
    }

    public List<Transaccion<T>> obtenerTransacciones() {
        return transacciones;
    }
}