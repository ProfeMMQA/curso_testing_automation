package clase04;

import java.util.ArrayList;

public class Alumno extends Persona {
    private String matricula;
    private Integer nota;
    private ArrayList<String> materias;

    public Alumno(String matricula, Integer nota, ArrayList<String> materias, String nombre, String apellido) {
        this.matricula = matricula;
        this.materias = materias;
        this.nota = nota;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public void saludar() {
        System.out.println("Que ondaaaaaaaa");
    }

    public String getApellido() {
        return super.getApellido();
    }

    public String getNombre() {
        return super.getNombre();
    }

    public void setApellido(String apellido) {
        super.setApellido(apellido);
    }

    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    public ArrayList<String> getMaterias() {
        return materias;
    }

    public Integer getNota() {
        return nota;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMaterias(ArrayList<String> materias) {
        this.materias = materias;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }
}

