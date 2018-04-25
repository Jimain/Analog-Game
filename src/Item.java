import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;

public class Item {

	Point p;
	int itemSize = 40;
	int gW = 595;
	int gH = 800;
	int dirX = 3;
	int dirY = 3;
	boolean launch = true;
	GunType gunType;
	Image item;

	public Item( GunType gunT ) {
	
		gunType = gunT;
		
		int x = new Random().nextInt(gW - itemSize);
		int fx = Math.max(0, x);
		
		try {
			item = new Image("res/crate.jpg");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		

		item.draw(p.getX(), p.getY(), itemSize , itemSize, Color.yellow);
		

	}

}
