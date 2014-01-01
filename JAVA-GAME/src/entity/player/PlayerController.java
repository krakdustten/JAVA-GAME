package entity.player;

//TODO comments

import world.World;
import drawers.NormalRenderer;
import entity.Entity;

public class PlayerController 
{
	Entity entity;
	NormalRenderer nr;
	World world;
	
	public PlayerController(Entity entity, NormalRenderer nr,World world) 
	{
		this.entity = entity;
		this.nr = nr;
		this.world = world;
	}

	public void keyPressed(int key, char c) 
	{
		switch(key)
		{
		case 200:entity.up = true;break;
		case 203:entity.left = true;break;
		case 205:entity.right = true;break;
		case 208:entity.down = true;break;
		}
	}
	public void keyReleased(int key, char c) 
	{
		switch(key)
		{
		case 200:entity.up = false;break;
		case 203:entity.left = false;break;
		case 205:entity.right = false;break;
		case 208:entity.down = false;break;
		}
	}

	public void mouseDragged(int oldx, int oldy, int newx, int newy) {}
	public void mousePressed(int button, int x, int y) 
	{
		int bx = (int) ((-nr.screendrawstartx + x)/32 + nr.blockdrawstartx + 0.5f);
		int by = (int) ((-nr.screendrawstarty + y)/32 + nr.blockdrawstarty + 0.5f);
		if(button == 0)
		{
			world.setBlockId(bx, by, 1);
		}
		else if(button == 1)
		{
			world.setBlockId(bx, by, 0);
		}
	}
	public void mouseReleased(int button, int x, int y) {}
	public void mouseMove(int x, int y, int nx, int ny) {}
	public void mouseWheelMoved(int change) {}
}
