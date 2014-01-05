package saver;

public class Encoder 
{
	public static byte[] stringToBytes(String string)
	{
		byte[] c = new byte[string.length()];
		for(int i=0; i<string.length(); i++)
		{
			char t = string.charAt(i);
			if(t >= 33 && t <= 126){c[i] = (byte) (t + 129);}
			else{return null;}
		}
		return c;
	}
	
	public static String bytesToString(char[] bytes)
	{
		for(int i = 0; i < bytes.length; i++)
		{
			bytes[i] = (char) (bytes[i] - 129); 
		}
		return String.copyValueOf(bytes);
	}
}
