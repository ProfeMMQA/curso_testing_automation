package clase04;

import java.net.Inet4Address;
import java.util.ArrayList;

public class Profesor extends Persona {
    ArrayList<Alumno> listaDeAlumnos;

    public Profesor(ArrayList<Alumno> listaDeAlumnos, String nombre, String apellido) {
        this.listaDeAlumnos = listaDeAlumnos;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public void saludar() {
        System.out.println("Hola a todos");
    }

    public void calificar(Alumno alumno, Integer nota) {

        //Recorro la lista de alumnos
        for (Alumno al:listaDeAlumnos) {
            if (al == alumno) {
                //Le asigno la nota al alumno que me pasaron por parametro
                al.setNota(nota);
            }
        }
    }

    public void calificar(Integer nota) {
        for (Alumno al:listaDeAlumnos) {
            al.setNota(nota);
        }
    }

    public void setApellido(String apellido) {
        super.setApellido(apellido);
    }

    public String getNombre() {
        return super.getNombre();
    }

    public String getApellido() {
        return super.getApellido();
    }

    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    public ArrayList<Alumno> getListaDeAlumnos() {
        return listaDeAlumnos;
    }

    public void setListaDeAlumnos(ArrayList<Alumno> listaDeAlumnos) {
        this.listaDeAlumnos = listaDeAlumnos;
    }
}
