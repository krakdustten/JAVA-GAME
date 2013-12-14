package gui;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GuiButton extends GuiControl
{
	private int mousex,mousey;
	private boolean mouseClick = false;
	
	private Image im,imHover,imClick;
	
	public GuiButton(String file, String fileHover, String fileClick)
	{
		try 
		{
			im = new Image(file);
			imHover = new Image(fileHover);
			imClick = new Image(fileClick);
		} 
		catch (SlickException e) 
		{
			e.printStackTrace();
		}
		width = im.getWidth();
		height = im.getHeight();
	}
	
	public void init() {}
	
	public void update() {}
	
	public void draw(Graphics g) 
	{
		if(mousex > x && mousex < x + width)
		{
			g.drawImage(imHover, x, y);
		}
		else
		{
			g.drawImage(im, x, y);
		}
	}
	
	public void deinit() {}
	
	public void MouseMove(int x, int y, int dx, int dy)
	{
		mousex = x;
		mousey = y;
	}
	
	public void MousePressed(int key)
	{
		if(key == 0)
		{
			mouseClick = true;
		}
	}
	
	public void MouseReleased(int key)
	{
		if(key == 0)
		{
			mouseClick = false;
		}
	}
}
