package gameState;

public class MainMenuState extends State
{
	public MainMenuState(StateManager stateManager) 
	{
		sm = stateManager;
	}
	
	public void init() {}
	public void update() {}
	public void draw() {}
	public void deinit() {}

	public void KeyPressed(int key) {}
	public void KeyReleased(int key) {}

	public void MousePressed(int key) {}
	public void MouseReleased(int key) {}
	public void MouseMove(int x, int y, int dx, int dy) {}
	public void MouseWheelMoved(int d) {}
}
