package servidor;

import java.rmi.RemoteException;

public interface IntAgenda {
	
	
	public boolean nuevoContactos(Contacto nuevoContacto)throws RemoteException;
	public boolean borrarContactos(Contacto borrarContacto)throws RemoteException;
	public boolean editarContactos(Contacto editadoContacto)throws RemoteException;
	public String mostrarContactos(Contacto mostrarContacto)throws RemoteException;
}
