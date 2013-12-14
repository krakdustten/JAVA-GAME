package gameState;

import org.newdawn.slick.Graphics;

public class PlayState extends State
{
	public PlayState(StateManager stateManager) 
	{
		sm = stateManager;
	}
	
	public void init() {}
	public void update() {}
	public void draw(Graphics g) {}
	
	public void deinit() {}

	public void KeyPressed(int key, char c) {}
	public void KeyReleased(int key, char c) {}

	public void MousePressed(int button, int x, int y) {}
	public void MouseReleased(int button, int x, int y) {}
	public void MouseMove(int x, int y, int dx, int dy) {}
	public void MouseWheelMoved(int change) {}


}
