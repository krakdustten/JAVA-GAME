package gui;

import org.newdawn.slick.Graphics;

public abstract class GuiControl 
{
	public int x,y;
	public int width, height;
	
	public abstract void init();
	public abstract void update();
	public abstract void draw(Graphics g);
	public abstract void deinit();
	
	public void KeyPressed(int key){}
	public void KeyReleased(int key){}
	
	public void MousePressed(int key){}
	public void MouseReleased(int key){}
	public void MouseMove(int x, int y, int dx, int dy){}
	public void MouseWheelMoved(int d){}
}
