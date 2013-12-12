package main;

import gameState.StateManager;

import org.lwjgl.opengl.Display;

import viewing.GameDisplay;

public class Game implements Runnable 
{
	private Boolean running = true;
	
	private long start;
	private long elapsed;
	private long wait;
	private final long targetTime = 1000 / 50;
	public double lastups;
	
	private StateManager sm;
	private GameDisplay display;
	
	public void run() 
	{
		running = true;
		
		init();
		
		start = System.nanoTime();
		while (running)
		{
			elapsed = System.nanoTime() - start;		
			wait = targetTime - elapsed / 1000000;
			if(wait <= 0)
			{
				lastups = (float) 1000/ (elapsed / 1000000);
				start = System.nanoTime();
				
				//System.out.println(lastups);
				
				update();
			}
			else
			{
				draw();
			}
			
			if (Display.isCloseRequested())
			{
				running = false;
			}
		}
		deinit();
	}

	private void init() 
	{
		display = new GameDisplay(800,600,"NO NAME",false,false);
		display.Init();
		sm = new StateManager();
	}

	private void update() 
	{
		sm.update();
	}

	private void draw() 
	{
		sm.draw();
		display.updateDisplay();
	}
	
	private void deinit() 
	{
		display.distroiDisplay();
	}
}
