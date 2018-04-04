
import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Point;

public class Plane {
	public int pHeight = 20;
	public int pWidth = 50;
	Point p ;
	public int mvtExtent = 4;
	ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	GunType gT = GunType.TRIPLEB;
	int activeKey;

	public Plane() {
		// create new point for plane location
		p = new Point(350, 350);


	}
	public void updateDirection( int key) {
		activeKey = key;
		
	}

	public void updateLocation( ) {
		switch (activeKey) {
		case 203:
			p.setX(p.getX() - mvtExtent ); 
			break;
		case 200:
			p.setY( p.getY() - mvtExtent);
			break;
		case 205:
			p.setX(p.getX() + mvtExtent ); 
			break;
		case 208:
			p.setY( p.getY() + mvtExtent);
			break;
		}

		if (p.getX() >= 595 - pWidth) {
			p.setX( 595 - pWidth);
		}
		if (p.getX() <= 0) {
			p.setX( 0);
		}
		if (p.getY() >= 800 - pHeight) {
			p.setY( 800 - pHeight );
		}
		if (p.getY() <= 0) {
			p.setY( 0);
		}

	}
	public void shooting() {
		
	}

	public void update() {

		switch (gT) {

		case DOUBLEB:
			DoubleBullet db = new DoubleBullet((int) p.getX(), (int) p.getY() , pWidth, pHeight);
			db.getBulletList(bullets);

			break;

		case SINGLEB:
			SingleBullet sb = new SingleBullet((int) p.getX(), (int)p.getY(), pWidth, pHeight);
			sb.getBulletList(bullets);

			break;

		case TRIPLEB:
			TripleBullet tb = new TripleBullet((int) p.getX(), (int) p.getY(), pWidth, pHeight);
			tb.getBulletList(bullets);

			break;

		}

		for (int i = 0; i < bullets.size(); i++) {
			if (bullets.get(i).outOfBound()) {
				bullets.remove(i);
			}
		}
	}
	
	public void render(Graphics g) {

		g.setColor(Color.blue);
		g.fillRect(p.getX(), p.getY(), pWidth, pHeight);

		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).render(g);
		}
		
	
	}

}
