
import java.util.ArrayList;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Point;

public class Enemy {

	Point p;
	int enemySize = 30;
	ArrayList<Point> po = new ArrayList<Point>();
	patternGenerator pG = new patternGenerator();
	int counter = 0;

	public Enemy() {

		p = new Point(0, 0);
		
		po = pG.newPattern1() ;
	
		

	}

	public void render(Graphics g) {

		g.setColor(Color.pink);
		g.fillRect(p.getX(), p.getY(), enemySize, enemySize);
		

	}
	public void updateLocation() {
		
		p.setX(po.get(counter).getX());
		p.setY(po.get(counter).getY());
		
		counter++;
	}

}
