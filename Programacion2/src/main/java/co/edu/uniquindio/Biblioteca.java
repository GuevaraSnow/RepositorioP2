package co.edu.uniquindio.poo.torneodeportivo;


import java.util.ArrayList;
import java.util.List;

public class Biblioteca implements GestionarEmpleado {

    private GestionarEmpleado gB;
    private List<Empleado> empleados = new ArrayList<>();

    public Biblioteca(GestionarEmpleado gB, List<Empleado> empleados) {
        this.gB = gB;
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


    public void setgB(GestionarEmpleado gB) {
        this.gB = gB;
    }

    @Override
    public void gestionarBibliotecario() {

        if (gB != null) {
            gB.gestionarBibliotecario();
        } else {
            System.out.println("No se puede gestionar la biblioteca");
        }
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "gB=" + gB +
                ", empleados=" + empleados +
                '}';
    }
}
