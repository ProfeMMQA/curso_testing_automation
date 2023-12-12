package clase05.clasesAbstractasEInterfaces.abstractas;

abstract public class Figura {
    abstract public double calcularPerimetro();
    abstract public double calcularArea();

    public void imprimirMensaje() {
        System.out.println("Hola soy una figura geometrica");
    }
}
