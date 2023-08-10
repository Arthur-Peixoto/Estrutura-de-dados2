package Comunicacao;
//Exemplo de um tratador de cliente (ClientHandler) para o servidor
import java.io.*;
import java.net.*;

public class ClienteHandler extends Thread implements Runnable {
 private Socket clientSocket;

 public ClienteHandler(Socket clientSocket) {
     this.clientSocket = clientSocket;
 }

 @Override
 public void run() {
     try {
         BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
         PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

         boolean clienteConnected = true;
         while (clienteConnected) {
             String messageFromClient = reader.readLine();
             if (messageFromClient == null) {
                 // Se a mensagem for nula, significa que o cliente encerrou a conexão
                 clienteConnected = false;
             } else {
                 System.out.println("Mensagem recebida do cliente: " + messageFromClient);

                 // Exemplo de escrita de mensagem para o cliente
                 writer.println("Resposta do servidor para o cliente: " + messageFromClient);
             }
         }

         // Fechar os fluxos e a conexão do cliente
         writer.close();
         reader.close();
         clientSocket.close();
     } catch (IOException e) {
         e.printStackTrace();
     }
 }
}
