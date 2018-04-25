import org.newdawn.slick.geom.Point;

public class GameHelper {

	public GameHelper() {
		
	}public Boolean outOfBound( Point p) {

		if (p.getX() >= 595) {
			return true;
		}
		if (p.getX() < 0) {
			return true;
		}
		if (p.getY() <= 0) {
			return true;
		}
		if ( p.getY() >= 800 ) {
			return true;
		}
		return false;
	}
	public Boolean bottomOutofBound(Point p) {
		
		if ( p.getY() >= 800 ) {
			return true;
		}
		return false;
		
	}
	

}
