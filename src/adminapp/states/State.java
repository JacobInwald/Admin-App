package adminapp.states;

import java.awt.Graphics;

public abstract class State {

	
	private static State currentState = null;
	
	public abstract void tick();
	
	public abstract void render(Graphics g);

	public static State getCurrentState() {
		return currentState;
	}

	public static void setCurrentState(State currentState) {
		State.currentState = currentState;
	}

	
}
