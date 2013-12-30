package blocks;

//TODO comments

import java.util.Random;

import org.newdawn.slick.SpriteSheet;

import world.World;
import drawers.Render;

public abstract class Block 
{
	protected SpriteSheet sheet;
	protected int ID;
	
	public void draw(float sx, float sy, Render render, int textureId)
	{
		render.RenderBlock(sheet.getSprite(textureId%4, textureId/16), sx, sy, ((textureId/4)%4)*90);
	}
	
	public void Update(int x, int y, World world,Random rand)
	{
		updateTexture(x,y,world,rand);
	}

	private void updateTexture(int x, int y, World world,Random rand) 
	{
		boolean up = false;
		boolean down = false;
		boolean left = false;
		boolean right = false;
		boolean upright = false;
		boolean upleft = false;
		boolean downright = false;
		boolean downleft = false;
		
		int temp1 = 0;
		int temp2 = 0;
		
		if(world.getBlockId(x+1, y) != 0){temp1++;right = true;}
		if(world.getBlockId(x-1, y) != 0){temp1++;left = true;}
		if(world.getBlockId(x, y+1) != 0){temp1++;up = true;}
		if(world.getBlockId(x, y-1) != 0){temp1++;down = true;}
		if(world.getBlockId(x+1, y+1) != 0){temp2++;upright = true;}
		if(world.getBlockId(x-1, y+1) != 0){temp2++;upleft = true;}
		if(world.getBlockId(x+1, y-1) != 0){temp2++;downright = true;}
		if(world.getBlockId(x-1, y-1) != 0){temp2++;downleft = true;}

		int textureId = 0;
		int rotate = 0;
		
		if(temp1 == 3)//1,10,11
		{
			if(!up)
			{
				rotate = 3;
				if(!downright && !downleft){textureId = 10;}
				else if(!downright || !downleft){textureId = 13;
					if(!downright){textureId = 11;}}
				else{textureId = 1;}
			}
			if(!right)
			{
				rotate = 2;
				if(!upleft && !downleft){textureId = 10;}
				else if(!upleft || !downleft){textureId = 13;
					if(!downleft){textureId = 11;}}
				else{textureId = 1;}
			}
			if(!down)
			{
				rotate = 1;
				if(!upleft && !upright){textureId = 10;}
				else if(!upleft || !upright){textureId = 13;
					if(!upleft){textureId = 11;}}
				else{textureId = 1;}
			}
			if(!left)
			{
				rotate = 0;
				if(!downright && !upright){textureId = 10;}
				else if(!downright || !upright){textureId = 13;
					if(!upright){textureId = 11;}}
				else{textureId = 1;}
			}
		}
		else if(temp1 == 2)//2,9,12
		{
			if((!up && !down) || (!right && !left))
			{
				textureId = 12;
				if(!right){rotate = 0;}
				else{rotate = 1;}
			}
			if(!up)
			{
				if(!right){rotate = 2;
					if(!downleft){textureId = 9;}
					else{textureId = 2;}}
				else if(!left){rotate = 3;
					if(!downright){textureId = 9;}
					else{textureId = 2;}}
			}
			else if(!down)
			{
				if(!right){rotate = 1;
					if(!upleft){textureId = 9;}
					else{textureId = 2;}}
				else if(!left){rotate = 0;
					if(!upright){textureId = 9;}
					else{textureId = 2;}}
			}
		}
		else if(temp1 == 1)//3
		{
			textureId = 3;
			if(up){rotate = 0;}
			else if(right){rotate = 3;}
			else if(down){rotate = 2;}
			else if(left){rotate = 1;}
		}
		else if(temp1 == 0){textureId = 4;}	//4
		else if(temp2 == 3)//5
		{
			textureId = 5;
			if(!upleft){rotate = 3;}
			else if(!upright){rotate = 2;}
			else if(!downleft){rotate = 0;}
			else if(!downright){rotate = 1;}
		}
		else if(temp2 == 2){textureId = 6;//6
			if(!upleft){
				if(!upright){rotate = 2;}
				else if(!downleft){rotate = 3;}}
			else if(!downright){
				if(!upright){rotate = 1;}
				else if(!downleft){rotate = 0;}}
		}
		else if(temp2 == 1)//7
		{
			textureId = 7;
			if(upleft){rotate = 1;}
			if(downleft){rotate = 2;}
			if(upright){rotate = 0;}
			if(downright){rotate = 3;}
		}
		else if(temp2 == 0){textureId = 8;}//8
		else{textureId = 0;}//0
		
		world.setBlockTextureId(x,y,textureId * 16 + rotate * 4 + rand.nextInt(4));
		
	}

	public void UpdateNeibeurs(int x, int y, World world, Random rand) 
	{
		Update(x,y,world,rand);
		world.getBlock(x+1, y).Update(x+1, y, world, rand);
		world.getBlock(x-1, y).Update(x-1, y, world, rand);
		world.getBlock(x, y+1).Update(x, y+1, world, rand);
		world.getBlock(x, y-1).Update(x, y-1, world, rand);
		world.getBlock(x+1, y+1).Update(x+1, y+1, world, rand);
		world.getBlock(x+1, y-1).Update(x+1, y-1, world, rand);
		world.getBlock(x-1, y+1).Update(x-1, y+1, world, rand);
		world.getBlock(x-1, y-1).Update(x-1, y-1, world, rand);
	}
}
