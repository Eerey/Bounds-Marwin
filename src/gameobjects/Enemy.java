package gameobjects;

import game.Level;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Enemy extends EntityObject {

	public int ticker = 2;

	public Enemy(int x, int y, Level level) {
		super(x, y);
		setHp(60);
		
		// TODO Auto-generated constructor stub
		setImageAndRect("img/enemy.png");
		setId(2); //Enemies have the ID 2, Player has 1, Random Objects have 0 as default.
		setLaserSpeed(5.2f);
	}

	public void update() {

		move();
		// if (Math.random()>0.99D) attack();
		ticker++;
		if (ticker > 100) {
			//if (Math.random()<0.5D)attackRocket();
			ticker = 1;
			// ticker=0;
		}
		if (ticker < 2)
		
				attackLaser();
			
		// System.out.println("PlayerUpdated");
		if (getHp() <= 0)
			aboutToDie = true;
	}

	public void move() {
setRectToGO();
		 if (Math.random()>0.99D) down = !down;
		 if (Math.random()>0.99D) up = !up;
		 if (Math.random()>0.99D) right = !right;
		 if (Math.random()>0.99D) left = !left;
		if (up)
			direction.add(0, 1);
		if (down)
			direction.add(0, -1);
		if (left)
			direction.add(-1, 0);
		if (right)
			direction.add(1, 0);
		 if (Math.random()>0.59D) down = up = right = left = false;
		direction.limit(2f);
		position.add(direction);
	}

	
	public void attackRocket(){
		//level.addProjectile(this);
		ARocket rocket = new ARocket(getLaserDamage(),getLaserSpeed(),0,this,Level.getNearestTarget(this));
		addToBeGeneratedGO(rocket);
		setWantsToCreateObject(true);
	}
	
	public void attackLaser(){
		ALaser laser = new ALaser(getLaserDamage(),getLaserSpeed(),0,this,Level.getNearestTarget(this));
		addToBeGeneratedGO(laser);
		setWantsToCreateObject(true);
		
	}

	public void render(SpriteBatch batch) {
		if (isShowHealth())
			showHp(batch);
		// batch.draw(img, position.x, position.y);
		// position.setAngle(10f); //AWESOME ray movement
		// batch.draw(img,position.x,position.y,0,0,img.getWidth(),img.getHeight(),1,1,position.angle(),0,0,43,33,false,false);
		batch.draw(img, position.x, position.y, width2, height2, width, height,
				1, 1, direction.angle(), 0, 0, 43, 33, false, false);

	}

}
