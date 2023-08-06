package Entity;

//Exemplo da classe Cliente (Client)
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
 public static void main(String[] args) {
     try {
         // Conecta ao servidor
         Socket socket = new Socket("localhost", 4000);
         Scanner scanner = new Scanner(System.in);

         // Envie solicitações para o servidor e receba as respostas aqui
         ClienteHandler clienteThread = new ClienteHandler(socket);
         clienteThread.start();
         PrintStream saida = new PrintStream(socket.getOutputStream());
         String teclado = scanner.nextLine();
         saida.println(teclado);

         socket.close();
     } catch (IOException e) {
         e.printStackTrace();
     }
 }
}