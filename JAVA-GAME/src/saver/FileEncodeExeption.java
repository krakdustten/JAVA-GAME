package saver;

public class FileEncodeExeption extends Exception 
{
	private static final long serialVersionUID = 1L;
	
	public FileEncodeExeption(){}
	
	public FileEncodeExeption(String message)
	{super(message);}
	
	public FileEncodeExeption(String message, Throwable cause)
	{super(message,cause);}
	
	public FileEncodeExeption(Throwable cause)
	{super(cause);}
}
