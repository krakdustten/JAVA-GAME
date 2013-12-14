package gameState;

import gui.GuiButton;

import org.newdawn.slick.Graphics;

public class MainMenuState extends State
{
	private GuiButton button = new GuiButton("res/text.png","res/hov.png","res/click.png");
	
	public MainMenuState(StateManager stateManager) 
	{
		sm = stateManager;
	}
	
	public void init() {}
	public void update() {}
	public void draw(Graphics g) 
	{
		button.draw(g);
	}
	
	public void deinit() {}

	public void KeyPressed(int key, char c) {}
	public void KeyReleased(int key, char c) {}

	public void MousePressed(int button, int x, int y) {}
	public void MouseReleased(int button, int x, int y) {}
	public void MouseMove(int x, int y, int dx, int dy) 
	{
		button.MouseMove(x, y, dx, dy);
	}
	public void MouseWheelMoved(int change) {}
}
