package world.generator;

//TODO comments

import world.World;

public abstract class WorldGen 
{
	public abstract void genWorld(int width, int height, int waterlevel, World world);
}
