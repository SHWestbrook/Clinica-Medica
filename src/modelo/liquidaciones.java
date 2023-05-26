package modelo;

import java.time.LocalDate;

public class liquidaciones {
    private int id;
    private LocalDate fecha;
    private int idProfesional;
    private int comision;
    //relaciones
    private profesionales profesional;

    public liquidaciones() {
    }
    public liquidaciones(int id, LocalDate fecha, int idProfesional, int comision, profesionales profesional) {
        this.id = id;
        this.fecha = fecha;
        this.idProfesional = idProfesional;
        this.comision = comision;
        this.profesional = profesional;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public void setIdProfesional(int idProfesional) {
        this.idProfesional = idProfesional;
    }
    public void setComision(int comision) {
        this.comision = comision;
    }
    //getters
    public int getId() {
        return id;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public int getIdProfesional() {
        return idProfesional;
    }
    public int getComision() {
        return comision;
    }


}
