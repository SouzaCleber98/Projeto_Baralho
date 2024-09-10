import model.Baralho;
import model.Regras;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.Scanner;

public class Jogar {

    public static Baralho iniciar() {
        // Criar e embaralhar o Baralho
        Baralho baralho = new Baralho();
        baralho.embaralhar();
        return baralho;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Baralho baralho = Jogar.iniciar();
        Regras mao1 = new Regras();
        Regras mao2 = new Regras();

        // Jogador 1 pega duas cartas
        mao1.pegarCarta(baralho);
        mao1.pegarCarta(baralho);

        // Computador (Jogador 2) pega duas cartas
        mao2.pegarCarta(baralho);
        mao2.pegarCarta(baralho);

        // Mostrar a mão do Jogador 1
        System.out.println("Sua mão:");
        mao1.mostrarMao();
        System.out.println();

        AtomicInteger valorJogador1 = new AtomicInteger(0);
        AtomicInteger valorJogador2 = new AtomicInteger(0);

        Boolean aux = mao1.contarCartas(mao1.getMao(), valorJogador1);


        while (aux) {
            System.out.print("Você quer continuar pegando cartas? (s/n): ");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("n")) {
                break;
            }

            // Pega mais uma carta
            mao1.pegarCarta(baralho);
            aux = mao1.contarCartas(mao1.getMao(), valorJogador1);
            mao1.mostrarMao();
        }

        // Computador continua pegando cartas até um certo limite
        while (mao2.contarCartas(mao2.getMao(), valorJogador2) && valorJogador2.get() < 17)
        {
            mao2.pegarCarta(baralho);
        }

        System.out.println("Mão do Computador:");

        mao2.mostrarMao();
        System.out.println();

        // Verificação final para determinar o vencedor
        if (valorJogador1.get() > 21) {
            System.out.println("Você ultrapassou 21 e perdeu!");
        } else if (valorJogador2.get() > 21) {
            System.out.println("O Computador ultrapassou 21. Você venceu!");
        } else if (valorJogador1.get() > valorJogador2.get()) {
            System.out.println("Você venceu! Sua soma é maior que a do Computador.");
        } else if (valorJogador1.get() < valorJogador2.get()) {
            System.out.println("O Computador venceu! A soma dele é maior que a sua.");
        } else {
            System.out.println("Empate! A soma das cartas é igual.");
        }

        scanner.close();
    }
}
