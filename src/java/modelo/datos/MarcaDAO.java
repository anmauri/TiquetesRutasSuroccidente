package modelo.datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.ir.Statement;
import modelo.mundo.Linea;
import modelo.mundo.Marca;


/**
 * Clase encargada del manejo de las marcas en la base de datos
 * @author MiPc
 *
 */
public class MarcaDAO {

	
	/**
	 * Atributo para la administración de la base de datos
	 */
	private FachadaDB fachada;
	
	
	/**
	 * Metodo constructor de la calse MarcaDAO
	 * <b>post:</b> Se ha inicializada el atributo de la clase fachada, se ha creado una nueva instancia de la clase 
	 */
	public MarcaDAO(){
		fachada= new FachadaDB();
	}
	
	
	/**
	 * Metodo que permite seleccionar las marcas almacenadas en la base de datos<br>
	 * <b>pre:</b> Ha inicializado el atributo fachada
	 * <b>post:</b> Se ha seleccionado y retornado las marcas almacenadas en la base de datos
	 * @return La lista con las marcas seleccionadas
	 */
	public ArrayList<Marca> seleccionar() throws ClassNotFoundException, SQLException{
                ArrayList<Marca> Marcas;
                Marcas = new ArrayList();
		String seleccionar="select marca.nombre from marca";
		Connection conexion;
            try {
                conexion = fachada.conectarDB();
                if(conexion!=null)
		{
			java.sql.Statement instruccion;
                    try {
                        instruccion = (java.sql.Statement) conexion.createStatement();
                        ResultSet resultado = null;
			resultado = (ResultSet) instruccion.executeQuery(seleccionar);
			while (resultado.next()) 
			{
				
				String nNombre = resultado.getString("linea.nombre");
                                Linea linea = new Linea(nNombre);
                               Lineas.add(linea);

			}
			fachada.desconectarDB(conexion);
                    } catch (SQLException ex) {
                        Logger.getLogger(LineaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
			
		}
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LineaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(LineaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
		return Marcas;
	}
	
	
	/**
	 * Metodo que actualizar una marca almacenada en la base de datos<br>
	 * <b>pre:</b> El atributo fachadaDB ha sido inicializado<br>
	 * <b>post:</b> Se ha modificado la marca ingresada como parametro
	 * @param nMarca La marca actualizar en la base de datos nMarca!=null
         * @param vNombre el viejo nombre de la marca
	 */
	public void actualizar(Marca nMarca, String vNombre)throws SQLException, ClassNotFoundException{
             String actualizar= "update linea "
                                    + "set marca.nombre = " + nMarca.getNombre()   
                                    + " where " + nMarca.getNombre()+" = vNombre";
                                   
		Connection conexion;
            try {
                conexion = fachada.conectarDB();
                if(conexion!=null)
		{
			java.sql.Statement instruccion;
                    try {
                        instruccion = (java.sql.Statement) conexion.createStatement();
                        instruccion.executeUpdate(actualizar);
			fachada.desconectarDB(conexion);
                    } catch (SQLException ex) {
                        Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
			
		}
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
	
	
	/**
	 * Metodo que permite agregar una marca a la base de datos<br>
	 * <b>pre:</b> El atributo fachadaDB ha sido inicializado<br>
	 * <b>post:</b> Agregado una marca a la base de datos 
	 * @param nMarca La marca a agregar a la base de datos
	 */
	public void agregar(Marca nMarca) throws ClassNotFoundException, SQLException{
            
            String agregar= "insert into marca.nombre ) "
                                + "values ( "+ nMarca.getNombre()+");";
		Connection conexion;
            try {
                conexion = fachada.conectarDB();
                if(conexion!=null)
		{
			java.sql.Statement instruccion;
                    try {
                        instruccion = (java.sql.Statement) conexion.createStatement();
                        instruccion.executeUpdate(agregar);
			fachada.desconectarDB(conexion);
                    } catch (SQLException ex) {
                        Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
			
		}
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
		
	}
	
	
	/**
	 * Metodo que permite eliminar una marca de la base de datos<br>
	 * <b>pre:</b> El atributo fachadaDB ha sido inicializado<br>
	 * <b>post:</b> Se ha eliminado la marca pasada como parametro de la base de datos
	 * @param nMarca La marca a eliminar de la base de datos nMarca !=null
	 */
	public void eliminar(Marca nMarca) throws SQLException{
           String eliminar= "delete from marca "
                                + "where marca.nombre = " + nMarca.getNombre() + ";";
		Connection conexion;
            try {
                conexion = fachada.conectarDB();
                if(conexion!=null)
		{
			java.sql.Statement instruccion;
                    try {
                        instruccion = (java.sql.Statement) conexion.createStatement();
                        instruccion.executeUpdate(eliminar);
			fachada.desconectarDB(conexion);
                    } catch (SQLException ex) {
                        Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
			
		}
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
		
	}
}