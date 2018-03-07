import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Point;

public class Item {
	
	Point p = new Point(30, 30);

	public Item() {
		
	
		
	}
	public void render( Graphics g) {
		
		g.fillRect( 100 , 100 , p.getX(), p.getY());
	
		
		
		
		
	}

}
