import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class GamePlay extends StateBasedGame implements MouseListener  {

	public GamePlay(String name) {
		super(name);

		this.addState(new Gameover());
		this.addState(new Menu());
		this.addState(new Play());

	}

	public void startGame() throws SlickException {
		AppGameContainer app = new AppGameContainer(new GamePlay("Analog Game"));

		app.setDisplayMode(595, 800, false);
		app.setAlwaysRender(true);

		app.start();

	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {

		this.getState(0).init(gc, this);
		this.getState(1).init(gc, this);
		this.getState(2).init(gc, this);

		this.enterState(0);

	}

	public void mouseClicked(int button, int x, int y,int clickCount) {
		this.enterState(1);
	}

}
