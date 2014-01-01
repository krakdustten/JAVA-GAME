package blocks;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class BlockDirt extends Block
{
	/** make a new dirtblock whit its id
	 * @param id the blockid of the dirtblock
	 */
	public BlockDirt(int id)
	{
		ID = id;
		try 
		{sheet = new SpriteSheet("res/blockmap.png",32,32);} //load the spritesheet of the dirtblock
		catch (SlickException e)
		{e.printStackTrace();}
	}
}
