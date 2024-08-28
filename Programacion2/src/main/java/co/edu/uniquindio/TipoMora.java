package co.edu.uniquindio.poo.torneodeportivo;

public enum TipoMora {
    SIN_MORA(0),
    MORA_LEVE(500),
    MORA_MODERADA(1000),
    MORA_GRAVE(1500);

    private final int valorMulta;

    TipoMora(int valorMulta) {
            this.valorMulta = valorMulta;
    }

    public int getValorMulta() {
            return valorMulta;
    }

}
