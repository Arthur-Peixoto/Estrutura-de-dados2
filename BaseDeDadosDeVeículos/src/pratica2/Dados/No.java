package pratica2.Dados;

import pratica2.Entity.Veiculo;

public class No{
    Integer chave;
    No proximo;
    public Veiculo veiculo;

    public No(Integer chave, No proximo, Veiculo veiculo) {
        this.chave = chave;
        this.proximo = proximo;
        this.veiculo = veiculo;
    }
    
    public No getProximo() {
		return proximo;
	}

	public void setProximo(No proximo) {
		this.proximo = proximo;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Integer getChave() {
		return chave;
	}

	public void setChave(Integer chave) {
		this.chave = chave;
	}

	public int compareTo(String o) {
		return this.getChave().compareTo(chave);
	}

}

