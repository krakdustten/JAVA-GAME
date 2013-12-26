package drawers;

//TODO comments

import gameState.PlayState;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class NormalRenderer 
{
	private GameContainer gc;
	private PlayState playState;
	private Render render;
	
	public float x = 50;
	public float y = 50;
	
	private float zoom = 2.0f;
	
	public NormalRenderer(GameContainer gc, PlayState playState)
	{
		this.gc = gc;
		this.playState = playState;
		render = new Render(gc.getGraphics());
	}

	public void draw(Graphics g) 
	{
		int width = gc.getWidth();
		int height = gc.getHeight();
		g.translate(width/2, height/2);
		g.scale(zoom, zoom);
		g.translate(-width/2, -height/2);
		
		int blockx = (int)x;
		int blocky = (int)y;
		
		float xrest = x- (float)(int)x;		
		float yrest = y- (float)(int)y;	
		int blockdrawstartx = blockx - width/16 - 1;
		int blockdrawstarty = blocky - height/16 - 1;
		float screendrawstartx = -16 * xrest - 16;
		float screendrawstarty = -16 * yrest - 16;
		
		int blockwidth = width/16 + 3;
		int blockheight = height/16 + 3;
		
		for(int i = 0; i < blockwidth; i++)
		{
			for(int j = 0; j < blockheight; j++)
			{
				int drawblockx = blockdrawstartx + i;
				int drawblocky = blockdrawstarty + j;
				
				if (drawblockx <= 0 || drawblockx >= playState.getDrawWorld().width*64)
				{
				}
				else if(drawblocky <= 0 || drawblocky >= playState.getDrawWorld().height*64)
				{
				}
				else
				{
					playState.getDrawWorld().getBlock(blockdrawstartx + i
												, blockdrawstarty + j
										   ).draw(screendrawstartx + i*16
												, screendrawstarty + j*16
												, render);
				}
				
				
			}
		}
	}
}
