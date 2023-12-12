package clase05.clasesAbstractasEInterfaces.abstractas;

public class Rectangulo extends Figura {

    private double ancho;
    private double alto;

    public Rectangulo(double ancho, double alto) {
        this.alto = alto;
        this.ancho = ancho;
    }

    @Override
    public double calcularPerimetro() {
        return 2*ancho+2*alto;
    }

    @Override
    public double calcularArea() {
        return ancho*alto;
    }
}
