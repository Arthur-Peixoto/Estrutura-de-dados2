package App;

//Exemplo da classe Cliente (Client)
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Cliente {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 4000);
            Scanner scanner = new Scanner(System.in);
            PrintStream saida = new PrintStream(socket.getOutputStream());

            boolean clienteRunning = true;
            while (clienteRunning) {
                System.out.print("Mensagem para o servidor (ou 'sair' para encerrar): ");
                String teclado = scanner.nextLine();
                saida.println(teclado);

                if (teclado.equalsIgnoreCase("sair")) {
                    // Encerra o loop se o usuário digitar 'sair'
                    clienteRunning = false;
                }
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}