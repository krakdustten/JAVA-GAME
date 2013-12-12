package gameState;

public abstract class State 
{
	protected StateManager sm;
	
	public abstract void init();
	public abstract void update();
	public abstract void draw();
	public abstract void deinit();
	
	public abstract void KeyPressed(int key);
	public abstract void KeyReleased(int key);
	
	public abstract void MousePressed(int key);
	public abstract void MouseReleased(int key);
	public abstract void MouseMove(int x, int y, int dx, int dy);
	public abstract void MouseWheelMoved(int d);
	
}
