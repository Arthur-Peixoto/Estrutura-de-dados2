package pratica1.Dados;

import pratica1.Entity.Veiculo;

public class No<T> implements Comparable<String> {
    String chave;
    T valor;
    
	int alturaNo;
    No<T> esq, dir;

    public No(String chave, T valor) {
        this.chave = chave;
        this.valor = valor;
        this.alturaNo = 1;
        this.esq = null;
        this.dir = null;
    }
    
    public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	public int getAlturaNo() {
		return alturaNo;
	}

	public void setAlturaNo(int alturaNo) {
		this.alturaNo = alturaNo;
	}

	public No<T> getEsq() {
		return esq;
	}

	public void setEsq(No<T> esq) {
		this.esq = esq;
	}

	public No<T> getDir() {
		return dir;
	}

	public void setDir(No<T> dir) {
		this.dir = dir;
	}

	public int compareTo(String o) {
		return this.getChave().compareTo(chave);
	}

}

