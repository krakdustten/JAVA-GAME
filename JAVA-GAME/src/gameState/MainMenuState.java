package gameState;

import menu.MainMenu;
import menu.Menu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class MainMenuState extends State
{
	private Menu[] menus = new Menu[1];
	private int currentmenu = 0;
	
	public MainMenuState(StateManager stateManager, GameContainer gc) 
	{
		sm = stateManager;
		menus[0] = new MainMenu(gc,this,sm);
	}
	
	public void setMenu(int ID)
	{
		currentmenu = ID;
	}
	
	public void init() {}
	public void update() 
	{
		menus[currentmenu].update();
	}
	
	public void draw(Graphics g) 
	{
		menus[currentmenu].draw(g);
	}
	
	public void deinit() {}

	public void KeyPressed(int key, char c) 
	{
		menus[currentmenu].KeyPressed(key, c);
	}
	public void KeyReleased(int key, char c) 
	{
		menus[currentmenu].KeyReleased(key, c);
	}
	
	public void MousePressed(int key, int x, int y) 
	{
		menus[currentmenu].MousePressed(key, x, y);
	}
		
	public void MouseReleased(int key, int x, int y) 
	{
		menus[currentmenu].MouseReleased(key, x, y);
	}
	
	public void MouseMove(int oldx, int oldy, int newx, int newy) 
	{
		menus[currentmenu].MouseMove(oldx, oldy, newx, newy);
	}
	
	public void MouseWheelMoved(int change)
	{
		menus[currentmenu].MouseWheelMoved(change);
	}
}
