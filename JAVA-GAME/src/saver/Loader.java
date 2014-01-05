package saver;

//TODO comments

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Loader extends Throwable
{
	InputStream in;
	
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
	
	
	public ArrayList<DataItem> dataItems = new ArrayList<DataItem>();
	public int fileVersion = -1;
	
	public Loader(String file,byte sort) throws FileEncodeExeption
	{
		try 
		{
			in = new FileInputStream(file);
			if(in.read() != sort || in.read() != ENDLINE1 || in.read() != ENDLINE2) {
				throw new FileEncodeExeption("The 'sort' parameter is wrong or the file is not readeble by this Loader",this);
			}
			fileVersion = ((in.read()) << 24) + ((in.read()) << 16) + ((in.read()) << 8)+ (in.read());
			if(in.read() != ENDLINE1 || in.read() != ENDLINE2)
			{
				throw new FileEncodeExeption("The file is not readeble by this Loader",this);
			}
		} 
		catch (FileNotFoundException e) {e.printStackTrace();} 
		catch (IOException e) {e.printStackTrace();}
	}
	
	public int[] LoadFile() throws FileEncodeExeption
	{
		int dataamount = 0;
		int fileamount = 0;
		try {
			int cur = 0;
			while(cur != -1)
			{	
				cur = in.read(); 
				if(cur != -1)
				{
					byte type = (byte) cur;
					int namelenght = in.read();
					char[] chars = new char[namelenght];
					for(int i = 0; i < namelenght; i++)
					{
						chars[i] = (char) in.read();
					}
					String name = Encoder.bytesToString(chars);
					
					byte[] data = new byte[0];
					int lenght;
					switch(type)
					{
					case BOOLTYPE:
					case BYTETYPE:
						data = new byte[]{(byte) in.read()};
						dataamount++;
						break;
					case CHARTYPE:
						data = new byte[]{(byte) in.read(),(byte) in.read()};
						dataamount++;
						break;
					case INTTYPE:
					case FLOATTYPE:
						data = new byte[]{(byte) in.read(),(byte) in.read(),(byte) in.read(),(byte) in.read()};
						dataamount++;
						break;
					case LONGTYPE:
					case DOUBLETYPE:
						data = new byte[]{(byte) in.read(),(byte) in.read(),(byte) in.read(),(byte) in.read()
							,(byte) in.read(),(byte) in.read(),(byte) in.read(),(byte) in.read()};
						dataamount++;
						break;
					case BYTESTYPE:
						lenght = (in.read() << 8) + in.read();
						data = new byte[lenght];
						for(int i = 0; i < lenght; i++)
						{
							data[i] = (byte) in.read();
						}
						dataamount++;
						break;
					case CHARSTYPE:
					case STRINGTYPE:
						lenght = (in.read() << 8) + in.read();
						data = new byte[lenght*2];
						for(int i = 0; i < lenght; i++)
						{
							data[i] = (byte) in.read();
						}
						dataamount++;
						break;
					case DIRSTART:
						if(in.read() != ENDLINE1 || in.read() != ENDLINE2)
						{throw new FileEncodeExeption("File read error",this);}
						ByteArrayOutputStream bytes = new ByteArrayOutputStream();
						boolean indir = true;
						while(indir)
						{
							type = (byte) in.read();
							bytes.write(type);
							namelenght = in.read();
							bytes.write(namelenght);
							char bytes2[] = new char[namelenght];
							for(int i = 0; i < namelenght; i++)
							{
								int j = in.read();
								bytes.write(j);
								bytes2[i] = (char) j;
							}
							String tname = Encoder.bytesToString(bytes2);
							switch(type)
							{
							case LONGTYPE:
							case DOUBLETYPE:
								bytes.write(in.read());
								bytes.write(in.read());
								bytes.write(in.read());
								bytes.write(in.read());
							case INTTYPE:
							case FLOATTYPE:
								bytes.write(in.read());
								bytes.write(in.read());
							case CHARTYPE:
								bytes.write(in.read());
							case BOOLTYPE:
							case BYTETYPE:
								bytes.write(in.read());
								break;
							case BYTESTYPE:
								lenght = (in.read() << 8) + in.read();
								bytes.write(new byte[]{(byte) (lenght >>> 8),(byte) lenght});
								for(int i = 0; i < lenght; i++)
								{
									bytes.write(in.read());
								}
							case DIRSTART:
								break;
							case DIRSTOP:
								if(name.compareTo(tname) == 0)
								{
									indir = false;
								}
								break;
							case CHARSTYPE:
							case STRINGTYPE:
								lenght = (in.read() << 8) + in.read();
								bytes.write(new byte[]{(byte) (lenght >>> 8),(byte) lenght});
								for(int i = 0; i < (lenght*2); i++)
								{
									bytes.write(in.read());
								}
								break;
							}
							if(indir)
							{
								if(in.read() != ENDLINE1 || in.read() != ENDLINE2)
								{throw new FileEncodeExeption("File read error",this);}
							}
							bytes.write(new byte[]{ENDLINE1,ENDLINE2});
						}
						data = bytes.toByteArray();
						fileamount++;
						break;
					}
					if(in.read() != ENDLINE1 || in.read() != ENDLINE2)
					{
						throw new FileEncodeExeption("File read error",this);
					}
					if (data.length > 0)
					{
						dataItems.add(new DataItem(name,type,data));
					}	
				}
			}
		}catch (IOException e) {e.printStackTrace();}
		return new int[]{dataamount,fileamount};
	}
	
	public ArrayList<DataItem> loadDir(DataItem item) throws FileEncodeExeption
	{
		ArrayList<DataItem> dataItems2 = new ArrayList<DataItem>();
		dirLine = 0;
		try {
			int cur = 0;
			while(cur != -1)
			{	
				cur = readDirLine(item); 
				if(cur != -1)
				{
					byte type = (byte) cur;
					int namelenght = readDirLine(item);
					char[] chars = new char[namelenght];
					for(int i = 0; i < namelenght; i++)
					{
						chars[i] = (char) readDirLine(item);
					}
					String name = Encoder.bytesToString(chars);
					
					byte[] data = new byte[0];
					int lenght;
					switch(type)
					{
					case BOOLTYPE:
					case BYTETYPE:
						data = new byte[]{(byte) readDirLine(item)};
						break;
					case CHARTYPE:
						data = new byte[]{(byte) readDirLine(item),(byte) readDirLine(item)};
						break;
					case INTTYPE:
					case FLOATTYPE:
						data = new byte[]{(byte) readDirLine(item),(byte) readDirLine(item),(byte) readDirLine(item),(byte) readDirLine(item)};
						break;
					case LONGTYPE:
					case DOUBLETYPE:
						data = new byte[]{(byte) readDirLine(item),(byte) readDirLine(item),(byte) readDirLine(item),(byte) readDirLine(item)
							,(byte) readDirLine(item),(byte) readDirLine(item),(byte) readDirLine(item),(byte) readDirLine(item)};
						break;
					case BYTESTYPE:
						lenght = (readDirLine(item) << 8) + readDirLine(item);
						data = new byte[lenght];
						for(int i = 0; i < lenght; i++)
						{
							data[i] = (byte) readDirLine(item);
						}
						break;
					case CHARSTYPE:
					case STRINGTYPE:
						lenght = (readDirLine(item) << 8) + readDirLine(item);
						data = new byte[lenght*2];
						for(int i = 0; i < lenght; i++)
						{
							data[i] = (byte) readDirLine(item);
						}
						break;
					case DIRSTART:
						if(readDirLine(item) != ENDLINE1 || readDirLine(item) != ENDLINE2)
						{throw new FileEncodeExeption("File read error",this);}
						ByteArrayOutputStream bytes = new ByteArrayOutputStream();
						boolean indir = true;
						while(indir)
						{
							type = (byte) readDirLine(item);
							bytes.write(type);
							namelenght = readDirLine(item);
							bytes.write(namelenght);
							char bytes2[] = new char[namelenght];
							for(int i = 0; i < namelenght; i++)
							{
								int j = readDirLine(item);
								bytes.write(j);
								bytes2[i] = (char) j;
							}
							String tname = Encoder.bytesToString(bytes2);
							switch(type)
							{
							case LONGTYPE:
							case DOUBLETYPE:
								bytes.write(readDirLine(item));
								bytes.write(readDirLine(item));
								bytes.write(readDirLine(item));
								bytes.write(readDirLine(item));
							case INTTYPE:
							case FLOATTYPE:
								bytes.write(readDirLine(item));
								bytes.write(readDirLine(item));
							case CHARTYPE:
								bytes.write(readDirLine(item));
							case BOOLTYPE:
							case BYTETYPE:
								bytes.write(readDirLine(item));
								break;
							case BYTESTYPE:
								lenght = (readDirLine(item) << 8) + readDirLine(item);
								bytes.write(new byte[]{(byte) (lenght >>> 8),(byte) lenght});
								for(int i = 0; i < lenght; i++)
								{
									bytes.write(readDirLine(item));
								}
							case DIRSTART:
								break;
							case DIRSTOP:
								if(name.compareTo(tname) == 0)
								{
									indir = false;
								}
								break;
							case CHARSTYPE:
							case STRINGTYPE:
								lenght = (readDirLine(item) << 8) + readDirLine(item);
								bytes.write(new byte[]{(byte) (lenght >>> 8),(byte) lenght});
								for(int i = 0; i < (lenght*2); i++)
								{
									bytes.write(readDirLine(item));
								}
								break;
							}
							if(indir)
							{
								if(readDirLine(item) != ENDLINE1 || readDirLine(item) != ENDLINE2)
								{throw new FileEncodeExeption("File read error",this);}
							}
							bytes.write(new byte[]{ENDLINE1,ENDLINE2});
						}
						data = bytes.toByteArray();
						break;
					}
					if(readDirLine(item) != ENDLINE1 || readDirLine(item) != ENDLINE2)
					{
						throw new FileEncodeExeption("File read error",this);
					}
					if (data.length > 0)
					{
						dataItems2.add(new DataItem(name,type,data));
					}	
				}
			}
		}catch (IOException e) {e.printStackTrace();}
		return dataItems2;
	}
	int dirLine = 0;
	
	private int readDirLine(DataItem item)
	{
		int i = -1;
		try
		{
			i = 0xff & item.data[dirLine];
		}catch(ArrayIndexOutOfBoundsException e){}
		
		dirLine++;
		return i;
	}
}
