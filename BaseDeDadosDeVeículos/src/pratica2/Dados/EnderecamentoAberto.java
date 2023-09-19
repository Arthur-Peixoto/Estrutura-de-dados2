package pratica2.Dados;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

import pratica2.Entity.Veiculo;

public class EnderecamentoAberto {
    Integer m;
    Integer q;
    NoEndAberto tabela[];
    double limite = 0.9;

    public EnderecamentoAberto(int tam) {
        this.m = tam;
        q = 0;
        this.tabela = new NoEndAberto[this.m];
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
    
    public void inserir(int k, Veiculo veiculo) {
        if (getFatorCarga() >= limite) {
            int t = (int) (this.m * 2);
            redimensionar(t);
        }

        	Integer c = hash(k);

        	while(this.tabela[c] != null) {
            if (this.tabela[c].chave == k) {
                // A chave já existe na tabela, você pode tratar isso de acordo com sua lógica.
                break;
            }
            c = (c + 1) % this.m;
        	}
            if(this.tabela[c] == null) {
            	this.tabela[c] = new NoEndAberto(veiculo);
            	tabela[c].chave = k;
            	q++;
            }
    }

    public NoEndAberto buscar(int k) {

        Integer c = this.hash(k);
        NoEndAberto NoEndAberto = this.tabela[c];

        while (NoEndAberto != null) {

            if (NoEndAberto.chave == k)
                return NoEndAberto;

            c = (c + 1) % this.m;
        }
        return null;
    }

    public void imprimir() {
        for (int i = 0; i < this.m; i++) {
            System.out.print(i);

            NoEndAberto noAtual = this.tabela[i];
            while (noAtual != null) {
                System.out.println(" --> " + noAtual.getChave());
            }

            System.out.println(); // Vá para a próxima linha após imprimir os elementos da posição
        }
    }

    public void remover(int k) {
        int c = hash(k);

        while (tabela[c] != null) {
            if (tabela[c].chave == k) {
                tabela[c] = null; // Remove o nó encontrado
                q--;
                return; // Nó encontrado e removido
            }
            c = (c + 1) % m;
        }
    }


    public void redimensionar(int novoTamanho) {
        NoEndAberto[] novaTabela = new NoEndAberto[novoTamanho];

        for (int i = 0; i < this.m; i++) {
            if (this.tabela[i] != null) {
                int chave = this.tabela[i].chave;
                int novaPosicao = chave % novoTamanho;

                while (novaTabela[novaPosicao] != null) {
                    novaPosicao = (novaPosicao + 1) % novoTamanho;
                }

                novaTabela[novaPosicao] = this.tabela[i];
            }
        }

        // Atualiza a tabela atual com a nova tabela redimensionada
        this.tabela = novaTabela;
        this.m = novoTamanho;
    }

	public void imprimirLog() {
    	String path = "data/Log.txt";
		FileWriter writer;
		try {
			writer = new FileWriter(path, false);
			writer.write("\nServidor:	qntVei=" + q + " fatorCarga=" + getFatorCarga());
			writer.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
    }

}

