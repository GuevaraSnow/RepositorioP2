package co.edu.uniquindio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Clase Biblioteca, la clase principal que contiene todas las listas.

public class Biblioteca {

    private List<Empleado> empleados = new ArrayList<>();
    private List<Libro> libros = new ArrayList<>();
    private List<Prestamo> prestamos = new ArrayList<>();
    private List<Cliente> listClientes = new ArrayList<>();

    public Biblioteca(List<Libro> listaLibros) {
        this.libros = listaLibros;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
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

    @Override
    public String toString() {
        return "Biblioteca{" +
                "empleados=" + empleados +
                '}';
    }

    public void buscarLibrosPorAutor(String autor) {
        List<Libro> librosPorAutor = new LinkedList<>();
        for (Libro libro : libros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                librosPorAutor.add(libro);
            }
        }

        if (librosPorAutor.isEmpty()) {
            System.out.println("No se encontraron libros de este autor.");
        } else {
            for (Libro libro : librosPorAutor) {
                System.out.println("El libro es: " + libro);
            }
        }
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

    public List<Cliente> getListClientes() {
        return listClientes;
    }
}




