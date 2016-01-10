package gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Obstacle extends MovableObject{

	public Obstacle(float x, float y) {
		super(x, y);
		setImageAndRect("img/asteroid.png");
		this.setHp(1);
		float velocity_temp = 5.7f;
		velocity.set((float)((Math.random()-0.5)*velocity_temp),(float)((Math.random()-0.5)*velocity_temp));
	}

	public void render(SpriteBatch batch){
		
		//batch.draw(img, position.x, position.y);
		//v2.setAngle(50f);
		
		//position.setAngle(10f); //AWESOME ray movement
		batch.draw(img,position.x,position.y,width2,height2,width,height,1,1,velocity.angle(),0,0,width,height,false,false);
		
		//batch.draw(img,position.x,position.y);
		
	
	}
	
	
	public void update(){
		setRectToGO();
		move();
		if (getHp()<=0) aboutToDie=true;
		if (aboutToDie) 
			{
			addToBeGeneratedGO(new PowerUp(this.getPosition().x, this.getPosition().y));
		setWantsToCreateObject(true);
			}
	}
	
	public void move(){
		
			
			//velocity.limit(20f);
			position.add(velocity);
		
	}
	
	
}
