public class CajaDeAhorro extends Cuenta {

    public CajaDeAhorro() {
    }

    public CajaDeAhorro(double saldo, int nroCuenta, String titular, boolean estaHabilitada, String tipoDeCuenta, double saldoDescubierto) {
        super(saldo, nroCuenta, titular, estaHabilitada, tipoDeCuenta, saldoDescubierto);
    }

    @Override
    protected void depositar(double dinero) {
        System.out.println("Saldo antes de la operacion: $" + saldo);
        System.out.println("--------");
        if (!estaHabilitada) {
            //si la cuenta no esta habilitada
            System.out.println("No es posible realizar la operación, cuenta no habilitada!");
            //si se ingresa un monton igual a cero o negativo
        } else if(dinero < 0){
            System.out.println("Usted ingresó una cantidad incorrecta, no se pudo realizar la operación");
            //si se deposita correctamente el monto ingresado
        } else {
            saldo += dinero;
            System.out.println("Se ha depositado $" + dinero + " de manera correcta");
        }
        System.out.println("--------");
        System.out.println("Saldo al final de la operacion: $" + saldo);
    }

    @Override
    protected void retirar(double dinero) {
        System.out.println("Saldo antes de la operacion: $" + saldo);
        System.out.println("--------");
        //si la cuenta no esta habilitada
        if (!estaHabilitada){
            System.out.println("Cuenta no habilitada, no se puede realizar la operación!");
            //si el dinero es mayor que el saldo actual
        } else if (dinero > saldo) {
            System.out.println("Saldo insuficiente para realizar la operación!");
            //si se ingresa un monton igual a cero o negativo
        } else if (dinero <= 0){
            System.out.println("La cantidad de dinero ingresada es inválida");
            //si se puede retirar el monto de manera correcta
        } else {
            saldo -= dinero;
            System.out.println("Se retiró $" + dinero + " correctamente.");
        }
        System.out.println("--------");
        System.out.println("Saldo al final de la operacion: $" + saldo);
    }

    @Override
    protected void transferir(double dinero, Cuenta cuentaDestino) {
        System.out.println("Saldo de cuenta origen antes de la operacion: $" + saldo);
        System.out.println("Saldo de cuenta destino antes de la operacion: $" + cuentaDestino.getSaldo());
        System.out.println("--------");
        //si ambas habilitadas
        if (estaHabilitada && cuentaDestino.EstaHabilitada()){
            //si dinero mayor que el saldo actual
            if (dinero > saldo){
                System.out.println("Error! Saldo insuficiente");
                //si se ingresa un monton igual a cero o negativo
            } else if(dinero <= 0){
                System.out.println("Ingreso incorrecto de monto a transferir");
            }else {
                //si los tipos de cuentas y los titulares son distintos
                if (!tipoDeCuenta.equalsIgnoreCase(cuentaDestino.getTipoDeCuenta()) && !titular.equalsIgnoreCase(cuentaDestino.getTitular())){
                    //si saldo es insuficiente
                    if(saldo < dinero + dinero * 0.015){
                        System.out.println("Error! Saldo insuficiente");
                        //si saldo suficiente, se aplica el recargo
                    } else {
                        saldo -= dinero + (dinero * 0.015);
                        System.out.println("Tranferencia hecha con exito! Se transfirió $" + dinero + "  y Se aplicó un cargo adicional del 1,5% sobre la cuenta nro: " + nroCuenta + " del tipo " + tipoDeCuenta);
                        cuentaDestino.setSaldo(cuentaDestino.getSaldo() + dinero);
                    }
                    //transferencia sin cargo
                } else {
                    saldo -= dinero;
                    cuentaDestino.setSaldo(cuentaDestino.getSaldo() + dinero);
                    System.out.println("Se transfirio $" + dinero + " de manera correcta.");
                }
            }
            //si alguna de las cuentas no se encuentra habilitada
        } else {
            System.out.println("Error, no se pudo realizar la operación! Al menos una de las cuentas no se encuentra habilitada");
        }
        System.out.println("--------");
        System.out.println("Saldo de cuenta origen luego de la operacion: $" + saldo);
        System.out.println("Saldo de cuenta destino luego de la operacion: $" + cuentaDestino.getSaldo());
    }
}
