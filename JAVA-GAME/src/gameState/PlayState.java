package gameState;

//TODO comments

import java.util.Random;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import world.Planet;
import world.World;
import drawers.NormalRenderer;
import entity.player.Player;
import entity.player.PlayerController;
import blocks.Blocklist;

public class PlayState extends State
{	
	public Blocklist blocklist;
	private NormalRenderer renderer;
	private World world;
	private Player player;
	private PlayerController controller;
	private GameContainer gc;
	
	public PlayState(StateManager stateManager, GameContainer gc) 
	{
		this.gc = gc;
		sm = stateManager;
		blocklist = new Blocklist();
	}
	
	public World getDrawWorld()
	{
		return world;
	}
	
	public void init() 
	{
		world = new Planet(this);
		player = new Player(world);
		renderer = new NormalRenderer(gc,this,player);
		controller = new PlayerController(player, renderer,world);
	}
	public void update() 
	{
		player.update();
	}
	public void draw(Graphics g)
	{
		renderer.draw(g);
	}
	public void deinit() {}

	public void keyPressed(int key, char c) {controller.keyPressed(key, c);}
	public void keyReleased(int key, char c) {controller.keyReleased(key, c);}

	public void mouseDragged(int oldx, int oldy, int newx, int newy) {controller.mouseDragged(oldx, oldy, newx, newy);}
	public void mousePressed(int button, int x, int y) {controller.mousePressed(button, x, y);}
	public void mouseReleased(int button, int x, int y) {controller.mouseReleased(button, x, y);}
	public void mouseMove(int x, int y, int nx, int ny) {controller.mouseMove(x, y, nx, ny);}
	public void mouseWheelMoved(int change) {controller.mouseWheelMoved(change);}


}
