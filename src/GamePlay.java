import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class GamePlay extends StateBasedGame {

	public GamePlay(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void startGame() throws SlickException {
		AppGameContainer app = new AppGameContainer(new GamePlay("Analog Game"));
		
		app.setDisplayMode(800, 800, false);
		app.setAlwaysRender(true);
		
		app.start();
		
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
		
	}

}
