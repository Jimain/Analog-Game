import java.awt.Point;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.InputListener;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState implements KeyListener {
	Plane plane;
	Background background;
	Item item;
	Enemy enemy;
	int pcounter = 0;
	int bcounter = 0;
	int itcounter = 0;
	int ecounter = 0;
	boolean activeKey = false;
	boolean isPressed = false;
	

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		
		background = new Background();
		plane = new Plane();
		item = new Item();
		enemy = new Enemy();


	}

	public void keyPressed(int key, char c) {
		plane.updateDirection(key);
		activeKey = true;

	}
	public void keyReleased(int key, char c) {
		activeKey = false;

	}

	@Override
	public void update(GameContainer gc, StateBasedGame bg, int delta) throws SlickException {
		
		pcounter += delta;
		
		if ( pcounter > 200 ) {
		plane.update();
		pcounter = 0;
		}
		
		bcounter += delta;
		
		if ( bcounter > 4 ) {
			background.update();
			bcounter = 0;	
		}
		
		itcounter += delta;
		
		if ( itcounter > 10) {
			if(activeKey) {
				plane.updateLocation();
				}
			item.update();	
			itcounter = 0;
		}
		
		ecounter += delta;
		
		if( ecounter > 4) {
			enemy.updateLocation();
			ecounter = 0;
		}
		if ( plane.eat() ) {
			
		}
		
		

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {

		background.render(g);
		plane.render(g);
		item.render(g); 
		enemy.render(g);

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

	public void mouseClicked(int button, int x, int y,int clickCount) {
	
		isPressed = false;
	}
	public void mousePressed( int button, int x , int y) {
	
		isPressed = true;
	}
	public void mouseReleased( int button, int x , int y) {

		isPressed = false;
	}
	public void mouseDragged( int oldx, int oldy, int newx, int newy) {
		
	}

}
