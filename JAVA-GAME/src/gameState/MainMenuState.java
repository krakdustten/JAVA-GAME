package gameState;

//TODO comments

import menu.MainMenu;
import menu.Menu;
import menu.OptionsMenu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class MainMenuState extends State
{
	private Menu[] menus = new Menu[2];
	private int currentmenu = 0;
	
	public MainMenuState(StateManager stateManager, GameContainer gc) 
	{
		sm = stateManager;
		menus[0] = new MainMenu(gc,this,sm);
		menus[1] = new OptionsMenu(gc,this,sm);
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

	public void keyPressed(int key, char c) 
	{
		menus[currentmenu].KeyPressed(key, c);
	}
	public void keyReleased(int key, char c) 
	{
		menus[currentmenu].KeyReleased(key, c);
	}
	
	public void mousePressed(int key, int x, int y) 
	{
		menus[currentmenu].MousePressed(key, x, y);
	}
		
	public void mouseReleased(int key, int x, int y) 
	{
		menus[currentmenu].MouseReleased(key, x, y);
	}
	
	public void mouseMove(int oldx, int oldy, int newx, int newy) 
	{
		menus[currentmenu].MouseMove(oldx, oldy, newx, newy);
	}
	
	public void mouseWheelMoved(int change)
	{
		menus[currentmenu].MouseWheelMoved(change);
	}
}
