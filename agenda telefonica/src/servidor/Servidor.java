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
        int T = 0;
        
		System.out.println("Escribe el Nombre cullo numero quieres editar");
		N= sc.next();
		System.out.println("Escribe el nuevo numero");
		T= sc.nextInt();
		
		Contacto.setId(N);
		Contacto.setTelf(T);
		
		ContactoRepository.editar(editadoContacto);
		
		
		
	}

	@Override
	public void mostrarContactos(Contacto mostrarContacto) {
		String N ="";
        
        System.out.println("Escribe el Nombre que quieres ver");
		N= sc.next();
        
		ContactoRepository.show(mostrarContacto);
	}

}
