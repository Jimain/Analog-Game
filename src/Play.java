
import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.InputListener;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Play extends BasicGameState implements KeyListener {
	Plane plane;
	Background background;
	int pcounter = 0;
	int bcounter = 0;
	int itcounter = 0;
	int ecounter = 0;
	int dcounter = 0;
	int itemcounter = 0;
	boolean activeKey = false;
	boolean isPressed = false;
	int enemyTime;
	int itemTime;
	int enemyMax = 2000;
	int itemMax = 10000;
	ArrayList<Item> items = new ArrayList<Item>();
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	StateBasedGame sbg;

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {

		sbg = arg1;
		background = new Background();
		plane = new Plane();
		getEnemyTime();
		getItemTime();

	}
	public void getItemTime() {

		itemTime = new Random().nextInt(itemMax);

	}

	public void createItem() {

		getItemTime();
		items.add(new Item(GunType.DOUBLEB));

	}

	public void getEnemyTime() {

		enemyTime = new Random().nextInt(enemyMax);

	}

	public void createEnemy() {

		getEnemyTime();
		enemies.add(new Enemy(595));

	}

	public void keyPressed(int key, char c) {
		plane.updateDirection(key);
		activeKey = true;

	}

	public void keyReleased(int key, char c) {
		activeKey = false;

	}

	public Boolean eat(Point p1, Point p2, int p1Height, int p1Width, int p2Height, int p2Width) {
		Rectangle r1 = new Rectangle(p1.getX(), p1.getY(), p1Width, p1Height);
		Rectangle r2 = new Rectangle(p2.getX(), p2.getY(), p2Width, p2Height);

		if (r1.intersects(r2)) {
			return true;
		}

		return false;

	}

	@Override
	public void update(GameContainer gc, StateBasedGame bg, int delta) throws SlickException {

		if (pcounter > 200) {
			plane.update();
			pcounter = 0;
		}

		if (bcounter > 4) {
			background.update();
			bcounter = 0;
		}

		if (itcounter > 10) {
			if (activeKey) {
				plane.updateLocation();
			}

			for (int i = 0; i < enemies.size(); i++) {
				enemies.get(i).updateLocation();
				if (eat(enemies.get(i).p, plane.p, enemies.get(i).enemyHeight, enemies.get(i).enemyWidth, plane.pHeight,
						plane.pWidth)) {
					plane.dead();
					dcounter = 0;
				}
				if (enemies.get(i).outOfBounds()) {
					enemies.remove(i);
				}
			}

			for (int i = 0; i < items.size(); i++) {
				Item it = items.get(i);
				it.update();
				if (eat(it.p, plane.p, it.itemSize, it.itemSize, plane.pHeight, plane.pWidth)) {
					plane.eatItem(it.gunType);
					items.remove(i);
				}
			}
			itcounter = 0;
		}

		if (ecounter > enemyTime) {
			createEnemy();

			ecounter = 0;
		}
		if ( itemcounter > itemTime) {
			createItem();
			
			itemcounter = 0;
		}

		for (int i = 0; i < plane.bullets.size(); i++) {
			Bullet bp = plane.bullets.get(i);
			for (int e = 0; e < enemies.size(); e++) {
				Enemy ep = enemies.get(e);

				if (eat(bp.p, ep.p, bp.bH, bp.bW, ep.enemyHeight, ep.enemyWidth)) {
					enemies.remove(e);
					plane.bullets.remove(i);
				}
			}

		}
		if (plane.IAmDead && dcounter > 1000) {
	
			gameover();

		}
		itemcounter += delta;
		dcounter += delta;
		pcounter += delta;
		bcounter += delta;
		itcounter += delta;
		ecounter += delta;

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {

		background.render(g);
		for (int i = 0; i < items.size(); i++) {
			items.get(i).render(g);
		}
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).render(g);
		}
		plane.render(g);

	}

	public void gameover() {

		sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());

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
