package co.edu.uniquindio.poo.torneodeportivo;

//Clase Libro que contiene todos los atributos de Libro.

public class Libro implements GestionInventario {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponibilidad;

    public Libro(String autor, String isbn, boolean estado, String titulo) {
        this.autor = autor;
        this.isbn = isbn;
        this.disponibilidad = estado;
        this.titulo = titulo;
    }

    public Libro() {

    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public Object gestionarItem() {
        System.out.println("Gestionando libro");
        return null;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", disponible=" + disponibilidad +
                '}';
    }
}