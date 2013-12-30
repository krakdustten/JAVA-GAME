package drawers;

//TODO comments

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Render 
{
	Graphics g;
	
	public Render(Graphics g)
	{
		this.g = g;
	}
	
	public void RenderBlock(Image image, float sx, float sy, float a)
	{
		image.setRotation(a);
		g.drawImage(image, sx - image.getCenterOfRotationX(), sy - image.getCenterOfRotationY());
		image.setRotation(0);
	}
	
	public void RenderBlockColor(Image image, int x, int y, Color color)
	{
		g.drawImage(image, x - image.getCenterOfRotationX(), y - image.getCenterOfRotationY(), color);
	}
}
