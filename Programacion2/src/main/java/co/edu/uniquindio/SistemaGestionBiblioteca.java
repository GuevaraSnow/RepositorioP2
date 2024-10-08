package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.Collection;

//Clase que controla y gestiona los prestamos.

public class SistemaGestionBiblioteca {
    private Bibliotecario bibliotecario;

    private Collection<Cliente> miembrosBiblioteca = new ArrayList();
    private Collection<Prestamo> prestamoBiblioteca = new ArrayList();

    public SistemaGestionBiblioteca(Bibliotecario bibliotecario, Collection<Cliente> miembrosBiblioteca, Collection<Prestamo> prestamoBiblioteca) {
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

    @Override
    public String toString() {
        return "SistemaGestionBiblioteca{" +
                "bibliotecario=" + bibliotecario +
                ", miembrosBiblioteca=" + miembrosBiblioteca +
                ", prestamoBiblioteca=" + prestamoBiblioteca +
                '}';
    }
}
