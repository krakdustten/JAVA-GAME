package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main 
{
	public static Game game;
	
	public static void main(String[] args)
	{
		game = new Game("NO NAME GAME");//make the game
		AppGameContainer container;//make the screen
		try 
		{
			container = new AppGameContainer(game);//put the game in the screen
			container.setFullscreen(true);//make the game fullscreen
			container.setDisplayMode(container.getScreenWidth(), container.getScreenHeight(),true);//set the drawing area
			container.setMaximumLogicUpdateInterval(11);//set the updatetime
			container.setMinimumLogicUpdateInterval(9);
			container.start();//show the screen and start the game
		} 
		catch (SlickException e)
		{
			e.printStackTrace();
		}
	}
}
