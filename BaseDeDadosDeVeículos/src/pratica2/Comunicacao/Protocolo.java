package pratica2.Comunicacao;

import pratica2.Dados.EnderecamentoAberto;
import pratica2.Dados.EncadeamentoExterior;
import pratica2.Dados.No;
import pratica2.Entity.Veiculo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Protocolo {
	
	Server servidor;
	
	public Protocolo(String mensagem, int tam) {
		System.out.println(mensagem);
		servidor = new Server(tam);
	}
	
	public Veiculo buscarVeiculos(Integer renavam) {
		return servidor.consultarVeiculo(renavam);
	}
	
	public boolean cadastrarVeiculo(Veiculo veiculo) {
		return servidor.cadastrarVeiculo(veiculo);
	}
	
	public void removerVeiculo(Veiculo veiculo) {
		int renavam = veiculo.getRenavam();
		servidor.removerVeiculo(renavam);
	}
	
	public void listarVeiculos() {
		servidor.listarVeiculos();
	}
	
	public String encerrarConexao() {
		System.out.println("Protocolo encerrado");
		return servidor.encerrarConexao();
	}

	public int qntVeiculos() {
		// TODO Auto-generated method stub
		return 0;
	}
}
