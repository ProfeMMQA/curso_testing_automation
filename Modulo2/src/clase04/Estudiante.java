package clase04;

public class Estudiante {
    //Definicion de atributos
    private Integer id;
    private String nombreCompleto;
    private Float promedio;

    public Estudiante() {}

    public Estudiante(Integer idParametro, String nombreCompletoParametro) {
        this.id = idParametro;
        this.nombreCompleto = nombreCompletoParametro;
    }

    public Estudiante(Integer idParametro, String nombreCompletoParametro, Float promedioParametro) {
        this.id = idParametro;
        this.nombreCompleto = nombreCompletoParametro;
        this.promedio = promedioParametro;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer nuevoId) {
        this.id = nuevoId;
    }
}
