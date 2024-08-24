package co.edu.uniquindio.poo.torneodeportivo;

import java.util.ArrayList;
import java.util.List;

public class Bibliotecario extends Empleado {

    private List<Libro> libros = new ArrayList();
    private List<Prestamo> prestamos = new ArrayList();

    public Bibliotecario(String nombre, double idEmpleado, List<Libro> libros, List<Prestamo> prestamos) {
        super(nombre, idEmpleado);
        this.libros = libros;
        this.prestamos = prestamos;
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

    public  void  gestionarPrestamos(List<Prestamo> prestamos){

    }
}
