import java.util.ArrayList;

public abstract class Cuenta {

    protected double saldo;
    protected int nroCuenta;
    protected String titular;
    protected boolean estaHabilitada;
    protected String tipoDeCuenta;
    protected double saldoDescubierto;

    protected Cuenta() {
    }

    protected Cuenta(double saldo, int nroCuenta, String titular, boolean estaHabilitada, String tipoDeCuenta, double saldoDescubierto) {
        this.saldo = saldo;
        this.nroCuenta = nroCuenta;
        this.titular = titular;
        this.estaHabilitada = estaHabilitada;
        this.tipoDeCuenta = tipoDeCuenta;
        this.saldoDescubierto = saldoDescubierto;
    }

    protected double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    protected int getNroCuenta() {
        return nroCuenta;
    }

    protected void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    protected String getTitular() {
        return titular;
    }

    protected void setTitular(String titular) {
        this.titular = titular;
    }

    protected boolean EstaHabilitada() {
        return estaHabilitada;
    }

    protected void setEstaHabilitada(boolean estaHabilitada) {
        this.estaHabilitada = estaHabilitada;
    }

    protected String getTipoDeCuenta() {
        return tipoDeCuenta;
    }

    protected void setTipoDeCuenta(String tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
    }

    public double getSaldoDescubierto() {
        return saldoDescubierto;
    }

    public void setSaldoDescubierto(double saldoDescubierto) {
        this.saldoDescubierto = saldoDescubierto;
    }

    protected abstract void depositar(double dinero);
    protected abstract void retirar(double dinero);
    protected abstract void transferir(double dinero, Cuenta cuentaDestino);

    public static void obtenerTitularesAptosParaPrestamos(ArrayList<Cuenta> listaCuentas){
        System.out.println("Lista de Titulares aptos para prestamo:");
        listaCuentas.stream()
                .filter(cuenta -> cuenta.getSaldo() + cuenta.getSaldoDescubierto() >= 10000 && cuenta.EstaHabilitada())
                .forEach(cuenta -> System.out.println(cuenta.getTitular().toUpperCase()));
    }
    public static boolean algunaCuentaPuedeSerHackeada(ArrayList<Cuenta> listaCuentas){
        return listaCuentas.stream()
                .anyMatch(cuenta -> cuenta.getNroCuenta() % 2 == 0 && cuenta.getSaldo() > 50000 && cuenta.getTitular().length() > 15);
    }

}
