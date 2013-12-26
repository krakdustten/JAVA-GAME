package world;

import blocks.Block;
import gameState.PlayState;

public class Planet extends World
{
	
	
	public Planet(PlayState playstate)
	{
		this.playstate = playstate;
		width = 100;
		height = 100;
		chunks = new Chunk[width][height];
		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++)
			{
				chunks[i][j] = new Chunk(this);
			}
		}
	}
	
	public void update() {}
	public void deinit() {}
	
	public Block getBlock(int x, int y)
	{
		return chunks[x/64][y/64].getBlock(x%64, y%64);
	}
	
	public void getReadyForPlayerSpawn(int x, int y) {}
	public void spawnPlayer(int x, int y) {}
	public void generateOrLoadWorld(int x, int y, int size) {}
	
}
