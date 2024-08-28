package co.edu.uniquindio.poo.torneodeportivo;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Biblioteca {

    private List<Empleado> empleados = new ArrayList<>();
    private List<Libro> libros= new LinkedList<>();
    public Biblioteca(List<Empleado> empleados) {
        this.empleados = empleados;
    }
    public List<Prestamo> ListarPrestamos = new LinkedList<>();
    public List<Prestamo> getListarPrestamos() {
        return ListarPrestamos;
    }



    public void setListarPrestamos(List<Prestamo> listarPrestamos) {
        ListarPrestamos = listarPrestamos;
    }

    public Biblioteca() {

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

    @Override
    public String toString() {
        return "Biblioteca{" +
                "empleados=" + empleados +
                '}';
    }

    //Metodo para buscar Libros por Autor

    public  List<Libro> buscarLibrosPorAutor(String autor){
        List<Libro> librosPorAutor= new LinkedList<>();
        for (Libro libro:libros){
            if(libro.getAutor().equalsIgnoreCase(autor)){
                librosPorAutor.add(libro);
            }
        }
        return librosPorAutor;
    }
}

