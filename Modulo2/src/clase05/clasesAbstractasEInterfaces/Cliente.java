package clase05.clasesAbstractasEInterfaces;

public class Cliente {

    protected String nombre;
    protected String email;

    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public void mostrarInformacion() {
        System.out.println("Mi nombre es: " + nombre);
        System.out.println("Mi email es: " + email);
    }
}
