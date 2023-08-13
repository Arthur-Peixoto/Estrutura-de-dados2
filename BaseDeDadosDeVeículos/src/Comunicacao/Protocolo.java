package Comunicacao;

import Dados.ArvoreAVL;
import Entity.Veiculo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Protocolo {
    private ArvoreAVL<Veiculo> arvoreVeiculos;
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private Scanner scanner;

    public Protocolo(Socket socket, ArvoreAVL<Veiculo> arvoreVeiculos) throws IOException {
        this.socket = socket;
        this.arvoreVeiculos = arvoreVeiculos;
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(socket.getOutputStream(), true);
        scanner = new Scanner(System.in);
    }

    public void iniciarProtocolo() throws IOException {
        String mensagem;
        while ((mensagem = reader.readLine()) != null) {
            exibirOpcoes();
            int opcao = scanner.nextInt();
            String resposta = processarMensagem(opcao, mensagem);
            writer.println(resposta);
        }
        fecharConexao();
    }

    private void exibirOpcoes() {
        System.out.println("Opções:");
        System.out.println("1. Consultar");
        System.out.println("2. Cadastrar");
        System.out.println("3. Listar");
        System.out.println("4. Alterar");
        System.out.println("5. Remover");
        System.out.println("6. Quantidade");
        System.out.print("Escolha uma opção: ");
    }

    private String processarMensagem(int opcao, String argumento) {
        switch (opcao) {
            case 1:
                // Implemente a chamada do método de consulta da árvore AVL
                break;
            case 2:
                // Implemente a chamada do método de cadastro da árvore AVL
                break;
            case 3:
                // Implemente a chamada do método de listagem da árvore AVL
                break;
            case 4:
                // Implemente a chamada do método de alteração da árvore AVL
                break;
            case 5:
                // Implemente a chamada do método de remoção da árvore AVL
                break;
            case 6:
                // Implemente a chamada do método de obtenção da quantidade de veículos na árvore AVL
                break;
            default:
                return "Opção inválida";
        }
        return "Operação realizada com sucesso";
    }

    private void fecharConexao() {
        try {
            reader.close();
            writer.close();
            socket.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
