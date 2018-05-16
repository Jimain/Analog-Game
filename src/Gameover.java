import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Gameover extends BasicGameState implements MouseListener{
	
	Image exit;
	Image gameOver;

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		
		exit = new Image("res/ExitGame.png");
		gameOver = new Image ("res/GameOver.png");

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		
		int gmOverW = (int) (gameOver.getWidth() / 1.5);
		int gmOverH = (int) (gameOver.getHeight() /1.5) ;
		
		g.setBackground(Color.black);
		gameOver.draw( 595 / 2 - gmOverW/ 2, 800 /2 - gmOverH / 2, gmOverW, gmOverH );
		exit.draw( 595 / 2 - exit.getWidth()/ 2, 700);
	

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed( int button, int x, int y) {
		
		System.exit(0);
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}

}
