package model.data_structures;

import java.util.Iterator;

public interface IHashTable<T extends Comparable<T>>
{
	/**
	 * M�todo que agrega una dupla (pKey, pValue) a la tabla. Si la llave pKey existe, se reemplaza su valor pValue asociado. 
	 * @param pKey Llave que ser� agregada o buscada. 
	 * @param pValue Valor que ser� agregado o reemplazado. pValue no puede ser null.
	 */
	//TODO OJO AQU� FALTA ARREGLAR EL PVALUE
	public void put(T pKey, T pValue);
	
	/**
	 * M�todo que retorna el valor de la llave determinada.
	 * @param pKey Llave que ser� buscada.
	 * @return El valor asociado a esa llave. Retorna null en caso de que no se encuentre la llave.
	 */
	//TODO OJO AQU� FALTA ARREGLAR EL TIPO T
	public T get(T pKey);
	
	/**
	 * Elimina la dupla de la llave que ingresa por par�metro,
	 * @param pKey Llave que ser� buscada.
	 * @return Valor asociado a la llave. Retorna null en caso de que no se encuentre la llave.
	 */
	//TODO OJO AQU� FALTA ARREGLAR EL TIPO T
	public T delete(T pKey);
	
	/**
	 * Conjunto de llaves T presentes en la tabla.
	 * @return Conjunto de llaves T presentes en la tabla.
	 */
	Iterator<T> keys();
	
	
	
	
}
