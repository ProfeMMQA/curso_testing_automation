package clase04;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        ArrayList<Alumno> alumnos = new ArrayList<>();
        ArrayList<String> materias = new ArrayList<>();

        materias.add("Matematica");

        Alumno a = new Alumno("1234", 6, materias, "Martin", "Moran");

        alumnos.add(a);

        Profesor p = new Profesor(alumnos, "Carlos", "Gardel");

        NoDocente nd = new NoDocente("Claudia", "Ferreyra");

        ArrayList<Persona> listaDePersona = new ArrayList<>();

        listaDePersona.add(a);
        listaDePersona.add(p);
        listaDePersona.add(nd);

        for (Persona persona :listaDePersona) {
            persona.saludar();
        }
    }

}
