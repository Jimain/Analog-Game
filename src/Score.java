
public class Score {

	private static Score instance = null;
	
	private static int score = 0;
	
	public Score() {
	
		
	}

	public static Score getInstance() {
		
		if ( instance == null) {
			
			instance = new Score();
		}
		
		return instance;
	}
	public void setScore( int sc ) {
		
		score += sc;
		
	}
	public int getScore () {
		
		
		
		return score;
		
	}
}
