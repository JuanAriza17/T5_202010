package model.data_structures;

import java.util.Iterator;

public class HashSeparateChaining<T extends Comparable<T>, V extends Comparable<V>> implements IHashTable<T,V>{

	/**
	 * N�mero de pares en la tabla.
	 */
	private int pares;

	/**
	 * Tama�o de la tabla.
	 */
	private int tamano;
	
	/**
	 * Arreglo de las llaves.
	 */
	private T[] keys;
	
	/**
	 * Arreglo de los valores.
	 */
	private V[] valores;
	
	/**
	 * M�todo que agrega una dupla (pKey, pValue) a la tabla. Si la llave pKey existe, se reemplaza su valor pValue asociado. 
	 * @param pKey Llave que ser� agregada o buscada. 
	 * @param pValue Valor que ser� agregado o reemplazado. pValue no puede ser null.
	 */
	@Override
	public void put(T pKey, V pValue) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * M�todo que retorna el valor de la llave determinada.
	 * @param pKey Llave que ser� buscada.
	 * @return El valor asociado a esa llave. Retorna null en caso de que no se encuentre la llave.
	 */
	@Override
	public V get(T pKey) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Elimina la dupla de la llave que ingresa por par�metro,
	 * @param pKey Llave que ser� buscada.
	 * @return Valor asociado a la llave. Retorna null en caso de que no se encuentre la llave.
	 */
	@Override
	public V delete(T pKey) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Conjunto de llaves T presentes en la tabla.
	 * @return Conjunto de llaves T presentes en la tabla.
	 */
	@Override
	public Iterator<T> keys() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Convierte el hashCode() en un �ndice.
	 * @param pKey. Llave que ingresa por par�metro.
	 * @return �ndice que representa el hashCode.
	 */
	public int hash(T pKey)
	{ 
		return (pKey.hashCode() & 0x7fffffff) % tamano;
	} 


}