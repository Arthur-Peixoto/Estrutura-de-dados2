package Entity;

// Exemplo da classe Servidor (Server)
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Inicia o servidor socket
            ServerSocket serverSocket = new ServerSocket(4000);
            Socket clientSocket = serverSocket.accept();
            System.out.println("Servidor pronto e aguardando conexões...");

                // Cria uma nova thread para tratar a conexão do cliente
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String messageFromClient = reader.readLine();
            
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
     
            while(messageFromClient != null)
            	writer.println("Servidor:" + messageFromClient);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
