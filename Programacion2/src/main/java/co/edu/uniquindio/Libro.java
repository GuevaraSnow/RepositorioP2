package co.edu.uniquindio.poo.torneodeportivo;

public class Libro implements GestionInventario {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean estado;

    public Libro(String autor, String isbn, boolean estado, String titulo) {
        this.autor = autor;
        this.isbn = isbn;
        this.estado = estado;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public void gestionarItem() {
        System.out.println("Gestionando libro");
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", estado=" + estado +
                '}';
    }
}