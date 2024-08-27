package co.edu.uniquindio.poo.torneodeportivo;

public class Revista implements  GestionInventario{

    @Override
    public String toString() {
        return "Revista{}";
    }

    @Override
    public void gestionarItem() {
        System.out.println("Gestionando revista");
    }
}
