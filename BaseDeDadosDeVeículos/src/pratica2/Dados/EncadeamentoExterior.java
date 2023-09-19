package pratica2.Dados;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

import pratica2.Entity.Veiculo;

public class EncadeamentoExterior {
	Integer m;
	Integer q;
	No tabela[];
	double limite = 2.0;
	
	public EncadeamentoExterior(int tam) {
		this.m = tam;
		q = 0;
		this.tabela = new No[this.m];
	}
	
	public int hash(int k) {
		return k % m;
	}
	
	public double getFatorCarga() {
        double fatorCarga = (double) q / m;

        DecimalFormat df = new DecimalFormat("#.############");
        String formatted = df.format(fatorCarga).replace(',', '.'); // Substitui a vírgula pela ponto
        return Double.parseDouble(formatted);
    }
	
	/*
	 * Inserir no come�o da lista
	 */
	public void inserir(int k, Veiculo veiculo) {
		
		if(getFatorCarga() >= limite) {
    		int t =(int)(this.m*2.0);
    		redimensionar(t);
    	}
		
		Integer c = this.hash(k);
		No no = this.tabela[c];
		
		while(no != null) {
			
			if(no.chave == k) {
				break;
			}
			
			no = no.proximo;
			
		}
		
		if(no == null) {
			
			no = new No(k, tabela[c],veiculo);
			no.proximo = this.tabela[c];
			this.tabela[c] = no;
			q++;
		}

	}
	
	public No buscar(int k) {
		
		Integer c = this.hash(k);
		No no = this.tabela[c];
		
		while(no != null) {
			
			if(no.chave == k)
				return no;
			
			no = no.proximo;
		}
		return null;
	}
	
	public void imprimir() {
		
		No no;
		
		for (int i = 0; i < this.m; i++) {
			
			no = this.tabela[i];
			System.out.print(i);
			
			while(no != null) {
				System.out.print(" --> " + no.chave);
				no = no.proximo;
			}
			
			System.out.println();
		}

	}
	
	// Inserir no final da lista
    public void inserirNoFinal(int k, Veiculo veiculo) {
    	
    	if(getFatorCarga() >= limite) {
    		int t =(int)(this.m*2.0);
    		redimensionar(t);
    	}
    	
        Integer c = this.hash(k);
        No novoNo = new No(k, null, veiculo);
        No anterior = null;

        if (this.tabela[c] == null) {
            this.tabela[c] = novoNo;
            q++;
        } else {
        	while(this.tabela[c] != null) {
        		if(this.tabela[c].chave == k) {
        			break;
        		}
        		anterior = this.tabela[c];
        		this.tabela[c] = this.tabela[c].proximo;
        	}
        	if(this.tabela[c] == null) {
        		anterior.proximo = novoNo;
        		q++;
        	}
        }
    }

    public void remover(int k) {
        Integer c = this.hash(k);
        No no = this.tabela[c];
        No anterior = null;

        while (no != null) {
            if (no.chave == k) {
                if (anterior == null) {
                    // O nó a ser removido é o primeiro da lista
                    this.tabela[c] = no.proximo;
                } else {
                    anterior.proximo = no.proximo;
                }
                return; // Nó encontrado e removido
            }
            anterior = no;
            no = no.proximo;
        }
    }

    // Método para redimensionar a tabela
    public void redimensionar(int novoTamanho) {
        EncadeamentoExterior novaTabela = new EncadeamentoExterior(novoTamanho);

        // Reinsere todos os elementos na nova tabela
        for (int i = 0; i < this.m; i++) {
            No no = this.tabela[i];
            while (no != null) {
                novaTabela.inserir(no.chave, no.veiculo);
                no = no.proximo;
            }
        }

        // Atualiza a tabela atual com a nova tabela redimensionada
        this.tabela = novaTabela.tabela;
        this.m = novoTamanho;
    }
    
    public void imprimirLog() {
    	String path = "src/log.txt";
		FileWriter writer;
		try {
			writer = new FileWriter(path, false);
			writer.write("\nServidor:	qntVei=" + q + "	fatorCarga=" + getFatorCarga());
			writer.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
    }
	
}
