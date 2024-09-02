package co.edu.uniquindio;
//Enum para asociar el valor de las multas según el tiempo.

public enum Multa {
    BAJA(0.50),
    MEDIA(1.00),
    ALTA(2.00);

    private final double valor;

    Multa(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public static Multa obtenerMulta(double diasRetraso) {
        if (diasRetraso <= 5) {
            return BAJA;
        } else if (diasRetraso <= 10) {
            return MEDIA;
        } else {
            return ALTA;
        }
    }
}
