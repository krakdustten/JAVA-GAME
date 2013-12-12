package gameState;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class StateManager
{
	private ArrayList<State> states;
	private int currentState = -1;
	
	public final int MAINMANUSTATE = 0;
	public final int PLAYSTATE = 1;
	
	public StateManager()
	{
		states = new ArrayList<State>();
		states.add(new MainMenuState(this));
		states.add(new PlayState(this));
		
		Setstate(MAINMANUSTATE);
	}
	
	public void Setstate(int state)
	{
		if (currentState >= 0)
		{
			states.get(currentState).deinit();
		}
		currentState = MAINMANUSTATE;
		states.get(currentState).init();
	}
	
	public void update()
	{
		while (Keyboard.next()) 
		{
			if (Keyboard.getEventKeyState())
			{
				states.get(currentState).KeyPressed(Keyboard.getEventKey());
			}
			else
			{
				states.get(currentState).KeyReleased(Keyboard.getEventKey());
			}
		}
		
		while (Mouse.next())
		{
			if (Mouse.getEventButton() == -1)
			{
				if (Mouse.getEventDWheel() == 0)
				{
					states.get(currentState).MouseMove(Mouse.getEventX(), Mouse.getEventY(), Mouse.getEventDX(), Mouse.getEventDY());
				}
				else
				{
					states.get(currentState).MouseWheelMoved(Mouse.getEventDWheel());
				}
			}
			else
			{
				if (Mouse.getEventButtonState())
				{
					states.get(currentState).MousePressed(Mouse.getEventButton());
				}
				else
				{
					states.get(currentState).MousePressed(Mouse.getEventButton());
				}
			}
		}
		states.get(currentState).update();
	}
	
	public void draw()
	{
		states.get(currentState).draw();
	}
}
