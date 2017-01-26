package Cliente;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	static Scanner sc = new Scanner(System.in);
	static byte m = '1';

	public static void main(String[] args) {
		try {
			System.out.println("Creando socket cliente");
			Socket clientSocket = new Socket();
			System.out.println("Estableciendo la conexión");
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			clientSocket.connect(addr);
			InputStream is = clientSocket.getInputStream();
			OutputStream os = clientSocket.getOutputStream();
			System.out.println("introduce el codigo de mensage: ");
			m = sc.nextByte();

			System.out.println("Enviando mensaje");
			byte num1 = m;
			os.write(num1);
			System.out.println("Mensaje enviado");
			byte[] mensaje = new byte[25];
			is.read(mensaje);
			System.out.println("Cerrando el socket cliente");
			clientSocket.close();
			System.out.println("Terminado");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
