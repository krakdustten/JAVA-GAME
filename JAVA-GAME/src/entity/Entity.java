package entity;

import org.newdawn.slick.Graphics;

import drawers.Render;
import world.World;

public abstract class Entity 
{
	//the ids of the entity
	private int chunkx, chunky, ID;
	protected World world;
	
	protected float x = 0;//the x coordinate
	protected float y = 0;//the y coordinate
	protected float dx = 0;//the x movement
	protected float dy = 0;//the y movement
	
	public boolean left = false;//is the entity going left
	public boolean right = false;//is the entity going right
	public boolean up = false;//is the entity going up
	public boolean down = false;//is the entity going down
	
	protected float acelspeed;//the acelleration speed
	protected float maxspeed;//the maximum speed
	protected float decelspeed;//the deceleration speed
	
	protected float jumpmaxspeed;//the maximum jump speed
	protected float jumpdecel;//the jump deceleration speed
	protected float faldecel;//the fall deceleration speed
	protected float maxfalspeed;//the maximum fall speed
	
	/** draw the entity at sx,sy
	 * @param sx the x coordinate of the screen
	 * @param sy the y coordinate of the screen
	 * @param render the renderer
	 * @param g the graphics
	 */
	public abstract void draw(float sx, float sy, Render render, Graphics g);
	
	public float getX() {return x;}
	public float getY() {return y;}
}
