package Comunicacao;

import java.io.IOException;
import java.net.Socket;

import Dados.ArvoreAVL;

public class ClienteHandler extends Thread {
    private Socket clientSocket;
    private ArvoreAVL arvoreVeiculos;

    public ClienteHandler(Socket clientSocket, ArvoreAVL arvoreVeiculos) {
        this.clientSocket = clientSocket;
        this.arvoreVeiculos = arvoreVeiculos;
    }

    @Override
    public void run() {
        try {
            Protocolo protocolo = new Protocolo(clientSocket, arvoreVeiculos);
            protocolo.iniciarProtocolo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
