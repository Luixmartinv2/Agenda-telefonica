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
			byte[] mensaje1 = new byte[20];
			String mensaje2 = "";
			int ac = 0;
			try {
				is.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			is.read(mensaje1);
			System.out.println(mensaje1.length);
			mensaje2 = mensaje1.toString();
			if (mensaje2.trim() == "1") {

				ac = 1;
			} else if (mensaje2.trim() == "2") {
				ac = 2;
			} else if (mensaje2.trim() == "3") {
				ac = 3;
			} else if (mensaje2.trim() == "4") {
				ac = 4;
			}
			
			//////aqui se dice que acción realizar
			if (ac == 1) {
				//borrarContactos(contacto);
			} else if (ac == 2) {
				//editarContactos(contacto);
			} else if (ac == 3) {
				//mostrarContactos(contacto);
			} else if (ac == 4) {
				//nuevoContactos(contacto);
			}

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

		ContactoRepository.crear(nuevoContacto);

	}

	@Override
	public  void borrarContactos(Contacto borrarContacto) {

		ContactoRepository.delete(borrarContacto);

	}

	@Override
	public void editarContactos(Contacto editadoContacto) {

		ContactoRepository.editar(editadoContacto);

	}

	@Override
	public void mostrarContactos(Contacto mostrarContacto) {

		ContactoRepository.show(mostrarContacto);
	}

}
