
import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Point;

public class Plane {
	public int pHeight = 0;
	public int pWidth = 0;
	Point p;
	public int mvtExtent = 4;
	ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	GunType gT = GunType.SINGLEB;
	int activeKey;
	Image planeImage;
	Image[] plane = new Image[3];
	SpriteSheet explode;
	int spriteSize = 96;
	Animation explosionAnimation;
	Image[] explosion = new Image[16];
	Boolean IAmDead = false;
	int Dcounter = 300;
	int tpcounter = 0;

	public Plane() {

		try {
			planeImage = new Image("res/aircrafts.png");
			explode = new SpriteSheet("res/ExplosionSprite.png", spriteSize, spriteSize);

			int epcounter = 0;

			for (int x = 0; x < 4; x++) {
				for (int y = 0; y < 4; y++) {
					explosion[epcounter] = explode.getSprite(y, x);
					epcounter++;
				}
			}
			explosionAnimation = new Animation(explosion, 40);
			plane[0] = planeImage.getSubImage(114, 193, 110, 92);
			plane[1] = planeImage.getSubImage(226, 99, 110, 92);
			pHeight = plane[0].getHeight();
			pWidth = plane[0].getWidth();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p = new Point(350, 350);

	}

	public void updateDirection(int key) {
		activeKey = key;

	}

	public void updateLocation() {
		switch (activeKey) {
		case 203:
			p.setX(p.getX() - mvtExtent);
			break;
		case 200:
			p.setY(p.getY() - mvtExtent);
			break;
		case 205:
			p.setX(p.getX() + mvtExtent);
			break;
		case 208:
			p.setY(p.getY() + mvtExtent);
			break;
		}

		if (p.getX() >= 595 - pWidth) {
			p.setX(595 - pWidth);
		}
		if (p.getX() <= 0) {
			p.setX(0);
		}
		if (p.getY() >= 800 - pHeight) {
			p.setY(800 - pHeight);
		}
		if (p.getY() <= 0) {
			p.setY(0);
		}

	}

	public void update() {

		switch (gT) {

		case DOUBLEB:
			DoubleBullet db = new DoubleBullet((int) p.getX(), (int) p.getY(), pWidth, pHeight);
			db.getBulletList(bullets);

			break;

		case SINGLEB:
			SingleBullet sb = new SingleBullet((int) p.getX(), (int) p.getY(), pWidth, pHeight);
			sb.getBulletList(bullets);
			
			tpcounter = 0;

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
		
		tpcounter++;
		System.out.println( tpcounter );
		if( tpcounter > 13) {
			gT = GunType.SINGLEB;
			tpcounter = 0;
		}
	}

	public void render(Graphics g) {
		
		if (IAmDead) {
			if( Dcounter > 0) {
				plane[1].draw(p.getX(), p.getY());
				explosionAnimation.draw(p.getX(), p.getY());
			}
			Dcounter-- ;
		} else {
			plane[0].draw(p.getX(), p.getY());
			for (int i = 0; i < bullets.size(); i++) {
				bullets.get(i).render(g);
			}
		}

	}

	public void eatItem(GunType g) {

		gT = g;
		
		tpcounter = 0;

	}

	public void dead() {

		IAmDead = true;

	}

}
