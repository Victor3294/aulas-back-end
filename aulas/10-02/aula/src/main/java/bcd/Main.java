package bcd;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {

//    public static void main(String[] args) throws Exception {
//        // Cria um servidor HTTP, que recebe requisições em localhost no port 8080 (e com backlog 0)
//        HttpServer srv = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);
//
//        // Cria um contexto para processar requisições em URIs iniciadas com "/"
//        // O tratador de requisições é um objeto MeuHandler
//        srv.createContext("/", new MeuHandler());
//
//        // Executa o servidor HTTP
//        srv.start();
//
//    }

    public static void main(String[] args) throws Exception {
        // Cria um servidor HTTP, que recebe requisições em localhost no port 8080 (e com backlog 0)
        HttpServer srv = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);

        srv.createContext("/", new MeuHandler());
        srv.createContext("/portugues", new MeuHandlerPortugues());

        // Executa o servidor HTTP
        srv.start();

    }
}
