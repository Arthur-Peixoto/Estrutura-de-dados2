package pratica2.Comunicacao;

import pratica2.Dados.EncadeamentoExterior;
import pratica2.Dados.EncadeamentoExterior;
import pratica2.Dados.No;
import pratica2.Entity.Veiculo;

public class Server {
    private EncadeamentoExterior tabelaHash;

    public Server(int tam) {
        tabelaHash = new EncadeamentoExterior(tam); // Inicialize a tabela de hash com um tamanho adequado.
    }

    public Veiculo consultarVeiculo(int chave) {
        No No = tabelaHash.buscar(chave);
        if (No != null) {
            return No.veiculo;
        } else {
            return null; // Retorna null se o veículo não for encontrado.
        }
    }

    public boolean cadastrarVeiculo(Veiculo veiculo) {
        int chave = veiculo.getRenavam();
        tabelaHash.inserir(chave, veiculo);
        atualizarLog();
        return true; 
    }

    public void removerVeiculo(int chave) {
        tabelaHash.remover(chave);
        atualizarLog();
    }

    public void listarVeiculos() {
        tabelaHash.imprimir();
    }

    public void redimensionarTabela(int NovoTamanho) {
        tabelaHash.redimensionar(NovoTamanho);
    }

    private void atualizarLog() {
    	tabelaHash.imprimirLog();
	}
    
    public String encerrarConexao() {
        // Implementar lógica para encerrar a conexão, se necessário
        return "Conexão encerrada.";
    }
}