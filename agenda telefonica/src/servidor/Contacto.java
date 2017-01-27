package servidor;

public class Contacto{
	
	private static String idNombre;
	private static int iTelf;
	
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
	 
	  public static void setId(String id) {
		  idNombre = id;
	  }
	 
	  public int getTelf() {
	    return iTelf;
	  }
	 
	  public static void setTelf(int Telf) {
		  iTelf = Telf;
	  }
	 
	  public String toString() {
	    return idNombre  + " - " + iTelf;
	  }

}
