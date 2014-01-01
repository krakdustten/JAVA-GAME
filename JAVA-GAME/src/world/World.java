package world;

//TODO comments
//TODO make different methods for the block te setten by world generation

import blocks.Block;
import gameState.PlayState;

public abstract class World 
{
	public int width = 0;//the width of the world in chunks
	public int height = 0;//the height of the world in chunks
	public PlayState playstate;//the super class
	protected Chunk[][] chunks;//the chunks in the world
	
	/**update the world*/
	public abstract void update();
	/**save the world*/
	public abstract void deinit();
	
	/**get a block in the world
	 * @param x the x coordinate of the block
	 * @param y the y coordinate of the block*/
	public abstract Block getBlock(int x, int y);
	
	
	
	/**make the world ready to spawn the player
	 * @param x the x coordinate where the player wants to spawn
	 * @param y the y coordinate where the player wants to spawn*/
	public abstract void getReadyForPlayerSpawn(int x, int y);
	/**check of the world is ready for the player
	 * @param x the x coordinate where the player spawns
	 * @param y the y coordinate where the player spawns*/
	public abstract void spawnPlayer(int x, int y);
	/**generate or load the chunks around the point givin.
	 * This is generated in a square
	 * @param x the x coordinate of the chunk that needs to be loaded
	 * @param y the y coordinate of the chunk that needs to be loaded
	 * @param size how much chunks that will be loaded around the chunk*/
	public abstract void generateOrLoadWorld(int x, int y, int size);
	
	public abstract void setBlockIdWhitoutUpdate(int x, int y, int ID);
	public abstract void setBlockId(int x, int y, int ID);
	
	public abstract int getTextureId(int i, int j) ;
	public abstract int getBlockId(int i, int j);
	public abstract void setBlockTextureId(int i, int j, int k) ;
}
