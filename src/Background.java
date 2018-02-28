import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;

public class Background {
	
	Point p = new Point(0, 0);
	Image bg;
	int speed = 1;
	int counter = 0;
	public Background() {
		
		try {
			 bg = new Image( "./res/bg.jpg");
			 p.setY(- bg.getHeight() + 800) ;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void render( Graphics g) {
		
		counter++;
		
		System.out.println( counter);
		
		p.setY(p.getY() + speed);
		
		g.drawImage( bg, p.getX(), p.getY());
		
		
	}

}
