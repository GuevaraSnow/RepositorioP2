package co.edu.uniquindio;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//clase main donde se evidenciará la interfaz hecha con JOption.

public class Main {

    public static void main(String[] args) {

        // Inicialización de datos
        List<Libro> listaLibros = new ArrayList<>();
        List<Prestamo> listaPrestamos = new ArrayList<>();
        List<Cliente> listaClientes = new ArrayList<>();
        GestionInventario dvd = new Dvd();
        Libro libro1 = new Libro("Gabriel García Márquez", "0001A", true, "Cien años de soledad");
        Libro libro2 = new Libro("Mario Mendoza", "0002A", true, "La Melancolía de los Feos");
        Libro libro3 = new Libro("Mario Mendoza", "0003A", true, "Satanás");
        listaLibros.add(libro1);
        listaLibros.add(libro2);
        listaLibros.add(libro3);

        Biblioteca biblioteca = new Biblioteca(listaLibros);  // Crear una instancia de Biblioteca con la lista de libros

        // Menú de opciones
        String[] opciones = {"Buscar Libro por Autor", "Agregar Libro", "Agregar Cliente", "Prestar Libro", "Devolver Libro", "Salir"};
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
                    // Agregar un nuevo cliente
                    agregarCliente(biblioteca.getListClientes());  // Pasar la lista de clientes de la biblioteca
                    break;

                case 3:
                    // Prestar un libro
                    prestarLibro(biblioteca);  // Pasar la instancia de la biblioteca
                    break;

                case 4:
                    // Devolver un libro
                    devolverLibro(biblioteca);  // Pasar la instancia de la biblioteca
                    break;

                case 5:
                    // Salir
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;

                default:
                    break;
            }
        } while (opcion != 5);
    }

    // Método para agregar un libro a la lista
    public static void agregarLibro(List<Libro> listaLibros) {
        String titulo = JOptionPane.showInputDialog("Ingresa el título del libro:");
        String autor = JOptionPane.showInputDialog("Ingresa el autor del libro:");
        String isbn = JOptionPane.showInputDialog("Ingresa el ISBN del libro:");
        boolean disponibilidad = JOptionPane.showConfirmDialog(null, "¿Está disponible el libro?", "Disponibilidad", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

        Libro nuevoLibro = new Libro(autor, isbn, disponibilidad, titulo);
        listaLibros.add(nuevoLibro);

        JOptionPane.showMessageDialog(null, "Libro agregado exitosamente.");
    }

    // Método para agregar un cliente
    public static void agregarCliente(List<Cliente> listaClientes) {
        String nombre = JOptionPane.showInputDialog("Ingresa el nombre del cliente:");
        String id = JOptionPane.showInputDialog("Ingresa el ID del cliente:");

        Cliente nuevoCliente = new Cliente(nombre, id);
        listaClientes.add(nuevoCliente);

        JOptionPane.showMessageDialog(null, "Cliente agregado exitosamente.");
    }

    // Método para prestar un libro
    public static void prestarLibro(Biblioteca biblioteca) {
        String isbn = JOptionPane.showInputDialog("Ingresa el ISBN del libro a prestar:");
        Libro libro = biblioteca.getLibros().stream()
                .filter(l -> l.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);

        if (libro != null && libro.isDisponibilidad()) {
            String clienteId = JOptionPane.showInputDialog("Ingresa el ID del cliente:");
            Cliente cliente = biblioteca.getListClientes().stream()
                    .filter(c -> c.getIdMiembro().equals(clienteId))
                    .findFirst()
                    .orElse(null);

            if (cliente != null) {
                LocalDate fechaDevolucion = LocalDate.parse(JOptionPane.showInputDialog("Ingresa la fecha de devolución (YYYY-MM-DD):"));
                biblioteca.prestarLibro(libro, cliente, fechaDevolucion);
            } else {
                JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Libro no disponible o no encontrado.");
        }
    }

    // Método para devolver un libro
    public static void devolverLibro(Biblioteca biblioteca) {
        String isbn = JOptionPane.showInputDialog("Ingresa el ISBN del libro a devolver:");
        Libro libro = biblioteca.getLibros().stream()
                .filter(l -> l.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);

        if (libro != null) {
            String clienteId = JOptionPane.showInputDialog("Ingresa el ID del cliente:");
            Cliente cliente = biblioteca.getListClientes().stream()
                    .filter(c -> c.getIdMiembro().equals(clienteId))
                    .findFirst()
                    .orElse(null);

            if (cliente != null) {
                biblioteca.devolverLibro(libro, cliente);
            } else {
                JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Libro no encontrado.");
        }
    }
}
