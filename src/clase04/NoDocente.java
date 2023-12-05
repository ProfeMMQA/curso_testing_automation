package clase04;

public class NoDocente extends Persona {
    NoDocente(String nombre, String apellido) {
        this.apellido = apellido;
        this.nombre = nombre;
    }

    @Override
    public void saludar() {
        System.out.println("Buen día");
    }
}
