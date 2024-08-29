package co.edu.uniquindio.poo.torneodeportivo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//Clase préstamo el cual está asociado a un libro y a un miebro.

public class Prestamo {
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Libro libro;
    private Cliente miembro;

    public Prestamo(LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Cliente getMiembro() {
        return miembro;
    }

    public void setMiembro(Cliente miembro) {
        this.miembro = miembro;
    }

    public double calcularMulta() {
        LocalDate hoy = LocalDate.now();  // Obtiene la fecha actual
        if (hoy.isAfter(fechaDevolucion)) {  // Verifica si la fecha actual es posterior a la fecha de devolución
            long diasRetraso = ChronoUnit.DAYS.between(fechaDevolucion, hoy);  // Calcula los días de retraso
            return diasRetraso * 0.50;  // Calcula la multa multiplicando por el valor por día de retraso
        }
        return 0;  // Retorna 0 si no hay retraso
    }
}
