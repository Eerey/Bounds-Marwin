package gameobjects;

import game.Level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player extends EntityObject{
	
	public Player(int x, int y, Level level){
		super(x, y);
		setImageAndRect("img/enemy.png");
		this.setInitialHp(180);
		this.setHp(260);
		this.setLaserSpeed(0.6f);
		this.setLaserDamage(5);
		this.setId(1);
		//this.setShield(new Shield(x,y,this));
		//addToBeGeneratedGO(shield);
		//setWantsToCreateObject(true);
		System.out.println("drone");
		//System.out.println(getToBeGeneratedGameObjects().size());
		addCannon(5); // FÜGT KANONEN HINZU
	}
	
	public void update(){
		
		if (shield != null) shield.update();

		move3();
		setRectToGO();
		if (cannon1!=null){
		cannon1.update();
		cannon2.update();
		cannon3.update();
		cannon4.update();
		cannon5.update();
		}
		//System.out.println("PlayerUpdated");
		if (prim_attack&&(++prim_attack_cd_live>prim_attack_cd)){
			this.attackRoundLazer();
			prim_attack_cd_live=0;
		}
	}
	
	public void move(){
		if (up) position.add(0, 3);
		if (down) position.add(0, -3);
		if (left) position.add(-3, 0);
		if (right) position.add(3, 0);	
	}
	
	public void move2(){ //Android Gyro
		velocity.set(Gdx.input.getAccelerometerY()*2.5f,-Gdx.input.getAccelerometerX()*2.5f);
		position.add(velocity);
		
		direction.x=direction.y=0;
		direction.add(velocity);
		//direction.rotate(45);
		direction.nor();
		direction.scl(25);
	}
	
	public void move3(){ //PC
		float coefficient = 0.2f;
		if (up) velocity.add(0, coefficient);
		if (down) velocity.add(0, -coefficient);
		if (left) velocity.add(-coefficient, 0);
		if (right) velocity.add(coefficient, 0);	
		velocity.limit(20f);
		position.add(velocity);
		direction.x=direction.y=0;
		direction.add(velocity);
		//direction.rotate(45);
		direction.nor();
		direction.scl(25);
		//direction.angle(velocity);
	}
	
	public void attackRocket(){
		//level.addProjectile(this);
	}
	public void attackRoundLazer(){
		//ALaserStraight laser = new ALaserStraight(getLaserDamage(),getLaserSpeed(),0,this,Level.getNearestTarget(this));
		ALaser laser = new ALaser(getLaserDamage(),getLaserSpeed(),0,this,Level.getNearestTarget(this));
		addToBeGeneratedGO(laser);
		laser = new ALaser(getLaserDamage(),getLaserSpeed(),0,this,Level.getNearestTarget(this),5);
		addToBeGeneratedGO(laser);
		laser = new ALaser(getLaserDamage(),getLaserSpeed(),0,this,Level.getNearestTarget(this),-5);
		addToBeGeneratedGO(laser);
		laser = new ALaser(getLaserDamage(),getLaserSpeed(),0,this,Level.getNearestTarget(this),30);
		addToBeGeneratedGO(laser);
		laser = new ALaser(getLaserDamage(),getLaserSpeed(),0,this,Level.getNearestTarget(this),-30);
		addToBeGeneratedGO(laser);
		laser = new ALaser(getLaserDamage(),getLaserSpeed()*2,0,this,Level.getNearestTarget(this),45);
		addToBeGeneratedGO(laser);
		laser = new ALaser(getLaserDamage(),getLaserSpeed()*2,0,this,Level.getNearestTarget(this),-45);
		addToBeGeneratedGO(laser);
		laser = new ALaser(getLaserDamage(),getLaserSpeed()*2,0,this,Level.getNearestTarget(this),55);
		addToBeGeneratedGO(laser);
		laser = new ALaser(getLaserDamage(),getLaserSpeed()*2,0,this,Level.getNearestTarget(this),-55);
		addToBeGeneratedGO(laser);
		setWantsToCreateObject(true);
	}
	
	public void attackLaser(){
		//ALaserStraight laser = new ALaserStraight(getLaserDamage(),getLaserSpeed(),0,this,Level.getNearestTarget(this));
		ALaser laser = new ALaser(getLaserDamage(),getLaserSpeed(),0,this,Level.getNearestTarget(this));
		addToBeGeneratedGO(laser);
		setWantsToCreateObject(true);
		
//		if(cannon1!=null){
//		ALaser laser1 = new ALaser(getLaserDamage(),getLaserSpeed(),0,cannon1,Level.getNearestTarget(this));
//		addToBeGeneratedGO(laser1);
//		setWantsToCreateObject(true);
//		
//		ALaser laser2 = new ALaser(getLaserDamage(),getLaserSpeed(),0,cannon2,Level.getNearestTarget(this));
//		addToBeGeneratedGO(laser2);
//		setWantsToCreateObject(true);
//		
//		ALaser laser3 = new ALaser(getLaserDamage(),getLaserSpeed(),0,cannon3,Level.getNearestTarget(this));
//		addToBeGeneratedGO(laser3);
//		setWantsToCreateObject(true);
//		
//		ALaser laser4 = new ALaser(getLaserDamage(),getLaserSpeed(),0,cannon4,Level.getNearestTarget(this));
//		addToBeGeneratedGO(laser4);
//		setWantsToCreateObject(true);
//		
//		ALaser laser5 = new ALaser(getLaserDamage(),getLaserSpeed(),0,cannon5,Level.getNearestTarget(this));
//		addToBeGeneratedGO(laser5);
//		setWantsToCreateObject(true);
//		}
		
		
	}
//	public void attackLaser(MovableObject mo){
//		//ALaserStraight laser = new ALaserStraight(getLaserDamage(),getLaserSpeed(),0,this,Level.getNearestTarget(this));
//		ALaser laser = new ALaser(getLaserDamage(),getLaserSpeed(),0,mo,Level.getNearestTarget(this));
//		addToBeGeneratedGO(laser);
//		setWantsToCreateObject(true);
//		
//	}
	
	public Vector2 getCannonPosition(int cannonNumber){ // muss überarbeitet werden! ist müll derzeit!
		Vector2 temp = null;
		if (cannonNumber == 1) {
			temp = new Vector2(position.x+direction.x,position.y+direction.y);
		}
		return temp;
	}
	

	
	public void render(SpriteBatch batch){
		if (isShowHealth()) showHp(batch);
		//batch.draw(img, position.x, position.y);
		//v2.setAngle(50f);
		
		//position.setAngle(10f); //AWESOME ray movement
		batch.draw(img,position.x,position.y,width2,height2,width,height,1,1,velocity.angle(),0,0,43,33,false,false);
		
		//batch.draw(img,position.x,position.y);
		//batch.draw(img,position.x+direction.x,position.y+direction.y,width2,height2,width,height,0.5f,0.5f,direction.x,0,0,43,33,false,false);
		if(cannon1!=null){
		cannon1.render(batch);
		cannon2.render(batch);
		cannon3.render(batch);
		cannon4.render(batch);
		cannon5.render(batch);
		}
		// SHIELD BEGIN
		
		//if(shield != null) shield.render(batch);		
		
		// SHIELD END
		
	}
	
	
}
