package drawers;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class BackGround 
{
	private Image normalBackground;//the backgroundimage
	private Color backgroundcolor;//the color of the background
	private GameContainer gc;//the container of the game
	
	/** Make a new background
	 * @param gc the container where the background is drawn in
	 */
	public BackGround(GameContainer gc)
	{this.gc = gc;}
	
	/** Set the color of the background
	 * @param color the new backgroundcolor
	 */
	public void SetBackGroundColor(Color color)
	{backgroundcolor = color;}
	
	/** set the normal backgroundimage
	 * @param image the new backgroundimage
	 */
	public void SetNormalBackgroundImage(Image image)
	{normalBackground = image;}
	
	/** draw the background
	 * @param g the graphics
	 */
	public void draw(Graphics g)
	{
		g.setColor(backgroundcolor);//set the backgroundimage
		g.fillRect(0, 0, gc.getWidth(), gc.getHeight());//draw the backgrund
		if(normalBackground != null)//if there is a background
		{g.drawImage(normalBackground, 0, 0);}//draw the backgroundimage
	}
}
