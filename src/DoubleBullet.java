import java.awt.Point;
import java.util.ArrayList;



public class DoubleBullet {
	Point planeLoc;
	int pW;
	int pH;

	public DoubleBullet(int px, int py, int pWidth, int pHeight) {	
		planeLoc = new Point(px, py);
		
		 pW = pWidth;
		 pH = pHeight;
		 
		
	}
	
	public void getBulletList(ArrayList<Bullet> bList) {
		
		int halfpW = pW / 2;
		int d = 20;
		
		Bullet b1 = new Bullet(planeLoc.x + halfpW  + d , planeLoc.y,BD.MIDDLE);
		Bullet b2 = new Bullet(planeLoc.x + halfpW - d, planeLoc.y, BD.MIDDLE);
		bList.add(b1);
		bList.add(b2);
	}

}
