package Comunicacao;

import Dados.ArvoreAVL;
import Dados.No;
import Entity.Veiculo;

public class Server {
    private ArvoreAVL<Veiculo> arvoreVeiculos;

    public Server() {
        arvoreVeiculos = new ArvoreAVL<>();
        // Inicializar a árvore com dados iniciais, se necessário
    }

    public Veiculo consultarVeiculo(String renavam) {
    	No<Veiculo> no = arvoreVeiculos.buscar(renavam);
    	Veiculo v = no.getValor();
        return v;
    }

    public boolean cadastrarVeiculo(Veiculo veiculo) {
        arvoreVeiculos.inserir(veiculo.getRenavam(), veiculo);
        return true; // Ou retorne false em caso de falha no cadastro
    }

    public void removerVeiculo(Veiculo veiculo) {
        arvoreVeiculos.remover(veiculo.getRenavam());
    }

    public void listarVeiculos() {
        arvoreVeiculos.percursoEmOrdem();
    }

    public int getQntVeiculos() {
        return arvoreVeiculos.getQuantidade();
    }
    
    public int getRotDir() {
    	return arvoreVeiculos.getRotDir();
    }
    
    public int getRotEsq() {
    	return arvoreVeiculos.getRotEsq();
    }

    public String encerrarConexao() {
        // Implementar lógica para encerrar a conexão, se necessário
        return "Conexão encerrada.";
    }
}
