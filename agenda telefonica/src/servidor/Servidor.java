package servidor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import servidor.bbdd.ContactoRepository;

public class Servidor implements IntAgenda {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		try {

			System.out.println("Creando el socket servidor");
			ServerSocket serverSocket = new ServerSocket();
			System.out.println("Realizando el bind");
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			serverSocket.bind(addr);
			System.out.println("Aceptando conexiones");
			Socket newSocket = serverSocket.accept();
			System.out.println("Conexión recibida");
			InputStream is = newSocket.getInputStream();
			OutputStream os = newSocket.getOutputStream();
			System.out.println("Cerrando el nuevo socket");
			newSocket.close();
			System.out.println("Cerrando el socket servidor");
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void nuevoContactos(Contacto nuevoContacto) {
		String N = "";
		int T = 0;

		System.out.println("Escribe el Nombre");
		N = sc.next();
		System.out.println("Escribe el numero");
		T = sc.nextInt();

		Contacto.setId(N);
		Contacto.setTelf(T);

		ContactoRepository.crear(nuevoContacto);

	}

	@Override
	public void borrarContactos(Contacto borrarContacto) {
		String N = "";

		System.out.println("Escribe el Nombre que quieres borrar");
		N = sc.next();

		Contacto.setId(N);

		ContactoRepository.delete(borrarContacto);

	}

	@Override
	public void editarContactos(Contacto editadoContacto) {
		String N = "";
		int T = 0;

		System.out.println("Escribe el Nombre cullo numero quieres editar");
		N = sc.next();
		System.out.println("Escribe el nuevo numero");
		T = sc.nextInt();

		Contacto.setId(N);
		Contacto.setTelf(T);

		ContactoRepository.editar(editadoContacto);

	}

	@Override
	public void mostrarContactos(Contacto mostrarContacto) {
		String N = "";

		System.out.println("Escribe el Nombre que quieres ver");
		N = sc.next();

		ContactoRepository.show(mostrarContacto);
	}

}
