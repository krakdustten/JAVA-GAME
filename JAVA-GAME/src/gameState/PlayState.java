package gameState;

//TODO comments

import java.util.Random;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import world.Planet;
import world.World;
import drawers.NormalRenderer;
import blocks.Blocklist;

public class PlayState extends State
{	
	public Blocklist blocklist;
	private NormalRenderer renderer;
	private World world;
	
	public PlayState(StateManager stateManager, GameContainer gc) 
	{
		sm = stateManager;
		blocklist = new Blocklist();
		renderer = new NormalRenderer(gc,this);
		
	}
	
	public World getDrawWorld()
	{
		return world;
	}
	
	public void init() 
	{
		world = new Planet(this);
	}
	public void update() {}
	public void draw(Graphics g)
	{
		renderer.draw(g);
	}
	public void deinit() {}

	public void KeyPressed(int key, char c) {}
	public void KeyReleased(int key, char c) {}

	public void MousePressed(int button, int x, int y)
	{
		int x1 = (int)(renderer.x + 1.0);
		int y1 = (int)(renderer.y + 1.0);
		
		System.out.println(button);
		
		if(button == 0)
		{
			world.setBlockId(x1, y1, 1);
			world.getBlock(x1, y1).UpdateNeibeurs(x1, y1, world, new Random());
		}
		else if(button == 1)
		{
			world.setBlockId(x1, y1, 0);
			world.getBlock(x1, y1).UpdateNeibeurs(x1, y1, world, new Random());
		}
			
	}
	public void MouseReleased(int button, int x, int y) {}
	public void MouseMove(int x, int y, int nx, int ny)
	{
		float dx = nx - x;
		float dy = ny - y;
		renderer.x += dx /20;
		renderer.y += dy /20;
		Mouse.setCursorPosition(400, 400);
	}
	public void MouseWheelMoved(int change) {}


}
