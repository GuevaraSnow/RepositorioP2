package co.edu.uniquindio.poo.torneodeportivo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class SistemaGestionBiblioteca {
    private Bibliotecario bibliotecario;

    private Collection<Cliente> miembrosBiblioteca = new ArrayList();
    private Collection<Prestamo> prestamoBiblioteca = new ArrayList();

    public SistemaGestionBiblioteca(Bibliotecario bibliotecario, Collection<Cliente> miembrosBiblioteca, Collection<Prestamo> prestamoBiblioteca) {
        this.bibliotecario = bibliotecario;
        this.miembrosBiblioteca = miembrosBiblioteca;
        this.prestamoBiblioteca = prestamoBiblioteca;
    }


    public void realizarPrestamo(int codigoPrestamo, Cliente miembro, Libro libro, LocalDate fechaDevolucion) {
        Prestamo nuevoPrestamo = new Prestamo(codigoPrestamo, LocalDate.now(), fechaDevolucion, libro, miembro);
        libro.setDisponibilidad(false);
        prestamoBiblioteca.add(nuevoPrestamo);
        miembro.añadirPrestamo(nuevoPrestamo);
    }

    public void devolverPrestamo(int codigoPrestamo, LocalDate fechaEntregaReal) {
        Prestamo prestamoADevolver = prestamoBiblioteca.stream()
                .filter(prestamo -> prestamo.getCodigoPrestamo() == codigoPrestamo)
                .findFirst()
                .orElse(null);

        if (prestamoADevolver != null) {
            prestamoADevolver.getLibro().setDisponibilidad(true);

            long diasMora = prestamoADevolver.calcularDiasMora(fechaEntregaReal);
            TipoMora tipoMora;

            if (diasMora <= 0) {
                tipoMora = TipoMora.SIN_MORA;
            } else if (diasMora <= 3) {
                tipoMora = TipoMora.MORA_LEVE;
            } else if (diasMora <= 7) {
                tipoMora = TipoMora.MORA_MODERADA;
            } else {
                tipoMora = TipoMora.MORA_GRAVE;
            }

            int multa = tipoMora.getValorMulta();
            prestamoADevolver.getMiembro().añadirMulta(multa);

            // Imprimir para depuración
            System.out.println("Días de mora: " + diasMora);
            System.out.println("Multa aplicada: " + multa);
            System.out.println("Saldo de multa del cliente: " + prestamoADevolver.getMiembro().getSaldoMulta());

            prestamoBiblioteca.remove(prestamoADevolver);
            prestamoADevolver.getMiembro().eliminarPrestamo(prestamoADevolver);
        } else {
            System.out.println("El préstamo con el código " + codigoPrestamo + " no existe.");
        }
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public Collection<Cliente> getMiembrosBiblioteca() {
        return miembrosBiblioteca;
    }

    public void setMiembrosBiblioteca(Collection<Cliente> miembrosBiblioteca) {
        this.miembrosBiblioteca = miembrosBiblioteca;
    }

    public Collection<Prestamo> getPrestamoBiblioteca() {
        return prestamoBiblioteca;
    }

    public void setPrestamoBiblioteca(Collection<Prestamo> prestamoBiblioteca) {
        this.prestamoBiblioteca = prestamoBiblioteca;
    }
}
