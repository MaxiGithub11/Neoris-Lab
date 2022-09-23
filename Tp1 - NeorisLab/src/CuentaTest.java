import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

class CuentaTest {

    //TEST CAJA DE AHORRO

    //DEPOSITAR

    @Test
    @DisplayName("Cuando se deposita correctamente a una caja de ahorro")
    void test_se_deposita_a_una_caja_de_ahorro(){
        Cuenta cuenta = new CajaDeAhorro(1000, 1, "Ricardo Bochini", true, "caja de ahorro", 0);
        cuenta.depositar(500);
        assertEquals(1500.0, cuenta.getSaldo());
    }

    @Test
    @DisplayName("Cuando se deposita a una caja de ahorro inválida")
    void test_se_deposita_a_una_caja_de_ahorro_invalida(){
        Cuenta cuenta = new CajaDeAhorro(1000, 1, "Ricardo Bochini", false, "caja de ahorro", 0);
        cuenta.depositar(500);
        assertEquals(1000.0, cuenta.getSaldo());
    }

    @Test
    @DisplayName("Cuando se quiere depositar dinero negativo a una caja de ahorro")
    void test_se_deposita_dinero_negativo_a_una_caja_de_ahorro(){
        Cuenta cuenta = new CajaDeAhorro(1000, 1, "Ricardo Bochini", true, "caja de ahorro", 0);
        cuenta.depositar(-500);
        assertEquals(1000.0, cuenta.getSaldo());
    }

    //RETIRAR

    @Test
    @DisplayName("Cuando se retira correctamente de una caja de ahorro")
    void test_se_retira_de_una_caja_de_ahorro(){
        Cuenta cuenta = new CajaDeAhorro(1000, 1, "Ricardo Bochini", true, "caja de ahorro", 0);
        cuenta.retirar(500);
        assertEquals(500.0, cuenta.getSaldo());
    }

    @Test
    @DisplayName("Cuando se retira de una caja de ahorro no habilitada")
    void test_se_retira_de_una_caja_de_ahorro_no_habilitada(){
        Cuenta cuenta = new CajaDeAhorro(1000, 1, "Ricardo Bochini", false, "caja de ahorro", 0);
        cuenta.retirar(500);
        assertEquals(1000.0, cuenta.getSaldo());
    }

    @Test
    @DisplayName("Cuando se retira dinero negativo de una caja de ahorro")
    void test_se_retira_dinero_negativo_de_una_caja_de_ahorro(){
        Cuenta cuenta = new CajaDeAhorro(1000, 1, "Ricardo Bochini", true, "caja de ahorro", 0);
        cuenta.retirar(-500);
        assertEquals(1000.0, cuenta.getSaldo());
    }

    @Test
    @DisplayName("Cuando se retira más dinero que el saldo de una caja de ahorro")
    void test_se_retira_mas_dinero_que_saldo_de_una_caja_de_ahorro(){
        Cuenta cuenta = new CajaDeAhorro(1000, 1, "Ricardo Bochini", true, "caja de ahorro", 0);
        cuenta.retirar(1500);
        assertEquals(1000.0, cuenta.getSaldo());
    }

    //TRANSFERIR

    @Test
    @DisplayName("Cuando se quiere transferir más dinero que el saldo de una caja de ahorro")
    void test_se_transfiere_mas_dinero_que_el_saldo_de_una_caja_de_ahorro(){
        Cuenta cuenta = new CajaDeAhorro(1000, 1, "Ricardo Bochini", true, "caja de ahorro", 200);
        Cuenta cuenta2 = new CajaDeAhorro(500, 2, "Pepe Santoro", true, "caja de ahorro", 100);
        cuenta.transferir(1500, cuenta2);
        assertEquals(1000.0, cuenta.getSaldo());
        assertEquals(500.0, cuenta2.getSaldo());
    }

