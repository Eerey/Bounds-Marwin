package controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

import logic.Logic;
import game.Level;
import gameobjects.Player;
import screens.GameScreen;
import time.Updates;

public class Controller implements InputProcessor, GestureListener{

	private Level level;
	private Player player;
	private Updates updates;
	private Logic logic;
	private GameScreen screen;
	
	int width,height;

	public Controller(GameScreen screen) {
		this.screen = screen;
		this.level = screen.getLevel();
		this.player = screen.getLevel().getPlayer();
		this.updates = screen.getUpdates();
		this.logic = screen.getLogic();
		
	}

	public void control() {
		if (Gdx.input.isKeyPressed(Input.Keys.UP)|| Gdx.input.isKeyPressed(Input.Keys.W)) {
			player.setUp(true);
		} else {
			player.setUp(false);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)|| Gdx.input.isKeyPressed(Input.Keys.S)) {
			player.setDown(true);
		} else {
			player.setDown(false);

		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)|| Gdx.input.isKeyPressed(Input.Keys.A)) {
			player.setLeft(true);
		} else {
			player.setLeft(false);

		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)|| Gdx.input.isKeyPressed(Input.Keys.D)) {
			player.setRight(true);
		} else {
			player.setRight(false);

		}
		
		if (Gdx.input.isKeyPressed(Input.Keys.ENTER)){
			//player.attackRocket();
			player.attackLaser();
		} else {
			
		}
		
		if (Gdx.input.isKeyPressed(Input.Keys.BACKSPACE)){
			level.initialize();
			//player = new Player(0, 0, level);
		} else {
			
		}
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
		
//			player.attackLaser();
//			player.attackRoundLazer();
			player.setPrim_attack(true); //entgegen dem Command Pattern...
		} else {
			//player.setPrim_attack(false); //entgegen dem Command Pattern...
		}

		// jump = Gdx.input.isKeyPressed(Input.Keys.UP)
		// || Gdx.input.isKeyPressed(Input.Keys.W)
		// || Gdx.input.isKeyPressed(Input.Keys.SPACE) ? true : false;
		// obj.setJump(jump);
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {

		System.out.print("x = "+x);
		System.out.println(" // y = "+y);
//		player.setPrim_attack(true); //entgegen dem Command Pattern...
		player.attackLaser();
		player.attackRoundLazer();
		
		
		
		return false;
		} 
	@Override
	public boolean tap(float x, float y, int count, int button) {
		
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		screen.debug = true;
		level.initialize();
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
	
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		player.attackLaser();
		player.attackRoundLazer();
		
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
