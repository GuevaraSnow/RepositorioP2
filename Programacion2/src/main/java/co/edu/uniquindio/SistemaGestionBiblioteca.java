package co.edu.uniquindio.poo.torneodeportivo;

import java.util.ArrayList;
import java.util.Collection;

public class SistemaGestionBiblioteca {
    private Bibliotecario bibliotecario;

    private Collection<Miembro> miembrosBiblioteca = new ArrayList();
    private Collection<Prestamo> prestamoBiblioteca = new ArrayList();

    public SistemaGestionBiblioteca(Bibliotecario bibliotecario,  Collection<Miembro> miembrosBiblioteca, Collection<Prestamo> prestamoBiblioteca) {
        this.bibliotecario = bibliotecario;
        this.miembrosBiblioteca = miembrosBiblioteca;
        this.prestamoBiblioteca = prestamoBiblioteca;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public Collection<Miembro> getMiembrosBiblioteca() {
        return miembrosBiblioteca;
    }

    public void setMiembrosBiblioteca(Collection<Miembro> miembrosBiblioteca) {
        this.miembrosBiblioteca = miembrosBiblioteca;
    }

    public Collection<Prestamo> getPrestamoBiblioteca() {
        return prestamoBiblioteca;
    }

    public void setPrestamoBiblioteca(Collection<Prestamo> prestamoBiblioteca) {
        this.prestamoBiblioteca = prestamoBiblioteca;
    }
}