    @Test
    @DisplayName("Cuando se quiere transferir pero alguna de las cuentas no esta habilitada en una caja de ahorro")
    void test_se_quiere_transferir_pero_no_esta_habilitada_una_caja_de_ahorro(){
        Cuenta cuenta = new CajaDeAhorro(1000, 1, "Ricardo Bochini", true, "caja de ahorro", 200);
        Cuenta cuenta2 = new CajaDeAhorro(500, 2, "Pepe Santoro", false, "caja de ahorro", 100);
        cuenta.transferir(400, cuenta2);
        assertEquals(1000.0, cuenta.getSaldo());
        assertEquals(500.0, cuenta2.getSaldo());
    }

    @Test
    @DisplayName("Cuando se quiere transferir pero se ingresa cero o un monton negativo en una caja de ahorro")
    void test_se_quiere_transferir_pero_se_ingresa_monto_negativo_una_caja_de_ahorro(){
        Cuenta cuenta = new CajaDeAhorro(1000, 1, "Ricardo Bochini", true, "caja de ahorro", 200);
        Cuenta cuenta2 = new CajaDeAhorro(500, 2, "Pepe Santoro", true, "caja de ahorro", 100);
        cuenta.transferir(-400, cuenta2);
        assertEquals(1000.0, cuenta.getSaldo());
        assertEquals(500.0, cuenta2.getSaldo());
    }

    @Test
    @DisplayName("Cuando se quiere transferir desde caja de ahorro, las cuentas son de distinto tipo y de distinto titular")
    void test_se_quiere_transferir_distintos_titulares_tipos_de_cuentas(){
        Cuenta cuenta = new CajaDeAhorro(1000, 1, "Ricardo Bochini", true, "caja de ahorro", 200);
        Cuenta cuenta2 = new CuentaCorriente(500, 2, "Pepe Santoro", true, "cuenta corriente", 100);
        cuenta.transferir(400, cuenta2);
        assertEquals(594.0, cuenta.getSaldo());
        assertEquals(900.0, cuenta2.getSaldo());
    }

    @Test
    @DisplayName("Cuando transfiere desde caja de ahorro sin cargo")
    void test_se_quiere_transferir_sin_cargo(){
        Cuenta cuenta = new CajaDeAhorro(1000, 1, "Ricardo Bochini", true, "caja de ahorro", 200);
        Cuenta cuenta2 = new CajaDeAhorro(500, 2, "Pepe Santoro", true, "caja de ahorro", 100);
        cuenta.transferir(400, cuenta2);
        assertEquals(600.0, cuenta.getSaldo());
        assertEquals(900.0, cuenta2.getSaldo());
    }

    //TEST CUENTA CORRIENTE

    //DEPOSITAR

    @Test
    @DisplayName("Cuando se deposita correctamente a una cuenta corriente")
    void test_se_deposita_a_una_cuenta_corriente(){
        Cuenta cuenta = new CuentaCorriente(1000, 1, "Ricardo Bochini", true, "cuenta corriente", 0);
        cuenta.depositar(500);
        assertEquals(1500.0, cuenta.getSaldo());
    }

    @Test
    @DisplayName("Cuando se deposita a una cuenta corriente inválida")
    void test_se_deposita_a_una_cuenta_corriente_invalida(){
        Cuenta cuenta = new CuentaCorriente(1000, 1, "Ricardo Bochini", false, "cuenta corriente", 0);
        cuenta.depositar(500);
        assertEquals(1000.0, cuenta.getSaldo());
    }

    @Test
    @DisplayName("Cuando se quiere depositar dinero negativo a una cuenta corriente")
    void test_se_deposita_dinero_negativo_a_una_cuenta_corriente(){
        Cuenta cuenta = new CuentaCorriente(1000, 1, "Ricardo Bochini", true, "cuenta corriente", 0);
        cuenta.depositar(-500);
        assertEquals(1000.0, cuenta.getSaldo());
    }

    //RETIRAR

