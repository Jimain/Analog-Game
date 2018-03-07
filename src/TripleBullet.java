import java.awt.Point;
import java.util.ArrayList;



public class TripleBullet {
	Point planeLoc;
	int pW;
	int pH;

	public TripleBullet (int px, int py, int pWidth, int pHeight) {	
		planeLoc = new Point(px, py);
		
		 pW = pWidth;
		 pH = pHeight;
		
	}
	
	public void getBulletList(ArrayList<Bullet> bList) {
		
		int half = pW / 2;
		int d = 20;
		
		Bullet b1 = new Bullet(planeLoc.x + half + d , planeLoc.y,BD.MIDDLE);
		Bullet b2 = new Bullet(planeLoc.x + half, planeLoc.y, BD.MIDDLE);
		Bullet b3 = new Bullet(planeLoc.x +half - d, planeLoc.y, BD.MIDDLE);
		bList.add(b1);
		bList.add(b2);
		bList.add(b3);
		
	}

}
