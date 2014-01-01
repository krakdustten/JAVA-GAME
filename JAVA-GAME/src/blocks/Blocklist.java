package blocks;

public class Blocklist 
{
	private Block[] blocks = new Block[16384];//all the blocks
	
	/** initialiseer the block and set them in the array
	 */
	public Blocklist()
	{
		blocks[0] = new BlockAir(0);
		blocks[1] = new BlockDirt(1);
	}

	/** get the block from its id
	 * @param id id of the block
	 * @return the block
	 */
	public Block getBlockFromID(int id) 
	{
		if (id < blocks.length)// if the id is witin the range of the array
		{
			return blocks[id];//return the selected block
		}
		return null;//else return null
	}
}
