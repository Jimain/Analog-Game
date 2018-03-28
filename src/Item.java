import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Point;

public class Item {

	Point p;
	int itemSize = 30;
	int gW = 595;
	int gH = 800;
	int dirX = 3;
	int dirY = 3;
	boolean launch = true;

	public Item() {

		int x = new Random().nextInt(gW - itemSize);
		int fx = Math.max(0, x);

		p = new Point(fx, -itemSize);

	}

	public void update() {

		float x = p.getX();
		float y = p.getY();
		int rightWall = gW - itemSize;
		int leftWall = 0;
		int topWall = 0;
		int bottomWall = gH - itemSize;

		if (x > 0 && y > 0) {
			launch = false;
		}

		if (x >= rightWall || x <= leftWall) {
			dirX *= -1;
		}
		if (y >= bottomWall || !launch && y <= topWall) {
			dirY *= -1;
		}

		p.setY(y + dirY);
		p.setX(x + dirX);

	}

	public void render(Graphics g) {

		g.setColor(Color.orange);
		g.fillRect(p.getX(), p.getY(), itemSize, itemSize);

	}

}
