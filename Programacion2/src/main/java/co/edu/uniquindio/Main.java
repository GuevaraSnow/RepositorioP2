package co.edu.uniquindio.poo.torneodeportivo;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Inicialización de datos
        List<Libro> listaLibros = new ArrayList<>();
        List<Prestamo> listaPrestamos = new ArrayList<>();
        GestionInventario dvd = new Dvd();
        Libro libro1 = new Libro("Gabriel García Márquez", "0001A", true, "Cien años de soledad");
        Libro libro2 = new Libro("Mario Mendoza", "0002A", true, "La Melancolía de los Feos");
        Libro libro3 = new Libro("Mario Mendoza", "0003A", true, "Satanás");
        listaLibros.add(libro1);
        listaLibros.add(libro2);
        listaLibros.add(libro3);

        Prestamo prestamo1 = new Prestamo(LocalDate.now(), LocalDate.of(2024, 10, 26));
        Bibliotecario bibliotecario1 = new Bibliotecario("Luis", 001, listaLibros, listaPrestamos, dvd);
        Bibliotecario bibliotecario2 = new Bibliotecario("Manuel", 002, listaLibros, listaPrestamos, libro1);

        Biblioteca buscarLibro = new Biblioteca(listaLibros);

        // Menú de opciones
        String[] opciones = {"Buscar Libro por Autor", "Gestionar Ítems", "Salir"};
        int opcion;
        do {
            opcion = JOptionPane.showOptionDialog(
                    null,
                    "Selecciona una opción",
                    "Gestión de Biblioteca",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (opcion) {
                case 0:
                    // Buscar libro por autor
                    String autor = JOptionPane.showInputDialog("Ingresa el nombre del autor:");
                    String resultado = buscarLibrosPorAutor(autor, listaLibros);
                    JOptionPane.showMessageDialog(null, resultado);
                    break;

                case 1:
                    // Gestionar ítems
                    String[] bibliotecarios = {"Luis", "Manuel"};
                    int bibliotecarioSeleccionado = JOptionPane.showOptionDialog(
                            null,
                            "Selecciona un bibliotecario para gestionar ítems",
                            "Gestión de Ítems",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            bibliotecarios,
                            bibliotecarios[0]
                    );

                    if (bibliotecarioSeleccionado == 0) {
                        JOptionPane.showMessageDialog(null, bibliotecario1.gestionarItem());
                    } else if (bibliotecarioSeleccionado == 1) {
                        JOptionPane.showMessageDialog(null, bibliotecario2.gestionarItem());
                    }
                    break;

                case 2:
                    // Salir
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;

                default:
                    break;
            }
        } while (opcion != 2);
    }

    public static String buscarLibrosPorAutor(String autor, List<Libro> listaLibros) {
        StringBuilder resultado = new StringBuilder();
        for (Libro libro : listaLibros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                resultado.append(libro.toString()).append("\n");
            }
        }
        if (resultado.length() == 0) {
            return "No se encontraron libros del autor: " + autor;
        } else {
            return "Libros encontrados:\n" + resultado.toString();
        }
    }
}
