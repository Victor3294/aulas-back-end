package bcd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    Socket clientSocket;
    PrintWriter out;
    BufferedReader in;

    public Cliente(String ip, int port) throws IOException {
        // cria um socket para se conectar com o ip e port indicados
        clientSocket = new Socket(ip, port);

        // cria um PrintWriter para facilitar o envio de mensagens
        out = new PrintWriter(clientSocket.getOutputStream(), true);

        // cria um BufferedReader para facilitar a recepção de dados
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    // envia uma mensagem, e espera uma resposta, a qual é retornada como resultado
    public String envia(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }
}