package servidor;

public class Contacto{
	
	private String idNombre;
	private int iTelf;
	
	 public Contacto() {
		// TODO Auto-generated constructor stub
	  }
	 
	  public Contacto( String id, int Telf) {
		  idNombre = id;
		  iTelf = Telf;
	  }
	 
	  public String getId() {
	    return idNombre;
	  }
	 
	  public void setId(String id) {
		  idNombre = id;
	  }
	 
	  public int getTelf() {
	    return iTelf;
	  }
	 
	  public void setTelf(int Telf) {
		  iTelf = Telf;
	  }
	 
	  public String toString() {
	    return idNombre  + " - " + iTelf;
	  }
	


}
