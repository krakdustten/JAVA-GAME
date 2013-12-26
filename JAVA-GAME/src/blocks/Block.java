package blocks;

//TODO comments

import org.newdawn.slick.Image;

import drawers.Render;

public abstract class Block 
{
	protected Image texture;
	protected int ID;
	
	public void draw(float sx, float sy, Render render)
	{
		render.RenderBlock(texture, sx, sy);
	}
}
