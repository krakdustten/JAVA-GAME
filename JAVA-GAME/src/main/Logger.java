package main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Logger 
{
	private static BufferedWriter log;//the log itself
	private static long time;
	
	/** initialise the logger
	 */
	public static void initLogger()
	{
		log = new BufferedWriter(new OutputStreamWriter(System.out));//create the logger
		time = System.currentTimeMillis();
		println("logger initialised");
	}
	
	/** print the log to the screen
	 */
	public static void flush()
	{
		try {log.flush();} 
		catch (IOException e) {e.printStackTrace();}
	}
	
	/** print a text to the log*/
	public static void print(String text)
	{
		try {log.write(text);} 
		catch (IOException e) {e.printStackTrace();}
	}
	
	/** print an integer to the log*/
	public static void print(int i){print(Integer.toString(i));}
	/** print a boolean to the log*/
	public static void print(boolean b){print(Boolean.toString(b));}
	/** print a long to the log*/
	public static void print(long l){print(Long.toString(l));}
	/** print a double to the log*/
	public static void print(double d){print(Double.toString(d));}
	/** print a float to the log*/
	public static void print(float f){print(Float.toString(f));}
	/** print a c to the log*/
	public static void print(char c){print(String.valueOf(c));}
	/** print an array of chars to the log*/
	public static void print(char[] s){print(String.valueOf(s));}
	
	/** print a text to the log and start a new line*/
	public static void println(String text)
	{print("["+Float.toString((System.currentTimeMillis()-time)/1000.0f)+"s]" + text + "\n");}
	/** print an integer to the log and start a new line*/
	public static void println(int i){println(Integer.toString(i));}
	/** print a boolean to the log and start a new line*/
	public static void println(boolean b){println(Boolean.toString(b));}
	/** print a long to the log and start a new line*/
	public static void println(long l){println(Long.toString(l));}
	/** print a double to the log and start a new line*/
	public static void println(double d){println(Double.toString(d));}
	/** print a float to the log and start a new line*/
	public static void println(float f){println(Float.toString(f));}
	/** print a char to the log and start a new line*/
	public static void println(char c){println(String.valueOf(c));}
	/** print an array of chars to the log and start a new line*/
	public static void println(char[] s){println(String.valueOf(s));}
	
}
