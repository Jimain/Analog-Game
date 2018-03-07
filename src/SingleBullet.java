import java.awt.Point;
import java.util.ArrayList;

public class SingleBullet {
	Point planeLoc;
	int pW;
	int pH;

	public SingleBullet(int px, int py, int pWidth, int pHeight) {	
		planeLoc = new Point(px, py);
		
		 pW = pWidth;
		 pH = pHeight;
		
	}
	
	public void getBulletList(ArrayList<Bullet> bList) {
		Bullet b1 = new Bullet(planeLoc.x + pW / 2, planeLoc.y,BD.MIDDLE);
		bList.add(b1);
	}

}
