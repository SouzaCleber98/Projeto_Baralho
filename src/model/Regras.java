package model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Regras {

    private List<Carta> mao = new ArrayList<>();


    // Construtor

    public Regras() {
        this.mao = new ArrayList<>();
    }

    // Método para pegar uma carta do baralho
    public void pegarCarta(Baralho baralho) {

        // Verifica se o baralho não está vazio
        if (!baralho.getCartas().isEmpty()) {

            // Pega a primeira carta do baralho
            Carta aux = baralho.getCartas().get(0);

            // Adiciona a carta à mão do jogador
            mao.add(aux);
            // Remove a carta do baralho
            baralho.getCartas().remove(0);
        } else {
            System.out.println("O baralho está vazio!"); // Caso o baralho esteja vazio
        }
    }

    public void mostrarMao() {

        for (Carta carta : mao) {
            System.out.println(carta);
        }
    }

    public Boolean contarCartas(List<Carta> mao,AtomicInteger valor) {
        int somaCartas = 0;

        // Itera sobre cada carta na mão
        for (Carta carta : mao) {
            somaCartas += carta.getValor().getValor();
        }
        valor.set(somaCartas);
        // Se a soma for menor ou igual a 21, retorna true (pode continuar)
        return somaCartas <= 21;
    }

    public List<Carta> getMao() {
        return mao;
    }
}




