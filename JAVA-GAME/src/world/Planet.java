package world;

//TODO comments

import world.generator.WorldGenPlanet;
import blocks.Block;
import gameState.PlayState;

public class Planet extends World
{
	private int loadchunkspointx = 0;
	private int loadchunkspointy = 0;
	private int loadchunksrange = 1;
	
	public Planet(PlayState playstate)
	{
		this.playstate = playstate;
		width = 32;
		height = 20;
		chunks = new Chunk[width][height];
		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++)
			{
				chunks[i][j] = new Chunk(this);
			}
		}
		WorldGenPlanet worldgen = new WorldGenPlanet(5068);
		worldgen.genWorld(width, height, 600, this);
	}
	
	public void update() 
	{
		int loadwidth = loadchunksrange * 2;
		int loadstartx = loadchunkspointx - loadchunksrange;
		int loadstarty = loadchunkspointy - loadchunksrange;
		
		if(loadstartx < 0)
		{
			loadstartx = 0;
		}
		else if((loadstartx + loadwidth) >= width)
		{
			loadstartx = width - loadwidth;
		}
		
		if (loadstarty < 0)
		{
			loadstarty = 0;
		}
		else if((loadstarty + loadwidth) >= height)
		{
			loadstarty = height - loadwidth;
		}
		for (int i = loadstartx; i <= (loadwidth + loadstartx); i++)
		{
			for (int j = loadstarty; j <= (loadwidth + loadstarty); j++)
			{
				chunks[i][j].update();
			}
		}
	}
	
	public void deinit() {}
	
	public Block getBlock(int x, int y)
	{
		if(x>=0 && y>=0 && x<(width*64) && y<(height*64))
			return chunks[x/64][y/64].getBlock(x%64, y%64);
		return playstate.blocklist.getBlockFromID(0);
	}
	
	public void setBlockId(int x, int y, int ID)
	{
		chunks[x/64][y/64].setBlockId(x%64, y%64, ID);
	}
	
	public void getReadyForPlayerSpawn(int x, int y) {}
	public void spawnPlayer(int x, int y) {}
	public void generateOrLoadWorld(int x, int y, int size) {}

	@Override
	public int getTextureId(int x, int y) 
	{
		return chunks[x/64][y/64].getTextureId(x%64, y%64);
	}

	public int getBlockId(int x, int y) 
	{
		if(x>=0 && y>=0 && x<(width*64) && y<(height*64))
			return chunks[x/64][y/64].getBlockId(x%64,y%64);
		return 0;
	}

	public void setBlockTextureId(int x, int y, int ID) 
	{
		if(x>=0 && y>=0 && x<(width*64) && y<(height*64))
			chunks[x/64][y/64].setBlockTextureId(x%64,y%64,ID);
	}
}
