import java.awt.Point;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Transform;

public class Bullet {

	int fW = 800;
	int fH = 800;
	int bW = 2;
	int bH = 6;
	int speed = 1;
	Point p = new Point();
	BD bd;

	Color c = new Color(Color.yellow);

	public Bullet(int x, int y, BD bulletD) {

		p = new Point();
		p.x = x;
		p.y = y;
		bd = bulletD;

	}

	public void render(Graphics g) {

		if (bd == BD.LEFT) {
			p.x -= speed;

		}
		if (bd == BD.RIGHT) {
			p.x += speed;
		}

		Rectangle r = new Rectangle(p.x, p.y, bW, bH);
		g.setColor(c);
		g.fill(r);
		p.y -= speed;

	}

	public Boolean outOfBound() {

		if (p.x >= 800) {
			return true;
		}
		if (p.x <= 0) {
			return true;
		}
		if (p.y <= 0) {
			return true;
		}
		return false;
	}

}
