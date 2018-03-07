import java.awt.Point;
import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Plane {
	private int pHeight = 20;
	private int pWidth = 50;
	Point p = new Point();
	public int mvtExtent = 30;
	ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	GunType gT = GunType.TRIPLEB;

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

	public void update() {

		for (int i = 0; i < bullets.size(); i++) {
			if (bullets.get(i).outOfBound()) {
				bullets.remove(i);
			}
		}
	}

	public void render(Graphics g) {
		
		switch(gT) {
		
		case DOUBLEB:
			DoubleBullet db = new DoubleBullet(p.x, p.y, pWidth, pHeight);
			db.getBulletList(bullets);
			
			break;
			
		case SINGLEB:
			SingleBullet sb = new SingleBullet(p.x,p.y, pWidth, pHeight);
			sb.getBulletList(bullets);
			
			break;
			
		case TRIPLEB:
			TripleBullet tb = new TripleBullet(p.x, p.y, pWidth, pHeight);
			tb.getBulletList(bullets);
			
			break;
			
		}

		g.setColor(Color.blue);
		g.fillRect(p.x, p.y, pWidth, pHeight);
		
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).render(g);
		}
	}

}
