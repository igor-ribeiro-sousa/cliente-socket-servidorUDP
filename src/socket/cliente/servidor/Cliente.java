package socket.cliente.servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		// (Abrir Conexão).
		DatagramSocket socket = new DatagramSocket();
		
		System.out.println("Conectado");
		System.out.println("Digite uma mensagem: ");
		String mensagem = scanner.nextLine();
		
		/////Mandando uma mensagem para servidor viu///
		
		// Convertendo String em bytes e guardando Ip.
		byte[] cartaEnviar = new byte[100];
		cartaEnviar = mensagem.getBytes();
		InetAddress ip = InetAddress.getByName("127.0.0.1");
		
		// Encluido dentro do pacote (Array de Bytes), o (tamanho do Array), o (ip de destin)o e (porta do servidor).
		DatagramPacket envelopeEnviar 
			= new DatagramPacket(cartaEnviar, cartaEnviar.length, ip, 5000);
		
		// Enviando a mensagem
		socket.send(envelopeEnviar);
		
		///Recebendo uma mensagemn de Resposta do Servidor///
		byte[] cartaReceber = new byte[100];
		DatagramPacket envelopeReceber 
		= new DatagramPacket(cartaReceber, cartaReceber.length);
		
		// Recebendo Mensagem
		socket.receive(envelopeReceber);
		String mensagemRecebida = new String(envelopeReceber.getData());
		System.out.println("Mensagem Recebida: " + mensagemRecebida);
		
		// Fechar o scanner
		scanner.close();	
		// Fechar o socket
		socket.close();
				
	}
	
}