    @Test
    @DisplayName("Cuando se retira correctamente de una cuenta corriente")
    void test_se_retira_de_una_cuenta_corriente(){
        Cuenta cuenta = new CuentaCorriente(1000, 1, "Ricardo Bochini", true, "cuenta corriente", 0);
        cuenta.retirar(500);
        assertEquals(500.0, cuenta.getSaldo());
    }

    @Test
    @DisplayName("Cuando se retira de una caja de cuenta corriente no habilitada")
    void test_se_retira_de_una_cuenta_corriente_no_habilitada(){
        Cuenta cuenta = new CuentaCorriente(1000, 1, "Ricardo Bochini", false, "cuenta corriente", 0);
        cuenta.retirar(500);
        assertEquals(1000.0, cuenta.getSaldo());
    }

    @Test
    @DisplayName("Cuando se retira dinero negativo de una cuenta corriente")
    void test_se_retira_dinero_negativo_de_una_cuenta_corriente(){
        Cuenta cuenta = new CuentaCorriente(1000, 1, "Ricardo Bochini", true, "cuenta corriente", 0);
        cuenta.retirar(-500);
        assertEquals(1000.0, cuenta.getSaldo());
    }

    @Test
    @DisplayName("Cuando se retira más dinero que el saldo de una cuenta corriente")
    void test_se_retira_mas_dinero_que_saldo_de_una_cuenta_corriente(){
        Cuenta cuenta = new CuentaCorriente(1000, 1, "Ricardo Bochini", true, "cuenta corriente", 500);
        cuenta.retirar(2000);
        assertEquals(1000.0, cuenta.getSaldo());
    }

    @Test
    @DisplayName("Cuando se retira más dinero que el saldo de una cuenta corriente, pero se usa el saldo descubierto")
    void test_se_retira_mas_dinero_que_saldo_de_una_cuenta_corriente_y_se_usa_saldo_descubierto(){
        Cuenta cuenta = new CuentaCorriente(1000, 1, "Ricardo Bochini", true, "cuenta corriente", 500);
        cuenta.retirar(1400);
        assertEquals(0.0, cuenta.getSaldo());
        assertEquals(100.0, cuenta.getSaldoDescubierto());
    }

    //TRANSFERIR

    @Test
    @DisplayName("Cuando se quiere transferir más dinero que el saldo de una cuenta corriente")
    void test_se_transfiere_mas_dinero_que_el_saldo_de_una_cuenta_corriente(){
        Cuenta cuenta = new CuentaCorriente(1000, 1, "Ricardo Bochini", true, "cuenta corriente", 200);
        Cuenta cuenta2 = new CuentaCorriente(500, 2, "Pepe Santoro", true, "cuenta corriente", 100);
        cuenta.transferir(1500, cuenta2);
        assertEquals(1000.0, cuenta.getSaldo());
        assertEquals(500.0, cuenta2.getSaldo());
    }

    @Test
    @DisplayName("Cuando se quiere transferir pero alguna de las cuentas no esta habilitada en una cuenta corriente")
    void test_se_quiere_transferir_pero_no_esta_habilitada_una_cuenta_corriente(){
        Cuenta cuenta = new CuentaCorriente(1000, 1, "Ricardo Bochini", true, "cuenta corriente", 200);
        Cuenta cuenta2 = new CuentaCorriente(500, 2, "Pepe Santoro", false, "cuenta corriente", 100);
        cuenta.transferir(400, cuenta2);
        assertEquals(1000.0, cuenta.getSaldo());
        assertEquals(500.0, cuenta2.getSaldo());
    }

    @Test
    @DisplayName("Cuando se quiere transferir pero se ingresa cero o un monton negativo en una cuenta corriente")
    void test_se_quiere_transferir_pero_se_ingresa_monto_negativo_una_cuenta_corriente(){
        Cuenta cuenta = new CuentaCorriente(1000, 1, "Ricardo Bochini", true, "cuenta corriente", 200);
        Cuenta cuenta2 = new CuentaCorriente(500, 2, "Pepe Santoro", true, "cuenta corriente", 100);
        cuenta.transferir(-400, cuenta2);
        assertEquals(1000.0, cuenta.getSaldo());
        assertEquals(500.0, cuenta2.getSaldo());
    }

