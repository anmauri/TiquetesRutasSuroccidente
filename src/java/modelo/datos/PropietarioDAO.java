package modelo.datos;

import modelo.mundo.Linea;
import modelo.mundo.Marca;
import modelo.mundo.Propietario;
import modelo.mundo.Vehiculo;

/**
 * Clase encargada de almacenar información de los propietarios de las vehículos en la base de datos
 */
public class PropietarioDAO {
	
	/**
	 * Atributo encargado de enlazar la clase FachadaDB
	 */
	private FachadaDB fachada;
	
	/**
	 * Metodo constructor de la clase PropietarioDAO
	 */
	public PropietarioDAO() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Metodo encargado de instanciar un objeto de la clase Propietario
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 * @return  Debe ser un objeto de tipo Propietario
	 */
	public Propietario seleccionar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo){
		
	}
	
	/**
	 * Metodo encargado de actualizar la información de un propietario en la base de datos
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 * @param nPropietario
	 */
	public void actualizar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo, Propietario nPropietario){
		
	}
	
	/**
	 * Metodo encargado de agregar un propietario a la base de datos
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 * @param nPropietario
	 */
	public void agregar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo, Propietario nPropietario){
		
	}
	
	/**
	 * Metodo encargado de eliminar un propietario a la base de datos
	 * @param nMarca
	 * @param nLinea
	 * @param nVehiculo
	 * @param nPropietario
	 */
	public void eliminar(Marca nMarca, Linea nLinea, Vehiculo nVehiculo, Propietario nPropietario){
		
	}
}
