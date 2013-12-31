package entity;

import org.newdawn.slick.Graphics;

import drawers.Render;
import world.World;

public abstract class Entity 
{
	private int chunkx, chunky, ID;
	protected World world;
	
	protected float x = 0;
	protected float y = 0;
	protected float dx = 0;
	protected float dy = 0;
	
	public boolean left = false;
	public boolean right = false;
	public boolean up = false;
	public boolean down = false;
	
	protected float acelspeed;
	protected float maxspeed;
	protected float decelspeed;
	
	protected float jumpmaxspeed;
	protected float jumpdecel;
	protected float faldecel;
	protected float maxfalspeed;
	
	
	
	public abstract void draw(float sx, float sy, Render render, Graphics g);
	
	public float getX() {return x;}
	public float getY() {return y;}
}