    @Test
    @DisplayName("Cuando se quiere transferir desde cuenta corriente, las cuentas son de distinto tipo y de distinto titular")
    void test_se_quiere_transferir_distintos_titulares_tipos_de_cuentas_corriente(){
        Cuenta cuenta = new CuentaCorriente(1000, 1, "Ricardo Bochini", true, "cuenta corriente", 200);
        Cuenta cuenta2 = new CajaDeAhorro(500, 2, "Pepe Santoro", true, "caja de ahorro", 100);
        cuenta.transferir(400, cuenta2);
        assertEquals(588.0, cuenta.getSaldo());
        assertEquals(900.0, cuenta2.getSaldo());
    }

    @Test
    @DisplayName("Cuando transfiere desde cuenta corriente sin cargo")
    void test_se_quiere_transferir_sin_cargo_desde_cuenta_corriente(){
        Cuenta cuenta = new CuentaCorriente(1000, 1, "Ricardo Bochini", true, "cuenta corriente", 200);
        Cuenta cuenta2 = new CuentaCorriente(500, 2, "Pepe Santoro", true, "cuenta corriente", 100);
        cuenta.transferir(400, cuenta2);
        assertEquals(600.0, cuenta.getSaldo());
        assertEquals(900.0, cuenta2.getSaldo());
    }

    //CUENTAS HACKEABLES

    @Test
    @DisplayName("Cuando se quiere saber si alguna cuenta es hackeable")
    public void test_saber_alguna_cuenta_hackeable(){
        ArrayList<Cuenta> listaCuentas = new ArrayList<>();

        listaCuentas.add(new CajaDeAhorro(100000, 1, "Pepito Gallardo", true, "caja de ahorro", 0));
        listaCuentas.add(new CuentaCorriente(4000, 2, "Juan Hernandez", true, "cuenta corriente", 500));
        listaCuentas.add(new CajaDeAhorro(40000, 3, "Nicolas Raymundo", false, "caja de ahorro", 0));
        listaCuentas.add(new CuentaCorriente(70050, 4, "Marcos Galperin Gimenez", true, "cuenta corriente", 250));
        listaCuentas.add(new CajaDeAhorro(80000, 5, "Raul Garcia Marquez", false, "caja de ahorro", 0));

        System.out.println("Alguna cuenta hackeable? " + Cuenta.algunaCuentaPuedeSerHackeada(listaCuentas));
        assertTrue(Cuenta.algunaCuentaPuedeSerHackeada(listaCuentas));
    }

    //TITULARES APTO PARA PRESTAMO

    @Test
    @DisplayName("Cuando se quiere saber la lista de Titulares apto para préstamo")
    public void test_se_quiere_saber_titulares_aptos_prestamo(){
        ArrayList<Cuenta> listaCuentas = new ArrayList<>();

        listaCuentas.add(new CajaDeAhorro(100000, 1, "Pepito Gallardo", true, "caja de ahorro", 0));
        listaCuentas.add(new CuentaCorriente(4000, 2, "Juan Hernandez", true, "cuenta corriente", 500));
        listaCuentas.add(new CajaDeAhorro(40000, 3, "Nicolas Raymundo", false, "caja de ahorro", 0));
        listaCuentas.add(new CuentaCorriente(70050, 4, "Marcos Galperin Gimenez", true, "cuenta corriente", 250));
        listaCuentas.add(new CajaDeAhorro(80000, 5, "Raul Garcia Marquez", false, "caja de ahorro", 0));

        Cuenta.obtenerTitularesAptosParaPrestamos(listaCuentas);
    }

}