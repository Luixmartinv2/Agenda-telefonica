package servidor;

import java.util.Scanner;
import servidor.bbdd.ContactoRepository;


public class Servidor  implements IntAgenda {
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void nuevoContactos(Contacto nuevoContacto) {
		String N ="";
		int T = 0;
		
		System.out.println("Escribe el Nombre");
		N= sc.next();
		System.out.println("Escribe el numero");
		T= sc.nextInt();
		
		Contacto.setId(N);
		Contacto.setTelf(T);
		
		ContactoRepository.crear(nuevoContacto);

	}

	@Override
	public void borrarContactos(Contacto borrarContacto) {
		String N ="";
		
		System.out.println("Escribe el Nombre que quieres borrar");
		N= sc.next();
		
		Contacto.setId(N);
		
		ContactoRepository.delete(borrarContacto);
		

	}

	@Override
	public void editarContactos(Contacto editadoContacto) {
        String N ="";
		
		System.out.println("Escribe el Nombre que quieres editar");
		N= sc.next();
		
		Contacto.setId(N);
		
		
		
	}

	@Override
	public String mostrarContactos(Contacto mostrarContacto) {
		
		return null;
	}

}
