package servidor;

import java.rmi.RemoteException;

public interface IntAgenda {
	
	
	public void nuevoContactos(Contacto nuevoContacto)throws RemoteException;
	public void borrarContactos(Contacto borrarContacto)throws RemoteException;
	public void editarContactos(Contacto editadoContacto)throws RemoteException;
	public String mostrarContactos(Contacto mostrarContacto)throws RemoteException;
}
