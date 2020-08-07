package Algorithem;
/**
 * <p>Title: HashMap.java</p>
 *
 * <p>Description: Represents a key and a value pair. Hash Table, with collision resolution by Open Addressing</p>
 * 
 *  @author  Sulbha Aggarwal
 */
public class HashMap<E> 
{
	@SuppressWarnings("rawtypes")
	MapEntry[] hashMap ;
	int count ;
	int size ;
	int comp ;
	
/**
* parameterized constructor --
* creates an empty hashMap whose maximum size is specified by the default capacity.
*initialized all instance variables
*/
	HashMap()
	{
		hashMap = new MapEntry[876] ;
		for( int i = 0 ; i < hashMap.length ; i++ )
			hashMap[i] = null ;
		size = hashMap.length ;
		comp = 0 ;
	}
	
/**
 * get-- gets the value associated with specific key. If the hash for both the keys are same then it goes around the array 
 *       to look for right key of exists if not then return -1 ;	
 * @param key- key whose value to return  
 * @return the value with the specified key
 */
	public Object get( int key )
	{
		int hash = ( key % size ) ;
		int temp = -1 ;
		comp = 0 ;
		while( hash!= temp && ((hashMap[hash] == DeletedValue.getUniqueDeletedEntry() || hashMap[hash] != null) && hashMap[hash].getKey() != key) )
		{
			if( temp == -1 )
				temp = hash ;
			hash = (hash + 1 ) % size ;
			comp++ ;
		}
		if( hashMap[hash] == null || hash == temp )
			return -1 ;
		return hashMap[hash].getValue() ;
	}
	
	public int compare()
	{
		return comp ;
	}
/**
 * put -- Keep probing until an empty slot is found. Once an empty slot is found, insert key and value. If the key is exactly same as 
 *        as hash them replace the value of the key. 
 * @param key - the key to put in hashtable
 * @param value - the value associated with the key
 */
	@SuppressWarnings("unchecked")
	public void put( int key , E value )
	{
		int hash = ( key % size ) ;
		int temp = -1 ;
		boolean done = false ;
		
		while( hash != temp && !done &&( hashMap[hash] == DeletedValue.getUniqueDeletedEntry()  || hashMap[hash] != null && hashMap[hash].getKey() != key ) )
		{
			if(temp == -1 )
				temp = hash ;
			if( hashMap[hash] == DeletedValue.getUniqueDeletedEntry()  )
			{
				hashMap[hash] = new MapEntry<E>(key, value ) ; 
				done = true ;
				count++ ;
			}
			hash = (hash+1) % size ;
		}
		
		if( temp != hash  && !done )
		{
			if( hashMap[hash] != DeletedValue.getUniqueDeletedEntry() && hashMap[hash] != null && hashMap[hash].getKey() == key )
				hashMap[hash].setValue(value) ;
			else
				hashMap[hash] = new MapEntry<E>(key , value ) ;
			
			count++ ;
		}
	}
/**
 * remove -- slots of deleted keys are marked specially as “deleted" if the key is found.
 * @param key- key to be deleted 
 */
	public void remove( int key )
	{
		int hash = (key % size ) ;
		int temp = -1 ;
		while( hash != temp && (hashMap[hash] == DeletedValue.getUniqueDeletedEntry() || hashMap[hash] != null && hashMap[hash].getKey() != key ) ) 
		{
			if( temp == -1 )
				temp = hash ;
			hash = ( hash + 1 ) % size ;
		}
		
		if( hash != temp && hashMap[hash] != null )
		{
			hashMap[hash] = DeletedValue.getUniqueDeletedEntry() ;
			count-- ;
		}
	} 
	
/**
 * size-- how full is my hashMap	
 * @return the filled size of the hashMap
 */
	public int size()
	{
		return count ;
	}
	
	/**
	 * toString method --
	 * Returns the state of the HashMap.
	 * @return a reference to a String object that contains the keys and values stored
	 * in the hashMap
	 */
	public String toString()
	{
		String str = "" ;

		for( int i = 0 ; i < count ; i++ )
			if( hashMap[i] != null )
				str += hashMap[i].getKey() + " " + hashMap[i].getValue() + "\n" ;

		return str ;
	}

}
