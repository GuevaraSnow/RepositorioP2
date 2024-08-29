package co.edu.uniquindio.poo.torneodeportivo;

//Clase Revista, es usada como item a ser gestionado.

public class Revista implements GestionInventario {

    @Override
    public String toString() {
        return "Revista{}";
    }

    @Override
    public Object gestionarItem() {
        System.out.println("Gestionando revista");
        return null;
    }
}
