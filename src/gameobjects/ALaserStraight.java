package gameobjects;

import game.Level;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class ALaserStraight extends AAttackP{
	Vector2 tempDir;
	float damage, speed;
	




	public ALaserStraight(float damage, float extraSpeed, int type, GameObject owner, GameObject target) { //2nd Constructor
		super(owner.getPosition().cpy(),owner.getVelocity().cpy(),owner.getDirection().cpy(),
				damage, extraSpeed, type, owner, target);
		setTimeToDie(120);
		setOwner(owner);
		this.setSpeed(extraSpeed);
		this.setDamage(damage);
		//if (owner instanceof Player) scaler = 2;
		
		//else setTarget(Level.getNearestTarget(this));
		setTarget(Level.getNearestTarget(this));
		setImageAndRect("img/laserS.png");
		this.setDirection(owner.getVelocity().cpy());
		this.setPosition(owner.getPosition().cpy());
		//this.direction.nor();
		//this.direction.scl(1f);
		this.direction.scl(speed);
		System.out.println(speed);
	}
	

	
	public void setDirection2(){
		
		float x,y;
		try{
		x = position.x-getTarget().getPosition().x;
		y = position.y-getTarget().getPosition().y;
		direction.set(-x, -y).nor();
		} catch (Exception e){}
		//direction.set(tempDir);
	}
	
	public void update(){
		
		//if (target == null) target = this; // WORK ON THAT PLS
		//setDirection2();
		move();
		setRectToGO();
		
	
		if(timeToDie.update()) aboutToDie = true; //counts downwards, - if 0, with the next update this unit dies.
	}
	
	public void move(){
		getPosition().x+=direction.x;
		getPosition().y+=direction.y;
		
	}
	
	public void render(SpriteBatch batch){
		batch.draw(img,position.x,position.y,width2,height2,width,height,scaler,scaler,direction.angle(),0,0,17,8,false,false);
		//batch.draw(img,position.x-50,position.y-50,width2,height2,width,height,scaler/3,scaler/3,direction.angle(),0,0,17,8,false,false);
		
		//batch.draw(img,position.x+50,position.y+50,width2,height2,width,height,scaler/3,scaler/3,direction.angle(),0,0,17,8,false,false);
		
	}
	public GameObject getTarget() {
		return target;
	}

	public void setTarget(GameObject target) {
		this.target = target;
	}

	public GameObject getOwner() {
		return owner;
	}

	public void setOwner(GameObject owner) {
		this.owner = owner;
	}

	public Vector2 getTempDir() {
		return tempDir;
	}

	public void setTempDir(Vector2 tempDir) {
		this.tempDir = tempDir;
	}
	
	public float getScaler() {
		return scaler;
	}



	public void setScaler(int scaler) {
		this.scaler = scaler;
	}



	public float getDamage() {
		return damage;
	}



	public void setDamage(float damage) {
		this.damage = damage;
	}



	public float getSpeed() {
		return speed;
	}



	public void setSpeed(float speed) {
		this.speed = speed;
	}

}