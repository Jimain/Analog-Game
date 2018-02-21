import java.awt.Point;

import org.newdawn.slick.Graphics;

public class Plane {
	private int pHeight = 20;
	private int pWidth = 50;
	Point p = new Point();
	public int mvtExtent = 30;
	
	public Plane() {
		// create new point for plane location
		p = new Point();
		p.x = 350;
		p.y = 350;
	}
	
	public void updateLocation(int key) {
		switch (key) {
		case 203:
			p.x -= mvtExtent;
			break;
		case 200:
			p.y -= mvtExtent;
			break;
		case 205:
			p.x += mvtExtent;
			break;
		case 208:
			p.y += mvtExtent;
			break;
		}

		if (p.x >= 750) {
			p.x = 750;
		}
		if (p.x <= 0) {
			p.x = 0;
		}
		if (p.y >= 750) {
			p.y = 750;
		}
		if (p.y <= 0) {
			p.y = 0;
		}
		
	}
	
	public void render(Graphics g) {
		// render rect in position of point
		g.fillRect(p.x, p.y, pWidth, pHeight);
	}

}
