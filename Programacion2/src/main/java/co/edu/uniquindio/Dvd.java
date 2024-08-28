package co.edu.uniquindio.poo.torneodeportivo;

public class Dvd implements GestionInventario{

    @Override
    public void gestionarItem() {
        System.out.println("Gestionando dvd");
    }
    @Override
    public String toString() {
        return "dvd";
    }
}
