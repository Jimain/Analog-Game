import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Menu extends BasicGameState implements MouseListener{
	
	Image pressStart;
	Image title;
	StateBasedGame  sbe;
	

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		
		 pressStart = new Image("res/PressStart.gif");
		 title = new Image("res/Title.png");
		 
		 sbe = arg1;
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		
		int twResize = title.getWidth() / 3;
		int thResize = title.getHeight() / 3;
		
		g.setBackground(Color.white);
		pressStart.draw( 595/ 2 - pressStart.getWidth() / 2  , 800 / 2 - pressStart.getHeight() / 2);
		title.draw( 595/ 2 - twResize / 2  ,  750 / 2 - thResize , twResize, thResize );
		
		
		
	}
	@Override
	public void mouseClicked( int button, int x, int y , int clickCount) {
		
	sbe.enterState(1, new FadeOutTransition(), new FadeInTransition());
		
	}
	

	@Override
	public int getID() {

		return 0;
	}

}
