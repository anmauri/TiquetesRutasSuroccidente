package modelo.datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import modelo.mundo.Linea;
import modelo.mundo.Marca;
import modelo.mundo.Vehiculo;


/**
 * Clase encargada de almacenar informacion de las lineas de las marcas en la base de datos
 */
public class LineaDAO {
	
	
	/**
	 * Atributo encargado de enlazar la clase FachadaDB
	 */
	private FachadaDB fachadaDB;
	
	
	/**
	 * Metodo constructor de la clase LineaDAO
	 */
	public LineaDAO(){
		
	}
	
	
	/**
	 * Lista almacenadora de objetos de tipo Marca
	 * @param nMarca
	 * @return
	 */
	public ArrayList<Linea> seleccionar(Marca nMarca)throws ClassNotFoundException, SQLException{
              ArrayList<Linea> retorno= new ArrayList<Linea>();
		String seleccionar="select  consumo.fecha, consumo.habitacion_numero, consumo.producto, consumo.valor from consumo, habitacion where habitacion.numero="+habitacionSeleccionar.darNumero()+" and consumo.habitacion_numero= habitacion.numero order by consumo.fecha desc";
                Connection conexion = fachadaDB.conectarDB();
		if(conexion!=null)
		{
			Statement instruccion = (Statement)conexion.createStatement();
			ResultSet resultado=(ResultSet)instruccion.executeQuery(seleccionar);
			while(resultado.next())
			{
				String nombreLinea =resultado.getString("nombre");
				SimpleDateFormat formato= new SimpleDateFormat(Tiquete.FORMATO);
				Linea linea= new Linea(nombreLinea);
				retorno.add(linea);
			}
			conexion.close();
		}
		return retorno;
	
	}
	
	
	/**
	 * Metodo encargado de actualizar la información de una línea en la base de datos
	 * @param nMarca
	 * @param nLinea
         * @param vNombre 
	 */
	public void actualizar(Marca nMarca, Linea nLinea, String vNombre)throws ClassNotFoundException, SQLException{
            String actualizar= "call actualizar_linea("+nMarca.getNombre()+", " + nLinea.getNombre()+ ", " +vNombre")";
		Connection conexion= fachadaDB.conectarDB();
		if(conexion!=null)
		{
			Statement instruccion= (Statement) conexion.createStatement();
			instruccion.executeUpdate(actualizar);
			fachadaDB.desconectarDB(conexion);
		}
	
	}
	
	
	/**
	 * Metodo encargado de agregar una línea en la base de datos
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 */
	public void agregar(Marca nMarca, Linea nLinea) throws ClassNotFoundException, SQLException{
            Connection conexion= fachadaDB.conectarDB();
            String agregar= "call agregar_linea (" + nMarca.getNombre() + "', " + nLinea.getNombre() + ")";
            if(conexion!=null)
            {
                    Statement instruccion=(Statement)conexion.createStatement();
                    instruccion.execute(agregar);
                    conexion.close();
            }	
		
	}
	
	
	/**
	 * Metodo encargado de eliminar una línea en la base de datos
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 */
	public void eliminar(Marca nMarca, Linea nLinea) throws ClassNotFoundException, SQLException{
		Connection conexion= fachadaDB.conectarDB();
            String eliminar= "call eliminar_linea (" + nMarca.getNombre() + "," + nLinea.getNombre()+")";
            if(conexion!=null)
            {
                    Statement instruccion=(Statement)conexion.createStatement();
                    instruccion.execute(eliminar);
                    conexion.close();
            }
	}
}