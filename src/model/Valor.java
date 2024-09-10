package model;

public enum Valor {
    As(1),
    Dois(2),
    Tres(3),
    Quatro(4),
    Cinco(5),
    Seis(6),
    Sete(7),
    Oito(8),
    Nove(9),
    Dez(10),
    Valete(10),
    Dama(10),
    Reis(10);

    private final int valor;

    // Construtor privado que define o valor associado a cada carta
    Valor(int valor) {
        this.valor = valor;
    }

    // Método para obter o valor da carta
    public int getValor() {
        return valor;
    }
}
