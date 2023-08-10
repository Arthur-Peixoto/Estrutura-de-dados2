package Comunicacao;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4000);
            System.out.println("Servidor pronto e aguardando conexões...");

            boolean serverRunning = true;
            while (serverRunning) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado: " + clientSocket.getInetAddress());

                // Cria uma nova thread para tratar a conexão do cliente
                ClienteHandler clienteThread = new ClienteHandler(clientSocket);
                clienteThread.start();
            }

            // Fechar o servidor quando a condição de parada for atendida
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
