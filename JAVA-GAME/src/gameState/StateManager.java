package gameState;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.MouseListener;

public class StateManager implements KeyListener, MouseListener
{
	private ArrayList<State> states;
	private int currentState = -1;
	
	public final int MAINMANUSTATE = 0;
	public final int PLAYSTATE = 1;
	
	public StateManager(GameContainer con)
	{
		Input input = con.getInput();
		input.addKeyListener(this);
		input.addMouseListener(this);
		
		states = new ArrayList<State>();
		states.add(new MainMenuState(this, con));
		states.add(new PlayState(this, con));
		
		Setstate(MAINMANUSTATE);
	}
	
	public void Setstate(int state)
	{
		if (currentState >= 0)
		{
			states.get(currentState).deinit();
		}
		currentState = state;
		states.get(currentState).init();
	}
	
	public void update(GameContainer con)
	{
		states.get(currentState).update();
	}
	
	public void draw(Graphics g)
	{
		states.get(currentState).draw(g);
	}

	public void inputEnded() {}
	public void inputStarted() {}
	public boolean isAcceptingInput() {return true;}
	public void setInput(Input arg0) {}

	public void mouseClicked(int button, int x, int y, int clickCount)
	{
	}

	public void mouseDragged(int oldx, int oldy, int newx, int newy) 
	{
	}

	public void mouseMoved(int oldx, int oldy, int newx, int newy)
	{
		states.get(currentState).MouseMove(oldx, oldy, newx, newy);
	}

	public void mousePressed(int button, int x, int y) 
	{
		states.get(currentState).MousePressed(button, x, y);
	}

	public void mouseReleased(int button, int x, int y) 
	{
		states.get(currentState).MouseReleased(button, x, y);
	}

	public void mouseWheelMoved(int change) 
	{
		states.get(currentState).MouseWheelMoved(change);
	}

	public void keyPressed(int key, char c) 
	{
		states.get(currentState).KeyPressed(key, c);
	}

	public void keyReleased(int key, char c)
	{
		states.get(currentState).KeyReleased(key, c);
	}
}
