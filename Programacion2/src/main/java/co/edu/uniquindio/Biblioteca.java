package co.edu.uniquindio.poo.torneodeportivo;


import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Empleado> empleados = new ArrayList<>();

    public Biblioteca(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public Biblioteca() {

    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "empleados=" + empleados +
                '}';
    }
}
