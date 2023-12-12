package clase05.excepciones.cuentaBancaria;

public class FondosInsuficientesException extends RuntimeException {

    public FondosInsuficientesException() {
        super("Los fondos que intentaste extraer no estan disponibles");
    }

}
