package co.edu.uniquindio.poo.torneodeportivo;

import java.util.ArrayList;
import java.util.List;

public class Bibliotecario extends Empleado implements GestionInventario {

    private GestionInventario g;
    private List<Libro> libros = new ArrayList();
    private List<Prestamo> prestamos = new ArrayList();

    public Bibliotecario(String nombre, double idEmpleado, List<Libro> libros, List<Prestamo> prestamos, GestionInventario g) {
        super(nombre, idEmpleado);
        this.libros = libros;
        this.prestamos = prestamos;
        this.g = g;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public void gestionarPrestamos(List<Prestamo> prestamos) {

    }

    @Override
    public Object gestionarItem() {
        System.out.println("Gestionando " + g);
        return null;
    }
}
