package gameState;

import org.newdawn.slick.Graphics;

public abstract class State 
{
	protected StateManager sm;
	
	public abstract void init();
	public abstract void update();
	public abstract void draw(Graphics g);
	public abstract void deinit();
	
	public abstract void KeyPressed(int key, char c);
	public abstract void KeyReleased(int key, char c);
	
	public abstract void MousePressed(int button, int x, int y);
	public abstract void MouseReleased(int button, int x, int y);
	public abstract void MouseMove(int oldx, int oldy, int newx, int newy);
	public abstract void MouseWheelMoved(int change);
	
}
