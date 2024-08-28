package co.edu.uniquindio.poo.torneodeportivo;

public class Dvd implements GestionInventario{

    @Override
    public Object gestionarItem() {
        System.out.println("Gestionando dvd");
        return null;
    }
    @Override
    public String toString() {
        return "dvd";
    }
}
