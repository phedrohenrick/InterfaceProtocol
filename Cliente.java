package trabalho;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) throws IOException {
		// 1 - Abrir conexão
			Socket cliente = new Socket("127.0.0.1", 12345);
				
			// 2 - Definir stream de saída de dados do cliente
			DataOutputStream saida = new DataOutputStream(cliente.getOutputStream());
			saida.writeUTF("ola mundo"); // Enviar mensagem em minúsculo para o servidor
				
			// 3 - Definir stream de entrada de dados do cliente
			DataInputStream entrada = new DataInputStream(cliente.getInputStream());
			String novaMensagem = entrada.readUTF(); // Receber mensagem em maiúsculo do servidor
			System.out.println(novaMensagem);
				
			// 4 - Fechar os streans de entrada e saída de dados
			entrada.close();
			saida.close();
			
			// 5 - Fechar socket
			cliente.close();
	}

}
