package co.edu.uniquindio.poo.torneodeportivo;

//Clase Dvd es usada como item a ser gestionado.

public class Dvd implements GestionInventario {

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
