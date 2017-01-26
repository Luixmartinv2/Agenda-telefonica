package servidor;

public class Contacto{
	
	private String sNombre;
	private int iTelf, idContacto;
	
	 public Contacto() {
		// TODO Auto-generated constructor stub
	  }
	 
	  public Contacto(int id, String Nombre, int Telf) {
		  idContacto = id;
		  sNombre = Nombre;
		  iTelf = Telf;
	  }
	 
	  public int getId() {
	    return idContacto;
	  }
	 
	  public void setId(int id) {
		  idContacto = id;
	  }
	 
	  public String getName() {
	    return sNombre;
	  }
	 
	  public void setName(String Nombre) {
		  sNombre = Nombre;
	  }
	 
	  public int getTelf() {
	    return iTelf;
	  }
	 
	  public void setTelf(int Telf) {
		  iTelf = Telf;
	  }
	 
	  public String toString() {
	    return idContacto + " - " + sNombre + " - " + iTelf;
	  }
	


}
