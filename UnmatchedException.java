



@SuppressWarnings("serial")
public class UnmatchedException extends Exception
{
	public UnmatchedException()
	{
		this("Passwords do not match");
	}
	public UnmatchedException(String message)
	{
		super(message);
	}
}
