package Comunicacao;

import Dados.ArvoreAVL;
import Dados.No;
import Entity.Veiculo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Protocolo {
	
	Server servidor = new Server();
	
	public Protocolo(String mensagem) {
		System.out.println(mensagem);
	}
	
	public Veiculo buscarVeiculos(String renavam) {
		return servidor.consultarVeiculo(renavam);
	}
	
	public boolean cadastrarVeiculo(Veiculo veiculo) {
		return servidor.cadastrarVeiculo(veiculo);
	}
	
	public void removerVeiculo(Veiculo veiculo) {
		servidor.removerVeiculo(veiculo);
	}
	
	public void listarVeiculos() {
		servidor.listarVeiculos();
	}
	
	public int qntVeiculos() {
		return servidor.getQntVeiculos();
	}
	
	public String encerrarConexao() {
		System.out.println("Protocolo encerrado");
		return servidor.encerrarConexao();
	}
}
