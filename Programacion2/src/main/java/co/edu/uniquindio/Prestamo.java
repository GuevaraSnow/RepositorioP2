package co.edu.uniquindio.poo.torneodeportivo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Prestamo {
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private  int codigoPrestamo;
    private Libro libro;
    private Cliente miembro;

    public Prestamo(LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Prestamo(int codigoPrestamo, LocalDate fechaPrestamo, LocalDate fechaDevolucion, Libro libro, Cliente miembro){
        this.codigoPrestamo = codigoPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this. fechaDevolucion = fechaDevolucion;
        this.libro = libro;
        this.miembro = miembro;
    }


    public int getCodigoPrestamo() {
        return codigoPrestamo;
    }

    public void setCodigoPrestamo(int codigoPrestamo) {
        this.codigoPrestamo = codigoPrestamo;
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

    public long calcularDiasMora(LocalDate fechaEntregaReal) {
        return java.time.temporal.ChronoUnit.DAYS.between(getFechaDevolucion(), fechaEntregaReal);
    }
}
