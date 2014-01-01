package world;

//TODO comments

import java.util.ArrayList;

import entity.Entity;
import blocks.Block;

public class Chunk 
{
	private int[][] blockID = new int[64][64];
	private int[][] blockTexture = new int[64][64];
	protected ArrayList<Entity> entitys = new ArrayList<Entity>();//the chunks entitys
	private World world;
	
	public Chunk(World world)
	{
		this.world = world;
		for(int i = 0; i < 64; i++)
		{
			for(int j = 0; j < 64; j++)
			{
				blockID[i][j] = 0;
			}
		}
	}
	
	public ArrayList<Entity> getEntitys()
	{
		return entitys;
	}
	
	public Block getBlock(int x, int y)
	{
		x = x % 64;
		y = y % 64;
		
		return world.playstate.blocklist.getBlockFromID(blockID[x][y]);
	}
	
	public void setBlockId(int i, int j, int blockID) 
	{
		this.blockID[i][j] = blockID;
	}
		
	public int getBlockTexture(int x, int y)
	{
		x = x % 64;
		y = y % 64;
		
		
		return blockTexture[x][y];
	}

	public void update() 
	{
		//TODO make block and entity updates
	}

	public int getTextureId(int x, int y) 
	{
		return blockTexture[x][y];
	}

	public int getBlockId(int x, int y) 
	{
		return blockID[x][y];
	}

	public void setBlockTextureId(int x, int y, int ID) 
	{
		blockTexture[x][y] = ID;
	}


}
