package screens;

import game.Level;
import gameobjects.GameObject;
import gameobjects.Player;
import time.Updates;
import logic.Logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameScreen implements Screen {
	Texture img;
	Updates updates;
	Logic logic;
	Level level;
	OrthographicCamera camera;
	ShapeRenderer debugRenderer;
	BitmapFont font;
	Player player;
	Color debugColor;
	public boolean debug = false;

	@Override
	public void render(float delta) {
		// camera.translate(0f,1f);
		// camera.setToOrtho(false);
		// camera.viewportHeight=50;
		// camera.viewportWidth=50;

		// camera.setToOrtho(false);
		// System.out.println(camera.position.x);
		//Gdx.gl.glClearColor(0.3f, 0, 0.1f, 1);
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.16f, 0.4f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);

		updates.update(delta);

		// float temp =level.getPlayer().getDirection().len();
		// if (temp<0.5f)temp =1f;
		// camera.zoom=1-((14/temp)/50);
		camera.zoom=1f;
		camera.position.x = player.getPosition().x;
		camera.position.y = player.getPosition().y;
		camera.update();
		if (debug) debugRender();

		//batch.flush();
		batch.setProjectionMatrix(camera.combined);
		camera.update();
		batch.begin();
		level.render(batch);
		font.draw(batch,
				String.valueOf(Gdx.app.getGraphics().getFramesPerSecond()),
				300, 300);
		batch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		img = new Texture("img/ship.png");
		level = new Level();
		logic = new Logic(level);
		updates = new Updates(logic);
		font = new BitmapFont();
		debugColor = new Color(1, 0, 0, 1);
		camera = new OrthographicCamera(Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		configCamera(camera);
		camera.zoom = 0.9f;
		try {
			this.player = Level.getPlayer();
		} catch (Exception e) {
		}

	}

	public void configCamera(OrthographicCamera cam) {
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	SpriteBatch batch;

	public SpriteBatch getBatch() {
		return batch;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}

	public Texture getImg() {
		return img;
	}

	public void setImg(Texture img) {
		this.img = img;
	}

	public Updates getUpdates() {
		return updates;
	}

	public void setUpdates(Updates updates) {
		this.updates = updates;
	}

	public Logic getLogic() {
		return logic;
	}

	public void setLogic(Logic logic) {
		this.logic = logic;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public OrthographicCamera getCamera() {
		return this.camera;
	}

	public void debugRender() {
		if (debugRenderer == null)
			debugRenderer = new ShapeRenderer();
		debugRenderer.setProjectionMatrix(camera.combined);
		debugRenderer.begin(ShapeType.Line);
		for (GameObject go : level.getGameObjects()) {
			if (go.getRect()!=null){
			debugRenderer.setColor(debugColor);
			debugRenderer.rect(go.getRect().x, go.getRect().y,
					go.getRect().width, go.getRect().height);
			// debugRenderer.circle(go.getPosition().getX(),
			// go.getPosition().getY(), 5);
			}
		}
		debugRenderer.end();
	}

}
