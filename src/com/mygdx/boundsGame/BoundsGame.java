package com.mygdx.boundsGame;

import screens.GameScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import controller.Controller;

public class BoundsGame extends Game {
	SpriteBatch batch;
	Texture img;
	GameScreen screen;
	ScreenViewport viewport;
	Controller controller;

	public void create() {
		batch = new SpriteBatch();
		img = new Texture("img/ship.png");
		screen = new GameScreen();
		this.setScreen(screen);
		//viewport = new ScreenViewport(screen.getCamera());
		controller = new Controller(screen);
		setGameController(controller);
	}
	
	public void setController(Controller controller){
		
	}
	
public void setGameController(Controller controller){
	InputMultiplexer myInputMultiplexer = new InputMultiplexer();
	myInputMultiplexer.addProcessor(controller);
	
	
	InputMultiplexer im = new InputMultiplexer();
  GestureDetector gd = new GestureDetector(controller);
  im.addProcessor(gd);
  im.addProcessor((InputProcessor)controller);
	
	Gdx.input.setInputProcessor(im);
	
	}

	public void render() {
		controller.control();
		if (screen != null)
			screen.render(Gdx.graphics.getDeltaTime());
		else {
			Gdx.gl.glClearColor(1, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			batch.begin();
			batch.draw(img, 0, 0);
			batch.end();
		}
		

	}
	
}
