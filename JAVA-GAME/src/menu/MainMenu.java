package menu;

import gameState.MainMenuState;
import gameState.StateManager;
import gui.GuiButton;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class MainMenu extends Menu 
{
	GuiButton[] buttons = new GuiButton[3];
	private GameContainer gc;
	private MainMenuState mms;
	private StateManager sm;
	
	public MainMenu(GameContainer gc,MainMenuState mms, StateManager sm)
	{
		this.gc = gc;
		this.mms = mms;
		this.sm = sm;
		buttons[0] = new GuiButton("res/text.png","res/hov.png","res/click.png","Start", "res/Font.ttf",0,this);
		buttons[0].setPos(100, 100);
		buttons[1] = new GuiButton("res/text.png","res/hov.png","res/click.png","Options", "res/Font.ttf",1,this);
		buttons[1].setPos(100, 200);
		buttons[2] = new GuiButton("res/text.png","res/hov.png","res/click.png","Guit", "res/Font.ttf",2,this);
		buttons[2].setPos(100, 300);
	}

	public void Action(int ID)
	{
		switch(ID)
		{
		case 0:
			sm.Setstate(sm.PLAYSTATE);
			break;
		case 1:
			mms.setMenu(1);
			break;
		case 2:
			gc.exit();
			break;
		}
	}
	
	public void update() 
	{
		for (GuiButton button : buttons)
		{
			button.update();
		}
	}
	public void draw(Graphics g) 
	{
		for (GuiButton button : buttons)
		{
			button.draw(g);
		}
	}
	
	public void KeyPressed(int key, char c) {}
	public void KeyReleased(int key, char c) {}
	
	public void MousePressed(int key, int x, int y) 
	{
		for (GuiButton button : buttons)
		{
			button.MousePressed(key, x, y);
		}
	}
	
	public void MouseReleased(int key, int x, int y) 
	{
		for (GuiButton button : buttons)
		{
			button.MouseReleased(key, x, y);
		}
	}
	
	public void MouseMove(int oldx, int oldy, int newx, int newy)
	{
		for (GuiButton button : buttons)
		{
			button.MouseMove(oldx, oldy, newx, newy);
		}
	}
	
	public void MouseWheelMoved(int change) 
	{
		for (GuiButton button : buttons)
		{
			button.MouseWheelMoved(change);
		}
	}
}
