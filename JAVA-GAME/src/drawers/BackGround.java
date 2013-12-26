package drawers;

//TODO comments

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class BackGround 
{
	//private Image normalBackground;
	private Color backgroundcolor;
	private GameContainer gc;
	
	public BackGround(GameContainer gc)
	{
		this.gc = gc;
	}
	
	public void SetBackGroundColor(Color color)
	{
		backgroundcolor = color;
	}
	
	public void SetNormalBackground(Image image)
	{
		//normalBackground = image;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(backgroundcolor);
		g.fillRect(0, 0, gc.getWidth(), gc.getHeight());
		//g.drawImage(normalBackground, 0, 0);
	}
}
