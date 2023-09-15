package trabalho;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	public static void main(String[] args) throws IOException {
		
		// 1 - Definir a porta de conexão
		ServerSocket servidor = new ServerSocket(12345);
		System.out.println("Porta 12345 iniciada com sucesso!");
		
		while(true) {
			// 2 - Aguardar solicitações de conexão de clientes
			Socket cliente = servidor.accept();
			//Mostrar endereço IP do cliente conectado
			System.out.println("Cliente " + cliente.getInetAddress().getHostAddress() + " conectador!");
			
			// 3 - Definir uma thread para cada cliente conectado
			ThreadSockets thread = new ThreadSockets(cliente);
			thread.start();
		}
		
		
		//servidor.close();
		
		
	}

}
