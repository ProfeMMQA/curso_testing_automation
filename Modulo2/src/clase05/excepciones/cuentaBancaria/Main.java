package clase05.excepciones.cuentaBancaria;

public class Main {

    public static void main(String[] args) {
        CuentaBancaria c = new CuentaBancaria(1000);
        c.extraer(1001);
    }
}
