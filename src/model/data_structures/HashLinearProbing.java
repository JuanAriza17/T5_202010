package model.data_structures;

import java.util.Iterator;

public class HashLinearProbing<T extends Comparable<T>, V extends Comparable<V>> implements IHashTable<T,V>
{
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
	private V[] values;

	/**
	 * M�todo constructor.
	 * Se inicializan los arreglos de llaves y valores.
	 */
	public HashLinearProbing(int pTamano) 
	{
		tamano=pTamano;
		keys= (T[]) new Object[tamano];
		values= (V[]) new Object[tamano];
	}

	/**
	 * M�todo que retorna el n�mero de pares de la tabla.
	 * @return N�mero de pares de la tabla.
	 */
	public int darNumPares()
	{
		return pares;
	}

	/**
	 * M�todo que retorna el tama�o de la tabla.
	 * @return Tama�o de la tabla.
	 */
	public int darTamano()
	{
		return tamano;
	}

	/**
	 * M�todo que retorna el arreglo de llaves.
	 * @return Arreglo de llaves.
	 */
	public T[] darKeys()
	{
		return keys;
	}

	/**
	 * M�todo que retorna el arreglo de valores.
	 * @return Arreglo de valores.
	 */
	public V[] darValues()
	{
		return values;
	}

	/**
	 * M�todo que agrega una dupla (pKey, pValue) a la tabla. Si la llave pKey existe, se reemplaza su valor pValue asociado. 
	 * @param pKey Llave que ser� agregada o buscada. 
	 * @param pValue Valor que ser� agregado o reemplazado. pValue no puede ser null.
	 */
	@Override
	public void put(T pKey, V pValue) {
		if(pares>=tamano/2)
		{
			resize(2*tamano);
		}
		int i;
		for(i=hash(pKey); keys[i]!=null; i=(i+1)%tamano)
		{
			if(keys[i].equals(pKey))
			{
				values[i]=pValue;
				return;
			}
		}
		keys[i]=pKey;
		values[i]=pValue;
		++pares;

	}

	/**
	 * M�todo que retorna el valor de la llave determinada.
	 * @param pKey Llave que ser� buscada.
	 * @return El valor asociado a esa llave. Retorna null en caso de que no se encuentre la llave.
	 */
	@Override
	public V get(T pKey) {
		for (int i= hash(pKey); keys[i]!=null; i=(i+1)%tamano)
		{
			if (keys[i].equals(pKey))
			{
				return values[i];
			}
		}
		return null;
	}

	/**
	 * Elimina la dupla de la llave que ingresa por par�metro,
	 * @param pKey Llave que ser� buscada.
	 * @return Valor asociado a la llave. Retorna null en caso de que no se encuentre la llave.
	 */
	@Override
	public V delete(T pKey) {
		if(!contains(pKey))
		{
			return null;
		}
		int i=hash(pKey);
		while(!pKey.equals(keys[i]))
		{
			i=(i+1)%tamano;
		}
		V retorno=values[i];
		keys[i]=null;
		values[i]=null;
		i=(i+1)%tamano;
		while(keys[i]!=null)
		{
			T keyToRedo=keys[i];
			V valueToRedo=values[i];
			--pares;
			put(keyToRedo,valueToRedo);
			i=(i+1)%tamano;
		}
		--pares;
		if(pares>0 && pares==tamano/8)
		{
			resize(tamano/2);
		}
		return retorno;
		
		
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

	/**
	 * M�todo que cambia el tama�o de la tabla por el valor que llega por par�metro.
	 * @param pTamano Tama�o nuevo de la tabla.
	 */
	public void resize(int pTamano)
	{
		HashLinearProbing<T, V> t;
		t = new HashLinearProbing<T, V>(pTamano);
		for (int i = 0; i < tamano; i++)
		{
			if (keys[i] != null)
			{
				t.put(keys[i], values[i]);
			}
		}

		keys = t.darKeys();
		values = t.darValues();
		tamano = t.darTamano();
	}

	/**
	 * M�todo que indica si una llave se encuentra en el arreglo de llaves.
	 * @param key Llave que es buscada
	 * @return True si se encuentra. False en caso contrario.
	 */
	public boolean contains(T key)
	{ 
		return rank(key) != -1; 
	}

	/**
	 * M�todo que busca por medio de b�squeda binaria la llave que ingresa por par�metro en el arreglo de llaves.
	 * @param key
	 * @return
	 */
	private int rank(T pKey)
	{ // Binary search.
		int lo = 0;
		int hi =keys.length - 1;
		while (lo <= hi)
		{ // Key is in a[lo..hi] or not present.
			int mid = lo + (hi - lo) / 2;
			if (hash(pKey) < hash(keys[mid])) 
			{
				hi = mid - 1;
			}
			else if (hash(pKey) > hash(keys[mid])) 
			{
				lo = mid + 1;
			}
			else
			{
				return mid;
			}
		}
		return -1;
	} 

}
