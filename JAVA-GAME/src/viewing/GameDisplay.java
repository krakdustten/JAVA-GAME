package viewing;

import java.nio.ByteBuffer;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class GameDisplay 
{
	public boolean fullscreen = false;
	public ByteBuffer[] icon = null;
	public boolean resizable = false;
	public String title = null;
	public boolean vsync = false;
	
	public int width = 800;
	public int height = 600;
	
	/**
	 * Makes a display thats 800 by 600
	 */
	public GameDisplay()
	{
		this(800,600);
	}
	
	/**
	 * Makes a display with a width and a height
	 * @param <b>width:</b> the width of the screen
	 * @param <b>height:</b> the height of the screen
	 */
	public GameDisplay(int width, int height)
	{
		this(width,height,"",false,false);
	}
	
	/**
	 * Makes a display thats full-screen with a title and an Icon
	 * @param <b>fullscreen:</b> is it full-screen
	 * @param <b>title:</b> the title of the screen
	 * @param <b>resizable:</b> can the window be resized
	 * @param <b>vsync:</b> sync every frame
	 * @param <b>icon:</b> the icon of the screen
	 */
	public GameDisplay(boolean fullscreen,String title,boolean resizable,boolean vsync, ByteBuffer[] icon)
	{
		this(0,0,title,resizable,vsync,icon);
	}
	
	/**
	 * Makes a display with a width, a height and the title
	 * @param <b>width:</b> the width of the screen
	 * @param <b>height:</b> the height of the screen
	 * @param <b>title:</b> the title of the screen
	 * @param <b>resizable:</b> can the window be resized
	 * @param <b>vsync:</b> sync every frame
	 */
	public GameDisplay(int width, int height,String title,boolean resizable,boolean vsync)
	{
		this(width,height,title,resizable,vsync,null);
	}
	
	/**
	 * Makes a display with a width, a height, the title and an icon
	 * @param width the width of the screen
	 * @param height the height of the screen
	 * @param title the title of the screen
	 * @param resizable can the window be resized
	 * @param vsync sync every frame
	 * @param icon the icon of the screen
	 */
	public GameDisplay(int width, int height,String title,boolean resizable,boolean vsync, ByteBuffer[] icon)
	{
		this.width = width;
		this.height = height;
		this.title = title;
		this.resizable = resizable;
		this.vsync = vsync;
		this.icon = icon;
	}
	
	/**
	 * creates the display and shows it on the screen
	 * @return the gamedisplay it self
	 */
	public GameDisplay Init()
	{
		try 
		{
			update();
			Display.create();
			
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();
			GL11.glOrtho(0, width, 0, height, 1, -1);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glLoadIdentity();
		} 
		catch (LWJGLException e)
		{
			e.printStackTrace();
		}
		return this;
	}
	
	/**
	 * sets the displays width and height
	 * @param width the new width of the screen
	 * @param height the new height of the screen
	 * @return the gamedisplay itself
	 */
	public GameDisplay UpdateSize(int width, int height)
	{
		this.width = width;
		this.height = height;
		return this;
	}
	
	/**
	 * sets the other parameters of the display
	 * @param fullscreen is the display full-screen
	 * @param title the new title of the display
	 * @param resizable is the display resizable
	 * @param vsync is vsync enabled
	 * @param icon the new icon of the display
	 * @return the gamedisplay itself
	 */
	public GameDisplay UpdateModifires(boolean fullscreen,String title,boolean resizable,boolean vsync, ByteBuffer[] icon)
	{
		this.title = title;
		this.resizable = resizable;
		this.vsync = vsync;
		this.icon = icon;
		update();
		
		return this;
	}
	
	/**
	 * updates the display
	 * @return the gamedisplay itself
	 */
	public GameDisplay update()
	{
		try 
		{
			Display.setDisplayMode(new DisplayMode(width,height));
			Display.setFullscreen(fullscreen);
			if (icon != null)
				Display.setIcon(icon);
			Display.setResizable(resizable);
			Display.setTitle(title);
			Display.setVSyncEnabled(vsync);
		} 
		catch (LWJGLException e)
		{
			e.printStackTrace();
		}
		return this;
	}
	
	/**
	 * creates the display
	 * @return the gamedisplay itself
	 */
	public GameDisplay createDisplay()
	{
		try 
		{
			Display.create();
		} 
		catch (LWJGLException e)
		{
			e.printStackTrace();
		}
		return this;
	}
	
	/**
	 * updates the display
	 * @return the gamedisplay itself
	 */
	public GameDisplay updateDisplay()
	{
		Display.update();
		return this;
	}
	
	public GameDisplay distroiDisplay()
	{
		Display.destroy();
		return this;
	}
}
