package co.edu.uniquindio.poo.torneodeportivo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Libro> listaLibros = new ArrayList<>();
        List<Prestamo> listaPrestamos = new ArrayList<>();
        GestionInventario dvd = new Dvd();
        Libro libro1 = new Libro("Gabriel García Márquez", "0001A",true, "Cien años de soledad");
        Libro libro2 = new Libro("Mario Mendoza","0002A",true,"La Melancolía de los Feos");
        Libro libro3 = new Libro("Mario Mendoza","003A",true, "Satanás");
        listaLibros.add(libro1);
        listaLibros.add(libro2);
        listaLibros.add(libro3);
        Prestamo prestamo1 = new Prestamo(LocalDate.now(), LocalDate.of(2024, 10, 26));
        Bibliotecario bibliotecario1 = new Bibliotecario("Luis", 001, listaLibros, listaPrestamos, dvd);
        Bibliotecario bibliotecario2 = new Bibliotecario("Manuel", 002, listaLibros, listaPrestamos, libro1);
        bibliotecario1.gestionarItem();
        bibliotecario2.gestionarItem();
        Biblioteca buscarLibro = new Biblioteca(listaLibros);
        buscarLibro.buscarLibrosPorAutor("Mario Mendoza");
    }
}