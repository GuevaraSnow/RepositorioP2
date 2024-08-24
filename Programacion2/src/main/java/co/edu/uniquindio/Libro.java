package co.edu.uniquindio.poo.torneodeportivo;

public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private  boolean disponible;

    public Libro(String autor, String isbn, boolean disponible, String titulo) {
        this.autor = autor;
        this.isbn = isbn;
        this.disponible = true;
        this.titulo = titulo;
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

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}