package entity;

import org.newdawn.slick.Graphics;

public abstract class Entity 
{
	private int chunkx, chunky, ID;
	
	public abstract void update();
	public abstract void draw(Graphics g);
}
