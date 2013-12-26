package world;

import blocks.Block;
import gameState.PlayState;

public abstract class World 
{
	public int width = 0;
	public int height = 0;
	public PlayState playstate;
	protected Chunk[][] chunks;
	
	public abstract void update();
	public abstract void deinit();
	
	public abstract Block getBlock(int x, int y);
	
	public abstract void getReadyForPlayerSpawn(int x, int y);
	public abstract void spawnPlayer(int x, int y);
	public abstract void generateOrLoadWorld(int x, int y, int size);
}
