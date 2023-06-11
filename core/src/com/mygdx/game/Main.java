package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Screens.GameOverScreen;
import com.mygdx.game.Screens.GameScreen;
import com.mygdx.game.Screens.SplashScreen;
import com.mygdx.game.Screens.WinScreen;
//Main class loads some game objects and controls screen changes
public class Main extends Game {
	public static SpriteBatch batch;
	public static  ScreenViewport viewport = new ScreenViewport();
	public static OrthographicCamera camera;
	public static final float PPM = 64;
	public static final short BIT_WALL = 2;
	public static final short BIT_PLAYER = 4;
	public static final short BIT_ENEMY= 8;
	public static final short BIT_BULLET= 16;

	public static int WIDTH, HEIGHT;
	public static ShapeRenderer shapeRenderer;

	private SplashScreen splashScreen;
	private GameScreen gameScreen;
	private GameOverScreen gameOverScreen;
	private WinScreen winScreen;
	public final static int SPLASH = 0;
	public final static int GAME = 1;
	public final static int GAMEOVER = 2;
	public final static int WIN = 3;

	@Override
	public void render() {
		super.render();
	}

	public void changeScreen(int screen){
		try {
			switch (screen) {
				case SPLASH:
					if (splashScreen == null) splashScreen = new SplashScreen(this);
					this.setScreen(splashScreen);
					break;
				case GAME:
					if (gameScreen == null) gameScreen = new GameScreen(this);
					this.setScreen(new GameScreen(this));
					break;
				case GAMEOVER:
					if (gameOverScreen == null) gameOverScreen = new GameOverScreen(this);
					this.setScreen(gameOverScreen);
					break;
				case WIN:
					if (winScreen == null) winScreen = new WinScreen(this);
					this.setScreen(winScreen);
					break;
			}
		} catch (NullPointerException e) {}
	}

	@Override
	public void create () {
		Gdx.input.setOnscreenKeyboardVisible(false);
		//VISUAL CONFIGURATION
		batch = new SpriteBatch();
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		shapeRenderer = new ShapeRenderer();

		//SCREEN PARAMETERS
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();


		splashScreen = new SplashScreen(this);
		setScreen(splashScreen);
	}

	@Override
	public void dispose () {
		batch.dispose();
		shapeRenderer.dispose();
		splashScreen.dispose();
		gameScreen.dispose();
	}
}
