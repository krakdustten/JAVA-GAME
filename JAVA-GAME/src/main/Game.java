package main;

//TODO comments

import gameState.StateManager;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Game  extends BasicGame
{
	private StateManager sm;
	
	
	public Game(String title) 
	{
		super(title);
	}

	public void render(GameContainer con, Graphics g) throws SlickException
	{
		sm.draw(g);
	}

	public void init(GameContainer con) throws SlickException 
	{
		sm = new StateManager(con);
	}

	public void update(GameContainer con, int delta) throws SlickException
	{
		sm.update(con);
		Logger.flush();
	}
}
