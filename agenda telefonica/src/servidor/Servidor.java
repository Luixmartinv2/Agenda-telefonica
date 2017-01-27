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
			String mensaje = "";
			is.read();
			System.out.println(mensaje.trim());
			
			if(mensaje=="1"){
				
				nuevoContactos(Contacto.getSting());
			} else if(mensaje=="2"){
				borrarContactos();
			}else if(mensaje=="3"){
				editarContactos();
			}else if(mensaje=="4"){
				mostrarContactos();
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
	public void borrarContactos(Contacto borrarContacto) {

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
