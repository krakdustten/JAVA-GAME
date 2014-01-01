package blocks;

import java.util.Random;

import org.newdawn.slick.SpriteSheet;

import world.World;
import drawers.Render;

public abstract class Block 
{
	protected SpriteSheet sheet;//the blocks spritesheet
	protected int ID;//the ID of the block
	
	/** draw the block at the sx and sy
	 * @param sx the screens x coordinate
	 * @param sy the screens y coordinate
	 * @param render the blockrenderer
	 * @param textureId the id of the texture
	 */
	public void draw(float sx, float sy, Render render, int textureId)
	{
		//render the block
		render.RenderBlock(sheet.getSprite(textureId%4, textureId/16), sx, sy, ((textureId/4)%4)*90);
	}
	
	/** update the block
	 * @param x the x coordinate of the block
	 * @param y the y coordinate of the block
	 * @param world the world the block is in
	 * @param rand the random
	 */
	public void update(int x, int y, World world, Random rand){}

	/** update the texture of the block
	 * @param x the x coordinate of the block
	 * @param y the y coordinate of the block
	 * @param world the world the block is in
	 * @param rand the random
	 */
	public void updateTexture(int x, int y, World world,Random rand) 
	{
		//all the different blocks around the x and y coordinate
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
		
		//set all dese vars
		if(world.getBlockId(x+1, y) != 0){temp1++;right = true;}
		if(world.getBlockId(x-1, y) != 0){temp1++;left = true;}
		if(world.getBlockId(x, y+1) != 0){temp1++;up = true;}
		if(world.getBlockId(x, y-1) != 0){temp1++;down = true;}
		if(world.getBlockId(x+1, y+1) != 0){temp2++;upright = true;}
		if(world.getBlockId(x-1, y+1) != 0){temp2++;upleft = true;}
		if(world.getBlockId(x+1, y-1) != 0){temp2++;downright = true;}
		if(world.getBlockId(x-1, y-1) != 0){temp2++;downleft = true;}

		int textureId = 0;//the textureId
		int rotate = 0;//the rotation of the block
		
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

	/** update the texture of the block at x and y and all the block around it
	 * @param x the x coordinate of the source block
	 * @param y the y coordinate of the source block
	 * @param world the world the blocks are in
	 * @param rand the random
	 */
	public void UpdateNeibeurstextures(int x, int y, World world, Random rand) 
	{
		//update the texture of the block itseft and blocks around it
		updateTexture(x,y,world,rand);
		world.getBlock(x+1, y).updateTexture(x+1, y, world, rand);
		world.getBlock(x-1, y).updateTexture(x-1, y, world, rand);
		world.getBlock(x, y+1).updateTexture(x, y+1, world, rand);
		world.getBlock(x, y-1).updateTexture(x, y-1, world, rand);
		world.getBlock(x+1, y+1).updateTexture(x+1, y+1, world, rand);
		world.getBlock(x+1, y-1).updateTexture(x+1, y-1, world, rand);
		world.getBlock(x-1, y+1).updateTexture(x-1, y+1, world, rand);
		world.getBlock(x-1, y-1).updateTexture(x-1, y-1, world, rand);
	}
}
