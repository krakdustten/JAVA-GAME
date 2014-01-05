package saver;

//TODO comments

public class DataItem
{
	public String name;
	public byte type;
	public byte[] data;
	
	public DataItem(String name, byte type, byte[] data)
	{
		this.name = name;
		this.type = type;
		this.data = data;
	}
}
