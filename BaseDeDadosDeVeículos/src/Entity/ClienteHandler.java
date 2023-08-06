package Entity;
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
         // Aqui você pode implementar a lógica para processar as solicitações do cliente
         // por exemplo, ler a mensagem enviada pelo cliente, realizar a busca na base de dados
         // e enviar a resposta de volta ao cliente.

         // Exemplo de leitura de mensagem do cliente
         BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
         String messageFromClient = reader.readLine();
         while(messageFromClient != null)
         System.out.println("Mensagem recebida do cliente: " + messageFromClient);

         // Exemplo de escrita de mensagem para o cliente
         PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
         writer.println("Resposta do servidor para o cliente");

         // Fechar os fluxos e a conexão do cliente
         writer.close();
         reader.close();
         clientSocket.close();
     } catch (IOException e) {
         e.printStackTrace();
     }
 }
}
