package blocks;

//TODO comments

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BlockDirt extends Block
{
	
	public BlockDirt(int id)
	{
		ID = id;
		try 
		{
			texture = new Image("res/block.png");
		} 
		catch (SlickException e)
		{
			e.printStackTrace();
		}
	}
}
