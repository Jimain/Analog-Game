
import java.util.ArrayList;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Point;

public class Enemy {

	Point p;
	int enemySize = 30;
	EnemyHelper eHelper = new EnemyHelper();
	int counter = 0;

	public Enemy() {

		p = new Point(0, 0);

	}

	public void render(Graphics g) {

		g.setColor(Color.pink);
		g.fillRect(p.getX(), p.getY(), enemySize, enemySize);

	}

	public void updateLocation() {

		counter++;

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

}
