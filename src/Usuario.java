public class Usuario {
    private final String idUsuario;
    private final String nombre;
    private double saldo;

    public Usuario(String idUsuario, String nombre, double saldoInicial) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.saldo = saldoInicial;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void reducirSaldo(double monto) {
        saldo -= monto;
    }
}