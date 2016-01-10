package gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Cannon extends MovableObject{
	MovableObject owner = null;
	Vector2 degree = null;
	int cannonNumber = 1;
	float rotateFactor;
	
	public Cannon(float x, float y, MovableObject owner, int cannonNumber) {
		super(x, y);
		this.owner = owner;
		setId(owner.getId());
		setImageAndRect("img/ship.png");
		degree = new Vector2(owner.getDirection());
		this.cannonNumber = cannonNumber;
		// TODO Auto-generated constructor stub
		float rotateNear = 30f;
		float rotateFar = 100f;
		if (cannonNumber == 1) rotateFactor = 0;
		if (cannonNumber == 2) rotateFactor = -rotateNear;
		if (cannonNumber == 3) rotateFactor = rotateNear;
		if (cannonNumber == 4) rotateFactor = -rotateFar;
		if (cannonNumber == 5) rotateFactor = rotateFar;

	}
	public void update(){
		
		//if (shield != null) shield.update();
		degree.set(owner.getDirection());
		degree.rotate(rotateFactor);
	
		//move3();
		this.setDirection(owner.getDirection());
		this.setPosition((owner.position.x+degree.x), (owner.position.y+degree.y));
		this.setVelocity(owner.getVelocity());
		setRectToGO();
		//System.out.println("PlayerUpdated");
	}
	public void render(SpriteBatch batch){

		//position.setAngle(10f); //AWESOME ray movement
		batch.draw(img,position.x,position.y,width2,height2,width,height,0.5f,0.5f,direction.angle(),0,0,43,33,false,false);
		

	}
	public void alsoAttack(){
	}
	
}
