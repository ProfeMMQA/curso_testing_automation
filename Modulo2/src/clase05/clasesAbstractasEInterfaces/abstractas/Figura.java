package clase05.clasesAbstractasEInterfaces.abstractas;

abstract public class Figura {

    private int unAtributo;
    private String otroAtributo;

    abstract public double calcularPerimetro();
    abstract public double calcularArea();

    public void imprimirMensaje() {
        System.out.println("Hola soy una figura geometrica");
    }
}
