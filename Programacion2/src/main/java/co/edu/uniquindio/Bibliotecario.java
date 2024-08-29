package co.edu.uniquindio.poo.torneodeportivo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Clase Bibliotecario, el cual hereda de empleado sus atributos. Es la encargada de gestionar tanto prestamos cómo items.

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

    public void prestarLibro(Libro libro, Cliente cliente, LocalDate fechaDevolucion) {
        if (libro.isDisponibilidad()) {
            Prestamo prestamo = new Prestamo(LocalDate.now(), fechaDevolucion);
            prestamo.setLibro(libro);
            prestamo.setMiembro(cliente);
            prestamos.add(prestamo);
            libro.setDisponibilidad(false);
            cliente.añadirPrestamo(prestamo);
            System.out.println("Libro prestado exitosamente.");
        } else {
            System.out.println("El libro no está disponible.");
        }
    }

    public void devolverLibro(Libro libro, Cliente cliente) {
        Prestamo prestamo = null;
        for (Prestamo p : prestamos) {
            if (p.getLibro().equals(libro) && p.getMiembro().equals(cliente)) {
                prestamo = p;
                break;
            }
        }
        if (prestamo != null) {
            prestamos.remove(prestamo);
            libro.setDisponibilidad(true);
            cliente.eliminarPrestamo(prestamo);
            double multa = prestamo.calcularMulta();
            if (multa > 0) {
                System.out.println("El libro se devolvió tarde. Multa: " + multa);
            } else {
                System.out.println("Libro devuelto exitosamente sin multa.");
            }
        } else {
            System.out.println("No se encontró el préstamo para este libro y cliente.");
        }
    }
}
