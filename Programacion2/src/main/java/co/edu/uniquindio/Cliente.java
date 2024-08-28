package co.edu.uniquindio.poo.torneodeportivo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String idMiembro;
    private List<Prestamo> prestamosActivos = new ArrayList<>();
    private double saldoMulta = 0.0; // Nuevo atributo para manejar las multas

    public Cliente(String nombre, String idMiembro,double saldoMulta) {
        this.idMiembro = idMiembro;
        this.nombre = nombre;
        this.saldoMulta = saldoMulta;

    }

    public List<Prestamo> getPrestamosActivos() {
        return prestamosActivos;
    }

    public void setPrestamosActivos(List<Prestamo> prestamosActivos) {
        this.prestamosActivos = prestamosActivos;
    }

    public String getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(String idMiembro) {
        this.idMiembro = idMiembro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void añadirPrestamo(Prestamo prestamo) {
        prestamosActivos.add(prestamo);
    }

    public void eliminarPrestamo(Prestamo prestamo) {
        prestamosActivos.remove(prestamo);
    }

    public double getSaldoMulta() {
        return saldoMulta;
    }

    public void añadirMulta(double multa) {
        saldoMulta += multa;
    }
    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", idMiembro='" + idMiembro + '\'' +
                ", prestamosActivos=" + prestamosActivos +
                ", saldoMulta=" + saldoMulta +
                '}';
    }
}