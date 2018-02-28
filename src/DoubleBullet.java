import java.awt.Point;
import java.util.ArrayList;



public class DoubleBullet {
	Point planeLoc;

	public DoubleBullet(int px, int py) {	
		planeLoc = new Point(px, py);
	}
	
	public void getBulletList(ArrayList<Bullet> bList) {
		Bullet b1 = new Bullet(planeLoc.x, planeLoc.y,BD.MIDDLE);
		Bullet b2 = new Bullet(planeLoc.x + 10, planeLoc.y, BD.MIDDLE);
		bList.add(b1);
		bList.add(b2);
	}

}
