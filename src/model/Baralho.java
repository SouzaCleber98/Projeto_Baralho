package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
    private List<Carta> cartas = new ArrayList<>();

    //Método construtor deve montar o baralho
    public Baralho(){
        for(Naipe naipe : Naipe.values()){
            for(Valor valor : Valor.values()){
                Carta carta = new Carta(valor, naipe);
                cartas.add(carta);
            }
        }
    }

    public void exibirBaralho(){
        for(Carta carta : cartas){
            System.out.println(carta);
        }
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    //misturar - embaralhar
    public void embaralhar(){
        Collections.shuffle(cartas);
    }

}
