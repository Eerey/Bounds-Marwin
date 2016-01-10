package logic;

import game.Level;

import com.badlogic.gdx.Gdx;

public class Logic {

	private long counter = 0;
	private Level level;
	

	public Logic(Level level) {
		this.level = level;
	}
	
	public void update(){
		//countUpdates();
		level.update();
	}
	
	public void countUpdates(){
		counter++;
		Gdx.app.log("Update No.", String.valueOf(counter));
	}
	
	
	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

}
