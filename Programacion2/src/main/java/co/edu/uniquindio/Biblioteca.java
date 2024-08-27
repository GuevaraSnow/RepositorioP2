package co.edu.uniquindio.poo.torneodeportivo;


import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Empleado> empleados = new ArrayList<>();
    private List<Libro> libros= new Arraylist<>();
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

    public  List<Libro> buscarLibrosPorAutor(String autor{
        List<Libro> librosPorAutos= new Arraylist <> ();
        for (Libro libro:libros){
            if(libro.getAutor().equalsIgnoereCase(Autor)){
                librosPorAutos.add(libro);
            }
        }
        return librosPorAutos;
    }
}

