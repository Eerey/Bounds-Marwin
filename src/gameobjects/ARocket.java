package gameobjects;

import game.Level;
import gameobjects.EntityObject;
import gameobjects.GameObject;
import gameobjects.MovableObject;
import gameobjects.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;



public class ARocket extends AAttackP{

	
	Vector2 tempDir;
	int scaler = 1;
	int randomizer = 0;
	
	public ARocket(float damage, float extraSpeed, int type, GameObject owner, GameObject target) { //2nd Constructor
		super(owner.getPosition().cpy(),owner.getVelocity().cpy(),owner.getDirection().cpy(),
				damage, extraSpeed, type, owner, target);
	
		setTimeToDie(600);
		this.owner = owner;
		if (owner instanceof Player) scaler = 2;
		this.target = Level.getPlayer();
		// TODO Auto-generated constructor stub
		setImageAndRect("img/rocket.png");
		direction.limit(5f);
		
	}
	
//	public ARocket(float x, float y, GameObject owner) { //1st Constructor OLD, EXT MO.
//		super(x, y);
//		setTimeToDie(600);
//		this.owner = owner;
//		if (owner instanceof Player) scaler = 2;
//		this.target = Level.getPlayer();
//		// TODO Auto-generated constructor stub
//		setImageAndRect("img/rocket.png");
//		direction.limit(5f);
//		
//	}
	
	
	
	public void setDirection2(){
		float x,y,tempx,tempy;
		try{
		x = position.x-target.getPosition().x;
		y = position.y-target.getPosition().y;
		
		direction.set(-x, -y).nor();
		} catch (Exception e){}
		//direction.set(tempDir);
	}
	
	public void update(){
		if(timeToDie.update()) aboutToDie = true;
		setRectToGO();
		
		if (randomizer++ > 35){
		setDirection2();
		randomizer=0;
		}
		move();
		
		//if (getRect().overlaps(target.getRect())); //((EntityObject)target).sufferDamage(20);
		if (getRect().overlaps(target.getRect())){ ((EntityObject)target).sufferDamage(20);
		//position.x = position.y = 0;
		aboutToDie = true;
		}
		//rect.set(position.x+50, position.y+50,20	 , 20);
		//level.removeGameObject(this);
			
		//position.setAngle(45f);
	}
	
	public void move(){
		
		getPosition().x+=direction.x*5;
		getPosition().y+=direction.y*5;
		
	}
	
	public void render(SpriteBatch batch){
		batch.draw(img,position.x,position.y,width2,height2,width,height,scaler,scaler,direction.angle(),0,0,17,8,false,false);
		
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

}
