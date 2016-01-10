package gameobjects;

import game.Level;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class ALaser extends AAttackP{
	Vector2 tempDir;
	float damage, speed;
	




	public ALaser(float damage, float extraSpeed, int type, GameObject owner, GameObject target) { //2nd Constructor
		super(owner.getPosition().cpy(),owner.getVelocity().cpy(),owner.getDirection().cpy(),
				damage, extraSpeed, type, owner, target);
		setTimeToDie(50);
		setSpeed(extraSpeed);
		setOwner(owner);
		//if (owner instanceof Player) scaler = 2;
		
		//else setTarget(Level.getNearestTarget(this));
		
		//setTarget(Level.getNearestTarget(this));
		//if (!(owner instanceof Player)) setTarget(Level.getPlayer());
		setImageAndRect("img/laserS.png");
		scaler=1f;
		//direction.limit(5f);
//		if (target!=null)setDirection2();
//		else {
//			direction.set(0,0);
//			direction.add(owner.direction);
//		}
	}
	public ALaser(float damage, float extraSpeed, int type, GameObject owner, GameObject target,float rotateLevel) { //2nd Constructor
		super(owner.getPosition().cpy(),owner.getVelocity().cpy(),owner.getDirection().cpy(),
				damage, extraSpeed, type, owner, target);
		setTimeToDie(50);
		setSpeed(extraSpeed);
		setOwner(owner);
		//if (owner instanceof Player) scaler = 2;
		
		//else setTarget(Level.getNearestTarget(this));
		//setTarget(Level.getNearestTarget(this));
		//if (!(owner instanceof Player)) setTarget(Level.getPlayer());
		setImageAndRect("img/laserS.png");
		scaler=(float)(Math.random()*2f);
		//direction.limit(5f);
		this.direction.rotate(rotateLevel);
//		if (target!=null)setDirection2();
//		else {
//			direction.set(0,0);
//			direction.add(owner.direction);
//		}
	}
	

	
	public void setDirection2(){
		
		float x,y;
		try{
//		x = position.x-getTarget().getPosition().x;
//		y = position.y-getTarget().getPosition().y;
		
		x = owner.getPosition().x;
		y = owner.getPosition().y;
		//direction.set(x, y).nor();
		} catch (Exception e){}
		//direction.set(tempDir);
	}
	public void setDirectionToTarget(){
		
		float x,y;
		try{
		x = position.x-getTarget().getPosition().x;
		y = position.y-getTarget().getPosition().y;
		
//		x = owner.getPosition().x;
//		y = owner.getPosition().y;
		direction.set(x, y).nor();
		} catch (Exception e){}
		//direction.set(tempDir);
	}
	
	public void update(){
		if(timeToDie.update()) aboutToDie = true; //counts downwards, - if 0, with the next update this unit dies.
		//if (target == null) target = this; // WORK ON THAT PLS
		//if (target!=null) setDirection2();
		move();
		setRectToGO();
	
		// -- SCHADENSERLEIDUNG -- //
		//		if (getRect().overlaps(target.getRect())); 
		//		if (getRect().overlaps(target.getRect())){ 
		//			((MovableObject)target).sufferDamage(50);
		//		}
	    // -- SCHADENSERLEIDUNG -- //
			
			//position.x = position.y = 0;
		//aboutToDie = true;
			
		
		
		//try{
		
//		if (target==null) { // irrsinnig, HOMING MISSLE LASER
//		
//			target=Level.getNearestTarget(this);
//			if (target!=null) setDirectionToTarget();
//		}
		
		//} catch (Exception e){}
		
		//rect.set(position.x+50, position.y+50,20	 , 20);
		//level.removeGameObject(this);
			
		//position.setAngle(45f);
	}
	
	public void move(){
		getPosition().x+=direction.x*getExtraSpeed();
		getPosition().y+=direction.y*getExtraSpeed();
		
	}
	
	public void render(SpriteBatch batch){
		batch.draw(img,position.x,position.y,width2,height2,width,height,scaler/0.5f,scaler/0.5f,direction.angle(),0,0,17,8,false,false);
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