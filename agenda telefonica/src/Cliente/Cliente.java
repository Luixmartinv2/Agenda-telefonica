package Cliente;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import servidor.Contacto;

public class Cliente {
	static Scanner sc = new Scanner(System.in);
	static int m = '1';

	public static void main(String[] args) {
		try {
			System.out.println("Creando socket cliente");
			Socket clientSocket = new Socket();
			System.out.println("Estableciendo la conexión");
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			clientSocket.connect(addr);
			InputStream is = clientSocket.getInputStream();
			OutputStream os = clientSocket.getOutputStream();
			//  la acción    ///////////////////////////////////
			System.out.println("introduce el codigo de mensage: ");
			System.out.println("1 para borrar, 2 para editar, 3 para mostrar, 4 para agregar contacto");
			m = sc.nextInt();
			//  el contacto  ///////////////////////////////////
			String N = "";
			int T = 0;

			System.out.println("Escribe el Nombre cullo numero quieres editar");
			N = sc.next();
			System.out.println("Escribe el nuevo numero");
			T = sc.nextInt();

			Contacto.setId(N);
			Contacto.setTelf(T);
			/////////////////////////////////////////////////////
			System.out.println("Enviando mensaje");
			int num1 = m;
			os.write(num1);
			
			
			System.out.println("Mensaje enviado");
			String mensaje = "";
			is.read();
			System.out.println(mensaje.trim());
			System.out.println("Cerrando el socket cliente");
			clientSocket.close();
			System.out.println("Terminado");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
