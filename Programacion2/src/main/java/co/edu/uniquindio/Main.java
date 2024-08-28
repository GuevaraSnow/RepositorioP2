package co.edu.uniquindio.poo.torneodeportivo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Libro> listaLibros = new ArrayList<>();
        List<Prestamo> listaPrestamos = new ArrayList<>();
        GestionInventario dvd = new Dvd();
        Libro libro1 = new Libro("Gabriel García Márquez", "0001A",true, "Cien años de soledad");
        Prestamo prestamo1 = new Prestamo(LocalDate.now(), LocalDate.of(2024, 10, 26));
        Bibliotecario bibliotecario1 = new Bibliotecario("Luis", 001, listaLibros, listaPrestamos, dvd);
        Bibliotecario bibliotecario2 = new Bibliotecario("Manuel", 002, listaLibros, listaPrestamos, libro1);
        bibliotecario1.gestionarItem();
        bibliotecario2.gestionarItem();




        // Crear instancias de los objetos necesarios
        Cliente cliente1 = new Cliente("Juan Pérez", "C001", 0.0);

        // Crear una colección de clientes y libros
        Collection<Cliente> miembrosBiblioteca = new ArrayList<>();
        miembrosBiblioteca.add(cliente1);

        List<Prestamo> prestamosBiblioteca = new ArrayList<>();

        // Crear un bibliotecario
        Bibliotecario bibliotecario = new Bibliotecario("Luis", 1, new ArrayList<>(), prestamosBiblioteca, libro1);

        // Crear un sistema de gestión de biblioteca
        SistemaGestionBiblioteca sistema = new SistemaGestionBiblioteca(bibliotecario, miembrosBiblioteca, prestamosBiblioteca);

        // Crear un préstamo
        LocalDate fechaPrestamo = LocalDate.now();
        LocalDate fechaDevolucion = fechaPrestamo.plusDays(7); // El libro debe ser devuelto en 7 días
        int codigoPrestamo = 1001;

        // Agregar el préstamo al sistema
        sistema.realizarPrestamo(codigoPrestamo, cliente1, libro1, fechaDevolucion);

        // Mostrar los detalles del cliente y los préstamos
        System.out.println("Cliente después de préstamo: " + cliente1);
        System.out.println("Préstamos en el sistema: " + sistema.getPrestamoBiblioteca());

        // Simular la devolución del préstamo antes del plazo
        LocalDate fechaDevolucionReal = fechaPrestamo.plusDays(5); // Devolución anticipada
        sistema.devolverPrestamo(codigoPrestamo, fechaDevolucionReal);

        // Mostrar los detalles del cliente después de la devolución
        System.out.println("Cliente después de devolución (antes del plazo): " + cliente1);

        // Simular la devolución del préstamo después del plazo para ver la multa
        LocalDate fechaDevolucionTarde = fechaPrestamo.plusDays(10); // Devolución tardía
        sistema.realizarPrestamo(codigoPrestamo, cliente1, libro1, fechaDevolucionTarde);

        // Devolver el préstamo tardío
        sistema.devolverPrestamo(codigoPrestamo, fechaDevolucionTarde);

        // Mostrar los detalles del cliente después de la devolución tardía
        System.out.println("Cliente después de devolución tardía: " + cliente1);

        double valorMulta = cliente1.getSaldoMulta();

        System.out.print(valorMulta);
        }
    }

