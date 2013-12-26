package blocks;

//TODO comments

public class Blocklist 
{
	private Block[] blocks = new Block[16384];
	
	public Blocklist()
	{
		blocks[0] = new BlockAir(0);
		blocks[1] = new BlockDirt(1);
	}

	public Block getBlockFromID(int i) 
	{
		if (i < blocks.length)
		{
			return blocks[i];
		}
		return null;
	}
}
