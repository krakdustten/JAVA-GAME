package entity.player;

//TODO comments
//TODO you stop when you hit the ground

import org.newdawn.slick.Graphics;

import drawers.Render;
import world.World;
import entity.Entity;

public class Player extends Entity 
{
	protected byte state = 0;
	final byte IDLE = 0;
	final byte WALKING = 1;
	final byte JUMPING = 2;
	final byte FALLING = 3;
	
	
	public Player(World world) 
	{
		this.world = world;
		
		acelspeed = 0.005f;
		maxspeed = 0.5f;
		decelspeed = 0.025f;
		
		jumpmaxspeed = 0.3f;
		jumpdecel = 0.005f;
		faldecel = 0.01f;
		maxfalspeed = 2.0f;
		
		x = 60;
		y = 600;
	}
	
	public void update()
	{
		if(left)
		{
			if (dx > 0){dx -= decelspeed;}
			else{dx -= acelspeed;}
			if(dx < -maxspeed){ dx = -maxspeed;}
		}
		else if(right)
		{
			if(dx < 0){dx += decelspeed;}
			else{dx += acelspeed;}
			if(dx > maxspeed){dx = maxspeed;}
		}
		else
		{
			if(dx > 0){dx -= decelspeed;
				if(dx < 0){dx = 0;}}
			else if(dx < 0){dx += decelspeed;
				if(dx > 0){dx = 0;}}
		}
		if(up)
		{
			if(state != JUMPING && state != FALLING)
			{
				dy = -jumpmaxspeed;
			}
				
		}
		
		if(state == JUMPING || state == FALLING)
		{
			if(state == JUMPING){dy += jumpdecel;}
			else{dy += faldecel;}
			
			if (dy > maxfalspeed)
			{
				dy = maxfalspeed;
			}
			dx = dx - acelspeed/2;
		}
		else
		{
			dy += 0.01f;
		}
		
		
		
		float tempx = x + dx;
		float tempy = y + dy;
		
		float tempy2 = tempy + 0.51f;
		float tempx2 = tempx + 0.5f;
		int tempy3 = (int) tempy2;
		
		if(dx > 0)
		{
			if(!isblockedx((int) (tempx+1.5f),(int)(tempy+0.51f),isbetween(tempy2, tempy3 +0.1f, tempy3 -0.1f)))
			{
				x = tempx;
			}
			else
			{
				dx = 0;
			}
		}
		else if(dx < 0)
		{
			if(!isblockedx((int) (tempx-0.5f),(int)(tempy+0.51f),isbetween(tempy2, tempy3 +0.1f, tempy3 -0.1f)))
			{
				x = tempx;
			}
			else
			{
				dx = 0;
			}
		}
		if(dy > 0)
		{
			if(!isblockedy((int) (tempx+0.55f), (int)(tempy+2.5f),isbetween(tempx2, (int)(tempx2+0.05f) +0.2f, (int)(tempx2+0.05f) -0.2f)))
			{
				y = tempy;
			}
			else
			{
				dy = 0;
			}
		}
		else if(dy < 0)
		{
			if(!isblockedy((int) (tempx+0.51f), (int)(tempy-1.25f),isbetween(tempx2, (int)(tempx2+0.05f) +0.2f, (int)(tempx2+0.05f) -0.2f)))
			{
				y = tempy;
			}
			else
			{
				dy = 0.001f;
				state = FALLING;
			}
		}
		
		if(dy < 0){state = JUMPING;}
		else if(dy > 0){state = FALLING;}
		else if(dx != 0){state = WALKING;}
		else{state = IDLE;}
	}
	
	private boolean isbetween(float waardee, float max, float min)
	{
		if(waardee < max)
		{
			if(waardee > min)
			{
				return true;
			}
		}
		return false;
	}
	
	private boolean isblockedx(int x, int y, boolean bln4)
	{
		if(bln4)
		{
			if(world.getBlockId(x, y) == 0 &&
			   world.getBlockId(x, y-1) == 0 &&
			   world.getBlockId(x, y+1) == 0 &&
			   world.getBlockId(x, y-2) == 0)
			{
				return false;
			}
		}
		else
		{
			if(world.getBlockId(x, y) == 0 &&
			   world.getBlockId(x, y-1) == 0 &&
			   world.getBlockId(x, y+1) == 0 &&
			   world.getBlockId(x, y-2) == 0 &&
			   world.getBlockId(x, y+2) == 0)
			{
				return false;
			}
		}
		return true;
	}
	
	private boolean isblockedy(int x, int y, boolean bln2)
	{
		if(bln2)
		{
			if(world.getBlockId(x, y) == 0 &&
			   world.getBlockId(x - 1, y) == 0)
			{
				return false;
			}
		}
		else
		{
			if(world.getBlockId(x, y) == 0 &&
			   world.getBlockId(x - 1, y) == 0 &&
			   world.getBlockId(x + 1, y) == 0)
			{
				return false;
			}
		}
		return true;
	}

	public void draw(float x, float y, Render render, Graphics g)
	{
		g.fillRect(x-32, y-64, 64, 128);
		
	}

}
