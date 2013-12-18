package gui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

public class GuiButton extends GuiControl
{
	private int mousex,mousey;
	private boolean mouseClick = false;
	private int time = -1;
	private int ID;
	private ActionListener action;
	
	private Image im,imHover,imClick;
	public String text = "";
	TrueTypeFont ttf;
	
	public GuiButton(String file, String fileHover, String fileClick, String text, String fontFile, int ID, ActionListener action)
	{
		this.ID = ID;
		this.action = action;
		
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
		
		this.text = text;
		try 
		{
			Font font = Font.createFont(Font.TRUETYPE_FONT, ResourceLoader.getResourceAsStream(fontFile));
			font = font.deriveFont(15f);
			ttf = new TrueTypeFont(font, true);
		} 
		catch (FontFormatException | IOException e)
		{
			e.printStackTrace();
		}
	    
	}
	
	public void setPos(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void init() {}
	
	public void update() 
	{
		if (time >= 0)
		{
			if (time <=0)
			{
				action.Action(ID);
				time = -1;
			}
			else
			{
				time--;
			}
		}
	}
	
	public void draw(Graphics g) 
	{
		if(mousex > x && mousex < x + width && mousey > y && mousey < y + height)
		{
			if (mouseClick)
			{
				g.drawImage(imClick, x, y);
				if (time < 0)
					time = 20;
			}
			else
			{
				g.drawImage(imHover, x, y);
			}
		}
		else
		{
			g.drawImage(im, x, y);
		}
		
		ttf.drawString(x + (width-ttf.getWidth(text))/2, y + (height - ttf.getHeight())/2, text);
	}
	
	public void deinit() {}
	
	public void MouseMove(int x, int y, int dx, int dy)
	{
		mousex = x;
		mousey = y;
	}
	
	public void MousePressed(int key,int x, int y)
	{
		mousex = x;
		mousey = y;
		if(key == 0)
		{
			mouseClick = true;
		}
	}
	
	public void MouseReleased(int key,int x, int y)
	{
		mousex = x;
		mousey = y;
		if(key == 0)
		{
			mouseClick = false;
		}
	}
}
