
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Transform;

public class Bullet {

	int fW = 800;
	int fH = 800;
	int bW = 2;
	int bH = 6;
	int speed = 1;
	Point p;
	BD bd;
	GameHelper GH = new GameHelper();
	Image bulletImage;

	Color c = new Color(Color.yellow);

	public Bullet(int x, int y, BD bulletD) {
		
		try {
			bulletImage = new Image("res/aircrafts.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p = new Point(x, y);
		bd = bulletD;

	}

	public void render(Graphics g) {

		if (bd == BD.LEFT) {
			p.setX(p.getX() - speed);

		}
		if (bd == BD.RIGHT) {
			p.setX(p.getX() + speed);
		}

		bulletImage.getSubImage(500, 30, 10, 26).draw(p.getX() , p.getY());
		
		p.setY(p.getY() - speed);

	}

	public Boolean outOfBound() {

		return GH.outOfBound(p);

	}

}
