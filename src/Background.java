import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;

public class Background {
	
	Point p = new Point(0, 0);
	Point pt = new Point ( 0,0);
	Image bg;
	Image bg2;
	int speed = 1;
	int counter = 0;
	public Background() {
		
		try {
			 bg = new Image( "./res/bg.jpg");
			 bg2 = new Image ( "./res/bg.jpg");
			 p.setY(- bg.getHeight() + 800) ;
			 pt.setY( -bg.getHeight() *2 + 800 );
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	
	}
	public void render( Graphics g) {
		
		g.drawImage( bg, p.getX(), p.getY());
		g.drawImage( bg2, pt.getX(),pt.getY() );
		
		
	}
	public void update() {
		
		counter++;
		
		p.setY(p.getY() + speed);
		pt.setY(pt.getY() + speed);
		
		
		
		
	}

}
