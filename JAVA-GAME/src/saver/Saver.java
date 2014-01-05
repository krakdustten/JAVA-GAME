package saver;

//TODO commends

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Saver 
{
	OutputStream out;
	
	final byte DIRSTART = 28;
	final byte DIRSTOP = 29;
	
	final byte BOOLTYPE = 30;
	final byte BYTETYPE = 31;
	final byte CHARTYPE = 32;
	final byte INTTYPE = 33;
	final byte LONGTYPE = 34;
	final byte FLOATTYPE = 35;
	final byte DOUBLETYPE = 36;
	
	final byte BYTESTYPE = 37;
	final byte CHARSTYPE = 38;
	final byte STRINGTYPE = 39;
	
	final byte ENDLINE1 = 13;
	final byte ENDLINE2 = 10;
	
	public Saver(String file, byte sort, int version)
	{
		try 
		{
			out = new FileOutputStream(file);
			out.write(new byte[]{sort,13,10});//print sort of file
			out.write(new byte[]{(byte)(version >>> 24)//print version of file
								,(byte)(version >>> 16)
								,(byte)(version >>> 8)
								,(byte)(version)
								,ENDLINE1,ENDLINE2});//end of line
		} 
		catch (FileNotFoundException e){e.printStackTrace();} 
		catch (IOException e) {e.printStackTrace();}
	}
	
	public void saveBool(String name, boolean value)
	{
		if(name.length() >= 256){return;}
		try {
			out.write(new byte[]{BOOLTYPE,(byte) name.length()});
			out.write(Encoder.stringToBytes(name));
			out.write(new byte[]{(byte) (value ? 1:0)});
			out.write(new byte[]{ENDLINE1,ENDLINE2});
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void saveByte(String name, byte value)
	{
		if(name.length() >= 256){return;}
		try {
			out.write(new byte[]{BYTETYPE,(byte) name.length()});
			out.write(Encoder.stringToBytes(name));
			out.write(new byte[]{value});
			out.write(new byte[]{ENDLINE1,ENDLINE2});
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void saveChar(String name, char value)
	{
		if(name.length() >= 256){return;}
		try {
			out.write(new byte[]{CHARTYPE,(byte) name.length()});
			out.write(Encoder.stringToBytes(name));
			out.write(new byte[]{(byte) (value >>> 8),(byte) value});
			out.write(new byte[]{ENDLINE1,ENDLINE2});
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void saveInt(String name, int value)
	{
		if(name.length() >= 256){return;}
		try {
			out.write(new byte[]{INTTYPE,(byte) name.length()});
			out.write(Encoder.stringToBytes(name));
			out.write(new byte[]{(byte)(value >>> 24),(byte)(value >>> 16),(byte)(value >>> 8),(byte)(value)});
			out.write(new byte[]{ENDLINE1,ENDLINE2});
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void saveLong(String name, long value)
	{
		if(name.length() >= 256){return;}
		try {
			out.write(new byte[]{LONGTYPE,(byte) name.length()});
			out.write(Encoder.stringToBytes(name));
			out.write(new byte[]{(byte)(value >>> 56),(byte)(value >>> 48),(byte)(value >>> 40),(byte)(value >>> 32)});
			out.write(new byte[]{(byte)(value >>> 24),(byte)(value >>> 16),(byte)(value >>> 8),(byte)(value)});
			out.write(new byte[]{ENDLINE1,ENDLINE2});
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void saveFloat(String name, float value)
	{
		if(name.length() >= 256){return;}
		try {
			out.write(new byte[]{FLOATTYPE,(byte) name.length()});
			out.write(Encoder.stringToBytes(name));
			out.write(new byte[]{(byte)(Float.floatToIntBits(value) >>> 24)
								,(byte)(Float.floatToIntBits(value) >>> 16)
								,(byte)(Float.floatToIntBits(value) >>> 8)
								,(byte)(Float.floatToIntBits(value))});
			out.write(new byte[]{ENDLINE1,ENDLINE2});
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void saveDouble(String name, double value)
	{
		if(name.length() >= 256){return;}
		try {
			out.write(new byte[]{DOUBLETYPE,(byte) name.length()});
			out.write(Encoder.stringToBytes(name));
			out.write(new byte[]{(byte)(Double.doubleToLongBits(value) >>> 56)
								,(byte)(Double.doubleToLongBits(value) >>> 48)
								,(byte)(Double.doubleToLongBits(value) >>> 40)
								,(byte)(Double.doubleToLongBits(value) >>> 32)
								,(byte)(Double.doubleToLongBits(value) >>> 24)
								,(byte)(Double.doubleToLongBits(value) >>> 16)
								,(byte)(Double.doubleToLongBits(value) >>> 8)
								,(byte)(Double.doubleToLongBits(value))});
			out.write(new byte[]{ENDLINE1,ENDLINE2});
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void saveBytes(String name, byte[] value)
	{
		if(name.length() >= 256){return;}
		try {
			out.write(new byte[]{BYTESTYPE,(byte) name.length()});
			out.write(Encoder.stringToBytes(name));
			out.write(new byte[]{(byte) (value.length >>> 8),(byte) (value.length)});
			out.write(value);
			out.write(new byte[]{ENDLINE1,ENDLINE2});
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void saveChars(String name, char[] value)
	{
		if(name.length() >= 256){return;}
		try {
			out.write(new byte[]{CHARSTYPE,(byte) name.length()});
			out.write(Encoder.stringToBytes(name));
			out.write(new byte[]{(byte) (value.length >>> 8),(byte) (value.length)});
			for(int i = 0; i < value.length; i++)
			{
				out.write(new byte[]{(byte)(value[i] >>> 8),(byte)(value[i])});
			}
			
			out.write(new byte[]{ENDLINE1,ENDLINE2});
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void saveString(String name, String value)
	{
		if(name.length() >= 256){return;}
		try {
			out.write(new byte[]{STRINGTYPE,(byte) name.length()});
			out.write(Encoder.stringToBytes(name));
			out.write(new byte[]{(byte) (value.length() >>> 8),(byte) (value.length())});
			for(int i = 0; i < value.length(); i++)
			{
				out.write(new byte[]{(byte)(value.charAt(i) >>> 8),(byte)(value.charAt(i))});
			}
			
			out.write(new byte[]{ENDLINE1,ENDLINE2});
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void startDir(String name)
	{
		if(name.length() >= 256){return;}
		try {
			out.write(new byte[]{DIRSTART,(byte) name.length()});
			out.write(Encoder.stringToBytes(name));
			out.write(new byte[]{ENDLINE1,ENDLINE2});
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void stopDir(String name)
	{
		if(name.length() >= 256){return;}
		try {
			out.write(new byte[]{DIRSTOP,(byte) name.length()});
			out.write(Encoder.stringToBytes(name));
			out.write(new byte[]{ENDLINE1,ENDLINE2});
		} catch (IOException e) {e.printStackTrace();}
	}

	public void close() 
	{
		try {out.close();} 
		catch (IOException e) {e.printStackTrace();}
	}
}
