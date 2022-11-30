package socket.cliente.servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {
	
	public static void main(String[] args) throws IOException {
				
		// Definir o serverSocket (Abrir Conexão)
		DatagramSocket socket = new DatagramSocket(5000);
		System.out.println("Servidor em execução");
		
		// Receber mensagem do clinte e imprimir na tela
		byte[] cartaReceber = new byte[100];
		DatagramPacket envelopeReceber 
			= new DatagramPacket(cartaReceber, cartaReceber.length);
		
		
		socket.receive(envelopeReceber);
		String mensagemRecebida = new String(envelopeReceber.getData());
		
		// Obtendo Ip e Porta do cliente pela mensagem recebida (envelopeReceber)
		InetAddress ipCliente = envelopeReceber.getAddress();
		int portaCliente = envelopeReceber.getPort();
		
		System.out.println("Mensagem recebida\nIP: "+ ipCliente + "\nPorta: "+ portaCliente + "\nMensagem : " + mensagemRecebida);
		
		// Enviar mensagem de volta para Cliente
		byte[] cartaEnviar = new byte[100];
		String mensagem = "Dados Salvos com Sucesso.";
		cartaEnviar = mensagem.getBytes();

		
		// Enviando Mensagem de Retorno
		DatagramPacket envelopeEnviar 
			= new DatagramPacket(cartaEnviar, cartaEnviar.length, ipCliente, portaCliente);
		
		socket.send(envelopeEnviar);
		//System.out.println();
		
		// Fechar sockets de comunicação e conexão
		socket.close();
				
	}
	
}
