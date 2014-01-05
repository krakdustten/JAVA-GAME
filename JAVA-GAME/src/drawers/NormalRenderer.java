package drawers;

//TODO comments

import entity.Entity;
import gameState.PlayState;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class NormalRenderer 
{
	private GameContainer gc;
	private PlayState playState;
	private Render render;

	private Entity entity;
	
	private float zoom = 1.0f;
	
	public float screendrawstartx;
	public float screendrawstarty;
	public int blockdrawstartx;
	public int blockdrawstarty;
	
	public NormalRenderer(GameContainer gc, PlayState playState, Entity entity)
	{
		this.gc = gc;
		this.playState = playState;
		render = new Render(gc.getGraphics());
		this.entity = entity;
	}

	public void draw(Graphics g) 
	{
		float x = entity.getX();
		float y = entity.getY();
		
		int width = gc.getWidth();
		int height = gc.getHeight();
		g.translate(width/2, height/2);
		g.scale(zoom, zoom);
		g.translate(-width/2, -height/2);
		width = (int) (width / zoom);
		height = (int) (height / zoom);
		
		float xrest = x- (float)(int)x;		
		float yrest = y- (float)(int)y;	

		screendrawstartx = (-32 * xrest - 32) -(((1 / zoom)-1)*gc.getWidth())/2;
		screendrawstarty = (-32 * yrest - 32) -(((1 / zoom)-1)*gc.getHeight())/2;
		
		int blockx = (int)x;
		int blocky = (int)y;
		blockdrawstartx = blockx - width/64 - 1;
		blockdrawstarty = blocky - height/64 - 1;
		
		int blockwidth = width/32 + 3;
		int blockheight = height/32 + 3;

		
		//render blocks
		
		
		for(int i = 0; i < blockwidth; i++)
		{
			for(int j = 0; j < blockheight; j++)
			{
				int drawblockx = blockdrawstartx + i;
				int drawblocky = blockdrawstarty + j;
				
				if(drawblocky < 0 || drawblocky >= playState.getDrawWorld().height*64)
				{
				}
				else
				{
					playState.getDrawWorld().getBlock(drawblockx, drawblocky)
					.draw(screendrawstartx + i*32, screendrawstarty + j*32, render
							, playState.getDrawWorld().getTextureId(drawblockx, drawblocky));
				}
			}
		}
		
		entity.draw((entity.getX() - (float)blockdrawstartx)*32 + screendrawstartx,
				(entity.getY() - (float)blockdrawstarty)*32 + screendrawstarty,render,g);
	}
}
