package clase05.clasesAbstractasEInterfaces;

public class ClienteVIP extends Cliente{

    private int nivel;

    public ClienteVIP(String nombre, String email, int nivel) {
        super(nombre, email);
        this.nivel = nivel;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Nivel VIP: " + nivel);
    }
}
