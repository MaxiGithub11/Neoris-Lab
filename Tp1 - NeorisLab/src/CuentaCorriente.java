public class CuentaCorriente extends Cuenta{

    public CuentaCorriente() {
    }

    public CuentaCorriente(double saldo, int nroCuenta, String titular, boolean estaHabilitada, String tipoDeCuenta, double saldoDescubierto) {
        super(saldo, nroCuenta, titular, estaHabilitada, tipoDeCuenta, saldoDescubierto);
    }

    @Override
    protected void depositar(double dinero) {
        System.out.println("Saldo antes de la operacion: $" + saldo);
        System.out.println("--------");
        //si la cuenta no esta habilitada
        if (!estaHabilitada) {
            System.out.println("No es posible realizar la operación, cuenta no habilitada!");
        } else if(dinero <= 0){
            //si se ingresa un monton igual a cero o negativo
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
        if(!estaHabilitada){
            System.out.println("Cuenta no habilitada, no se puede realizar la operación!");
            //si se ingresa un monton igual a cero o negativo
        } else if (dinero <= 0){
            System.out.println("Usted ingresó un monto incorrecto de dinero");
            //si el dinero es mayor que el saldo actual sumado al saldo descubierto
        } else if (dinero > saldo + saldoDescubierto){
            System.out.println("Saldo insuficiente para realizar la operación!");
            //si el dinero es mayor que el saldo actual, pero alcanza con el saldo descubierto
        } else if (dinero > saldo) {
            System.out.println("Se retiró $" + dinero + " correctamente y se utilizó $" + (dinero-saldo) + " del saldo descubierto.");
            saldoDescubierto -= (dinero-saldo);
            saldo = 0;
            //si se puede retirar el monto de manera correcta sin usar el saldo descubierto
        } else {
            System.out.println("Se retiró $" + dinero + " correctamente.");
            saldo -= dinero;
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
            } else if (dinero <= 0) {
                System.out.println("Ingreso incorrecto de monto a transferir");
            }else {
                //si los tipos de cuentas y los titulares son distintos
                if (!tipoDeCuenta.equalsIgnoreCase(cuentaDestino.getTipoDeCuenta()) && !titular.equalsIgnoreCase(cuentaDestino.getTitular())){
                    //si saldo es insuficiente
                    if(saldo < dinero + dinero * 0.03){
                        System.out.println("Error! Saldo insuficiente");
                        //si saldo suficiente, se aplica el recargo
                    } else {
                        saldo -= dinero + (dinero * 0.03);
                        System.out.println("Transferencia hecha con éxito!Se transfirió $" + dinero + "  y se aplicó un cargo adicional del 3% sobre la cuenta nro: " + nroCuenta + " del tipo " + tipoDeCuenta);
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

    @Override
    public String toString() {
        return "CajaDeAhorro{ " + "Saldo:"+ saldo + " NroCuenta:" + nroCuenta + " Titular:" + titular + " EstaHabilitada:" + estaHabilitada + " SaldoDescubierto:" + saldoDescubierto +" }";
    }



}
