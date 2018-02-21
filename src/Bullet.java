import java.awt.Point;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Bullet {

	int bW = 2;
	int bH = 6;
	int speed = 10;
	Point p = new Point();
	Color c = new Color(Color.red);
	
	public Bullet() {
		
	}
	public void render(Graphics g) {
		
		p = new Point();
		p.x = 400;
		p.y = 400;
		g.fillRect(p.x, p.y, bW, bH);
		
		
	}

}
