import java.awt.Point;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.InputListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState implements InputListener {
	Plane plane;
	Background background;
	Item item;

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		background = new Background();
		plane = new Plane();
		item = new Item();

	}

	public void keyPressed(int key, char c) {
		plane.updateLocation(key);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame bg, int delta) throws SlickException {

		if ( delta == 200 ) {
		plane.update();
		}
		
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {

		background.render(g);
		plane.render(g);
		item.render(g); 

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}
}
