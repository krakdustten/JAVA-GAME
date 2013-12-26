package world;

import blocks.Block;

public class Chunk 
{
	private int[][] blockID = new int[64][64];
	private int[][] blockTexture = new int[64][64];
	private World world;
	
	public Chunk(World world)
	{
		this.world = world;
		for(int i = 0; i < 64; i++)
		{
			for(int j = 0; j < 64; j++)
			{
				blockID[i][j] = 1;
			}
		}
	}
	
	public Block getBlock(int x, int y)
	{
		x = x % 64;
		y = y % 64;
		
		return world.playstate.blocklist.getBlockFromID(blockID[x][y]);
	}
	
	public int getBlockTexture(int x, int y)
	{
		x = x % 64;
		y = y % 64;
		
		
		return blockTexture[x][y];
	}
}
