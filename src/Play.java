
import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.InputListener;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState implements KeyListener {
	Plane plane;
	Background background;
	Enemy enemy;
	int pcounter = 0;
	int bcounter = 0;
	int itcounter = 0;
	int ecounter = 0;
	boolean activeKey = false;
	boolean isPressed = false;
	ArrayList<Item> items = new ArrayList<Item>();
	ArrayList<Enemy>enemies = new ArrayList<Enemy>();

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {

		background = new Background();
		plane = new Plane();
		items.add(new Item());
		enemies.add(new Enemy());
		System.out.println("2 times");
		

	}

	public void keyPressed(int key, char c) {
		plane.updateDirection(key);
		activeKey = true;

	}

	public void keyReleased(int key, char c) {
		activeKey = false;

	}

	public Boolean eat(Point p1, Point p2, int p1Height, int p1Width, int p2Height, int p2Width) {
		Boolean eat = false;

		if (p1.getX() < p2.getX() + p1Width && p1.getX() > p2.getX() && p1.getY() > p2.getY()
				&& p1.getY() < p2.getY() + p1Height) {
			eat = true;
		}
		if (p2.getX() > p1.getX() && p2.getX() < p1.getX() + p2Width && p2.getY() > p1.getY()
				&& p2.getY() < p1.getY() + p2Height) {
			eat = true;
		}
		return eat;

	}

	@Override
	public void update(GameContainer gc, StateBasedGame bg, int delta) throws SlickException {

		pcounter += delta;

		if (pcounter > 200) {
			plane.update();
			pcounter = 0;
		}

		bcounter += delta;

		if (bcounter > 4) {
			background.update();
			bcounter = 0;
		}

		itcounter += delta;

		if (itcounter > 10) {
			if (activeKey) {
				plane.updateLocation();
			}
			
			for (int i = 0; i < enemies.size(); i++) {
				enemies.get(i).updateLocation();
				if (eat( enemies.get(i).p, plane.p, enemies.get(i).enemySize,  enemies.get(i).enemySize, plane.pHeight, plane.pWidth)) {
					System.out.println("DEAD");
				}
			}
			
			for (int i = 0; i < items.size(); i++) {
				items.get(i).update();
				if (eat( items.get(i).p, plane.p, items.get(i).itemSize,  items.get(i).itemSize, plane.pHeight, plane.pWidth)) {
					items.remove(i);
				}
			}
			itcounter = 0;
		}

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {

		background.render(g);
		for (int i = 0; i < items.size(); i++) {
			items.get(i).render(g);
		}
		for ( int i = 0; i< enemies.size(); i++	) {
			enemies.get(i).render(g);
		}
		plane.render(g);

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

	public void mouseClicked(int button, int x, int y, int clickCount) {

		isPressed = false;
	}

	public void mousePressed(int button, int x, int y) {

		isPressed = true;
	}

	public void mouseReleased(int button, int x, int y) {

		isPressed = false;
	}

	public void mouseDragged(int oldx, int oldy, int newx, int newy) {

	}

}
