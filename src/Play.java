import java.awt.Point;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.InputListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState implements InputListener {
	private int pHeight = 20;
	private int pWidth = 50;
	Point p = new Point();
	public int mvtExtent = 30;

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub

		// create new point for plane location
		p = new Point();
		p.x = 350;
		p.y = 350;
		System.out.println("Init");
	}

	public void keyPressed(int key, char c) {
		System.out.println(key);
		switch (key) {
		case 203:
			p.x -= mvtExtent;
			break;
		case 200:
			p.y -= mvtExtent;
			break;
		case 205:
			p.x += mvtExtent;
			break;
		case 208:
			p.y += mvtExtent;
			break;
		}

		if (p.x >= 750) {
			p.x = 750;
		}
		if (p.x <= 0) {
			p.x = 0;
		}
		if (p.y >= 750) {
			p.y = 750;
		}
		if (p.y <= 0) {
			p.y = 0;
		}
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		// TODO Auto-generated method stub

		// render rect in position of point
		g.fillRect(p.x, p.y, pWidth, pHeight);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

}
