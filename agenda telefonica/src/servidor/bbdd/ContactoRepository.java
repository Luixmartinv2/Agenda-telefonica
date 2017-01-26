package servidor.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import servidor.Contacto;

public class ContactoRepository {
	 
	  public static int crear(Contacto nuevocontacto) {
	    int iRet = -1;
	    try {
	      Connection con = BBDD.getInstance().getConnection();
	      String SQL = "INSERT INTO contactos(idNombre, Telefono) Values(?,?)";
	      PreparedStatement pstmt = con.prepareStatement(SQL);
	      pstmt.setString(1, nuevocontacto.getId());
	      pstmt.setInt(2, nuevocontacto.getTelf());
	 
	      iRet = pstmt.executeUpdate();
	 
	      pstmt.close();
	    } catch (SQLException se) {
	      System.out.println(se);
	    }
	 
	    return iRet;
	  }
	  
	  public static int editar(Contacto editadoContacto) {
		    int iRet = -1;
		    try {
		      Connection con = BBDD.getInstance().getConnection();
		      String SQL = "UPDATE contactos SET  Telefono=? WHERE idNombre=?";
		      PreparedStatement pstmt = con.prepareStatement(SQL);
		      pstmt.setString(1, editadoContacto.getId());
		      pstmt.setInt(2, editadoContacto.getTelf());
		 
		      iRet = pstmt.executeUpdate();
		 
		      pstmt.close();
		    } catch (SQLException se) {
		      System.out.println(se);
		    }
		 
		    return iRet;
		  }
	  
	  public static int delete(Contacto borrarContacto) {
		    int iRet = -1;
		    try {
		      Connection con = BBDD.getInstance().getConnection();
		      String SQL = "DELETE FROM contactos WHERE idNombre=?";
		      PreparedStatement pstmt = con.prepareStatement(SQL);
		      pstmt.setString(1, borrarContacto.getId());
		 
		      iRet = pstmt.executeUpdate();
		 
		      pstmt.close();
		    } catch (SQLException se) {
		      System.out.println(se);
		    }
		    return iRet;
		  }
	  
	  public static int show(Contacto mostrarContacto) {
		    int iRet = -1;
		    try {
		      Connection con = BBDD.getInstance().getConnection();
		      String SQL = "SELECT * FROM contactos WHERE idNombre=?";
		      PreparedStatement pstmt = con.prepareStatement(SQL);
		      pstmt.setString(1, mostrarContacto.getId());
		 
		      iRet = pstmt.executeUpdate();
		 
		      pstmt.close();
		    } catch (SQLException se) {
		      System.out.println(se);
		    }
		    return iRet;
		  }

}
