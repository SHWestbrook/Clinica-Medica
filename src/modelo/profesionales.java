package modelo;


import java.util.List;

public class profesionales {
    private int id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String numeroTelef;
    private int comision;
    private String direccion;
    private String cp;
    private String email;
    //relaciones
    private List<liquidaciones>liquidacionesList;

    //constructor

//hacerlo sin las relaciones
    public profesionales(int id, String nombre, String apellidos, String dni, String numeroTelef, int comision, List<liquidaciones> liquidacionesList) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.numeroTelef = numeroTelef;
        this.comision = comision;
        this.liquidacionesList = liquidacionesList;
    }

    public profesionales(int id, String nombre, String apellidos, String dni, String numeroTelef, int comision, String direccion, String cp, String email, List<liquidaciones> liquidacionesList) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.numeroTelef = numeroTelef;
        this.comision = comision;
        this.direccion = direccion;
        this.cp = cp;
        this.email = email;
        this.liquidacionesList = liquidacionesList;
    }

    public profesionales() {
    }
    //setters
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public void setNumeroTelef(String numeroTelef) {
        this.numeroTelef = numeroTelef;
    }
    public void setComision(int comision) {
        this.comision = comision;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setCp(String cp) {
        this.cp = cp;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    //getters
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getDni() {
        return dni;
    }
    public String getNumeroTelef() {
        return numeroTelef;
    }
    public int getComision() {
        return comision;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getCp() {
        return cp;
    }
    public String getEmail() {
        return email;
    }
}
