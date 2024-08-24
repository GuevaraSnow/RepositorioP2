package co.edu.uniquindio.poo.torneodeportivo;

import java.util.List;

public class Miembro {
    private String nombre;
    private String idMiembro;
    private List<Prestamo> prestamosActivos;

    public Miembro(String nombre, String idMiembro, List<Prestamo> prestamosActivos) {
        this.idMiembro = idMiembro;
        this.nombre = nombre;
        this.prestamosActivos = prestamosActivos;
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

    public  void añadirPrestamo (Prestamo prestamo){
        prestamosActivos.add(prestamo);
    }
    public  void eliminarPrestamo (Prestamo prestamo){
        prestamosActivos.remove(prestamo);
    }
}