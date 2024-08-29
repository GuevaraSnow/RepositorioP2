package co.edu.uniquindio.poo.torneodeportivo;

//Clase abstracta de Empleado con los atriutos de empleado.

public abstract class Empleado {
    private String nombre;
    private double idEmpleado;

    public Empleado(String nombre, double idEmpleado) {
        this.nombre = nombre;
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(double idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}
