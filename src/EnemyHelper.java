import org.newdawn.slick.geom.Point;

public class EnemyHelper {

	int speed = 2;

	public EnemyHelper() {

	}

	public void right(Point pt) {
		pt.setX(pt.getX() + speed);

	}

	public void left(Point pt) {
		pt.setX(pt.getX() - speed);

	}

	public void up(Point pt) {
		pt.setY(pt.getY() - speed);
	}

	public void down(Point pt) {
		pt.setY(pt.getY() + speed);
	}
}
