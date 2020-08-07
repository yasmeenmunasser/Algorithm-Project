package Algorithem;
/**
 *  <p>Title: MapEntry Class</p>
 *
 * <p>Description: This class set the frame for Hash Map.
 * 
 * @author Sulbha Aggarwal
 */
public class MapEntry<E> 
{
	private int key ;
	private E value ;

	MapEntry( int key , E value )
	{
		this.key = key ;
		this.value = value ;
	}
	
	public E getValue()
	{
		return value ;
	}
	
	public void setValue( E value )
	{
		this.value = value ;
	}
	
	public int getKey()
	{
		return key ;
	}
	
	
}
