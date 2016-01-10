package time;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import logic.Logic;

public class Updates {
	float time = 0f;
	float frameRate;
	private Logic logic;
	
	public Updates(Logic logic){
		this.logic = logic;
		//frameRate = 1f/10f;
		frameRate = (1f/60f);
	}
	
	public void update(float deltaTime){
		time+=deltaTime;
		//if (time > 3.5f) time = 3.5f; // needs to be worked on
		while (time>frameRate){ // time = zähler; frameRate = updates/sekunde;
			
			logic.update();
			time-=frameRate;
			
		}
//		if (Gdx.input.isKeyPressed(Input.Keys.F1)){
//	increaseUpdateRate();
//		} else {
//			
//		}
//	
//	if (Gdx.input.isKeyPressed(Input.Keys.F2)){
//		decreaseUpdateRate();
//			} else {
//				
//			}
		
}
	public void setUpdateRate(float rate){
		frameRate = 1f/rate;
	}
	public float getUpdateRate(){
		return frameRate;
	}
	public void increaseUpdateRate(){
		frameRate = (getUpdateRate()+0.000005f);
	}
	public void decreaseUpdateRate(){
		frameRate = (getUpdateRate()-0.000005f);
	}
}
