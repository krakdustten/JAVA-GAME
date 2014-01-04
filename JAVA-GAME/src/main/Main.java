package main;

//TODO options class
//TODO save load system
//TODO read options from the start

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import saver.Saver;

public class Main 
{
	public static Game game;
	
	public static void main(String[] args)
	{
		Logger.initLogger();//init the logger
		
		Logger.println("Starting the game");
		game = new Game("NO NAME GAME");//make the game
		AppGameContainer container;//make the screen
		try 
		{
			container = new AppGameContainer(game);//put the game in the screen
			//container.setFullscreen(true);//make the game fullscreen
			container.setDisplayMode(800,800,false);//container.getScreenWidth(), container.getScreenHeight(),true);//set the drawing area
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
