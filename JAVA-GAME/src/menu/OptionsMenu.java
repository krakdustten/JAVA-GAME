package menu;

import gameState.MainMenuState;
import gameState.StateManager;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class OptionsMenu extends Menu 
{
	private GameContainer gc;
	private MainMenuState mms;
	private StateManager sm;
	
	public OptionsMenu(GameContainer gc,MainMenuState mms, StateManager sm) 
	{
		this.gc = gc;
		this.mms = mms;
		this.sm = sm;
	}
	
	public void Action(int ID) {}
	public void update() {}
	public void draw(Graphics g) {}
	public void KeyPressed(int key, char c) {}
	public void KeyReleased(int key, char c) {}
	public void MousePressed(int button, int x, int y) {}
	public void MouseReleased(int button, int x, int y) {}
	public void MouseMove(int oldx, int oldy, int newx, int newy) {}
	public void MouseWheelMoved(int change) {}

}
