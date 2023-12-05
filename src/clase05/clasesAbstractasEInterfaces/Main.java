package clase05.clasesAbstractasEInterfaces;

public class Main {
    public static void main(String[] args) {
        Cliente c = new Cliente("Sergio", "asd@asd.com");
        ClienteVIP vip = new ClienteVIP("Juan", "juan@juancito.ar", 3);

        c.mostrarInformacion();
        vip.mostrarInformacion();
    }
}
