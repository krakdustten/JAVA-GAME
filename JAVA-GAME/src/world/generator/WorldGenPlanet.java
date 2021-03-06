package world.generator;

//TODO comments

import java.util.Random;

import main.Logger;
import world.World;

public class WorldGenPlanet extends WorldGen
{
	Random rand;
	
	SimplexNoise_octave sn1;
	SimplexNoise_octave sn2;
	SimplexNoise_octave sn3;
	
	final static double p1 = 500;
	final static double p2 = 200;
	final static double p3 = 10;
	final static double t1 = 300;
	final static double t2 = 10;
	final static double t3 = 3;
	
	public WorldGenPlanet(long seed)
	{
		rand = new Random(seed);
		seed = seed * 3;
		sn1 = new SimplexNoise_octave(seed);
		sn2 = new SimplexNoise_octave(seed+1);
		sn3 = new SimplexNoise_octave(seed+2);
		Logger.println("WorldGeneratorPlanet initialised");
	}
	
	public void genWorld(int width, int height, int mediumlevel, World world)
	{
		Logger.println("WorldGeneratorPlanet started worldgen");
		long mediumlevel2 = mediumlevel;
		
		for(double i = 0; i < (width * 64); i++)
		{
			double temp1 = sn1.noise(i/p1, 0)*t1;
			double temp2 = sn2.noise(i/p2, 0)*t2;
			double temp3 = sn3.noise(i/p3, 0)*t3;
			
			double hoogte = mediumlevel2 + temp1 + temp2 + temp3;
			
			for (int j = (int) hoogte; j < (height * 64); j++)
			{
				world.setBlockIdWhitoutUpdate((int) i, j, 1);
			}
		}
		Logger.println("WorldGeneratorPlanet world build");
		Logger.println("WorldGeneratorPlanet updateting textures");
		for(int i = 0; i < (width * 64); i++)
		{
			for(int j = 0; j < (height * 64); j++)
			{
				if(world.getBlockId(i,j) != 0)
				{
					world.getBlock(i, j).updateTexture(i, j, world, rand);
				}
			}
		}
		Logger.println("WorldGeneratorPlanet textures updateted");
		Logger.println("WorldGeneratorPlanet world generated");
	}
}
