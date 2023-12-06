package clase05.excepciones.cuentaBancaria;

public class CuentaBancaria {
    private int fondos;

    public CuentaBancaria(int fondosIniciales) {
        this.fondos = fondosIniciales;
    }

    public void extraer(int cantidadAExtraer) throws FondosInsuficientesException {
        if (fondos - cantidadAExtraer < 0 ) {
            throw new FondosInsuficientesException();
        }
        this.fondos = this.fondos - cantidadAExtraer;
    }

    public void extraer(int cantidadAExtraer, int cantidadDeVeces) throws FondosInsuficientesException {
        if (fondos - (cantidadAExtraer*cantidadDeVeces) < 0 ) {
            throw new FondosInsuficientesException();
        }
        this.fondos = this.fondos - cantidadAExtraer;
    }
}
