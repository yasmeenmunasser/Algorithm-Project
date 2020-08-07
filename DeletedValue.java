package Algorithem;

@SuppressWarnings("rawtypes")
public class DeletedValue extends MapEntry
{
	private static DeletedValue entry = null ;
	
	@SuppressWarnings("unchecked")
	DeletedValue() 
	{
		super(-1, -1);
	}

	public static DeletedValue getUniqueDeletedEntry()
	{
		if( entry == null )
			entry = new DeletedValue() ;
		return entry ;
	}
	

}
