package clase05.clasesAbstractasEInterfaces.abstractas;

public class Circulo extends Figura{

    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2*radio*Math.PI;
    }

    @Override
    public double calcularArea() {
        return Math.PI*radio*radio;
    }
}
