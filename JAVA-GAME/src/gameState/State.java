package gameState;

//TODO comments

import org.newdawn.slick.Graphics;

public abstract class State 
{
	protected StateManager sm;
	
	public void init(){}
	public void update(){}
	public void draw(Graphics g){}
	public void deinit(){}
	
	public void keyPressed(int key, char c){}
	public void keyReleased(int key, char c){}
	
	public void mousePressed(int button, int x, int y){}
	public void mouseReleased(int button, int x, int y){}
	public void mouseMove(int oldx, int oldy, int newx, int newy){}
	public void mouseWheelMoved(int change){}
	public void mouseDragged(int oldx, int oldy, int newx, int newy) {}
	
}
