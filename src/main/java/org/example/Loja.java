package org.example;

import java.util.Observable;

public class Loja extends Observable {

    private String nome;
    private String endereco;

    public Loja(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public void lancarNovoProduto() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Loja{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
