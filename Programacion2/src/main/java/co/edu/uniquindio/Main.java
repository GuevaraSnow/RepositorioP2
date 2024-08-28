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

        Biblioteca biblioteca = new Biblioteca(listaLibros);  // Crear una instancia de Biblioteca con la lista de libros

        // Menú de opciones
        String[] opciones = {"Buscar Libro por Autor", "Agregar Libro", "Gestionar Ítems", "Salir"};
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
                    // Buscar libro por autor usando el método de la clase Biblioteca
                    String autor = JOptionPane.showInputDialog("Ingresa el nombre del autor:");
                    biblioteca.buscarLibrosPorAutor(autor);  // Llamar al método directamente
                    break;

                case 1:
                    // Agregar un nuevo libro
                    agregarLibro(biblioteca.getLibros());  // Pasar la lista de libros de la biblioteca
                    break;

                case 2:
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

                    String gestionResultado;
                    if (bibliotecarioSeleccionado == 0) {
                        gestionResultado = "El bibliotecario Luis ha gestionado el ítem.";
                    } else if (bibliotecarioSeleccionado == 1) {
                        gestionResultado = "El bibliotecario Manuel ha gestionado el ítem.";
                    } else {
                        gestionResultado = "No se seleccionó un bibliotecario.";
                    }

                    JOptionPane.showMessageDialog(null, gestionResultado);
                    break;

                case 3:
                    // Salir
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;

                default:
                    break;
            }
        } while (opcion != 3);
    }

    // Método para agregar un libro a la lista
    public static void agregarLibro(List<Libro> listaLibros) {
        String titulo = JOptionPane.showInputDialog("Ingresa el título del libro:");
        String autor = JOptionPane.showInputDialog("Ingresa el autor del libro:");
        String isbn = JOptionPane.showInputDialog("Ingresa el ISBN del libro:");
        boolean disponibilidad = JOptionPane.showConfirmDialog(null, "¿Está disponible el libro?", "Disponibilidad", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

        Libro nuevoLibro = new Libro(autor, isbn, disponibilidad, titulo);
        listaLibros.add(nuevoLibro);

        JOptionPane.showMessageDialog(null, "Libro agregado exitosamente:\n" + nuevoLibro.toString());
    }
}

