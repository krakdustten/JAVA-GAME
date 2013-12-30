package blocks;

//TODO comments

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class BlockDirt extends Block
{
	
	public BlockDirt(int id)
	{
		ID = id;
		try 
		{
			sheet = new SpriteSheet("res/blockmap.png",32,32);
		} 
		catch (SlickException e)
		{
			e.printStackTrace();
		}
	}
}
