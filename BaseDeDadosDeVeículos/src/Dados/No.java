package Dados;

public class No<T extends Comparable<T>> {
    T chave;
    String valor;
    int alturaNo;
    No<T> esq, dir;

    public No(T chave, String valor) {
        this.chave = chave;
        this.valor = valor;
        this.alturaNo = 1;
        this.esq = null;
        this.dir = null;
    }
}

