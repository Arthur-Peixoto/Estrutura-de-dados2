package pratica2.Dados;

import pratica2.Entity.Veiculo;

public class NoEndAberto{
 
    public Veiculo veiculo;
    int chave;

    public NoEndAberto( Veiculo veiculo) {
        
        this.veiculo = veiculo;
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


