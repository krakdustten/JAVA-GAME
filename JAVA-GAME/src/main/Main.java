package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main 
{
	public static Game game;
	
	public static void main(String[] args)
	{
		game = new Game("NO NAME GAME");
		AppGameContainer container;
		try 
		{
			container = new AppGameContainer(game);
			container.start();
		} 
		catch (SlickException e)
		{
			e.printStackTrace();
		}
	}
}
