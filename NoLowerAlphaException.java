


@SuppressWarnings("serial")
public class NoLowerAlphaException extends Exception {

	public NoLowerAlphaException()
	{
		this("The password must contain at least one lower case alphabetic character");
	}
	
	
	public NoLowerAlphaException(String string)
	{
		super(string);
	}
	
	

}
