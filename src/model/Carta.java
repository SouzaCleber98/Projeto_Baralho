package model;

public class Carta {
    private Valor valor;
    private Naipe naipe;

    public Carta(Valor valor, Naipe naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    // Método para obter o valor da carta
    public Valor getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor + " de " + naipe;
    }
}
