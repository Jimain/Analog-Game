
import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Point;

public class Enemy {

	Point p;
	EnemyHelper eHelper = new EnemyHelper();
	int counter = 0;
	GameHelper GH = new GameHelper();
	Image enemy;
	int enemyWidth = 0;
	int enemyHeight = 0;
	int type = 0;

	public Enemy(int gw) {

		try {
			enemy = new Image("res/Enemy.png");
			enemyWidth = enemy.getWidth() / 3;
			enemyHeight = enemy.getHeight() / 3;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int randomnum = new Random().nextInt(gw);

		p = new Point(randomnum, 0);
		type = new Random().nextInt(2);

	}

	public void render(Graphics g) {

		enemy.draw(p.getX(), p.getY(), enemyWidth, enemyHeight);

	}

	public void updateLocation() {

		counter++;

		if (type == 0) {
			path1();
		}
		if (type == 1) {
			path2();
		}
		if (type == 2) {
			path3();
		}

	}

	public void path1() {

		eHelper.down(p);

		if (counter < 50) {
			eHelper.right(p);
		} else if (counter < 100) {
			eHelper.left(p);
			if (counter == 99) {
				counter = 0;
			}
		}

	}

	public void path2() {

	}

	public void path3() {

	}

	public boolean outOfBounds() {

		return GH.bottomOutofBound(p);

	}

}
