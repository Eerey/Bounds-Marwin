package gameobjects;

import game.Level;

public class MovableObject extends GameObject {

	float hp;
	float initialHp;
	boolean up, down, right, left, moving;

	

	public float getInitialHp() {
		return initialHp;
	}

	public void setInitialHp(float initialHp) {
		this.initialHp = initialHp;
	}

	public float getHp() {
		return hp;
	}

	public void setHp(float hp) {
		this.hp = hp;
	}

	public MovableObject(){
		velocity = position = direction = null;
	}
	
	public MovableObject(float x, float y) {
		super(x, y);
		this.hp=1;
		this.initialHp=1;
	}



	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}
//	public Level getLevel() {
//		return level;
//	}
//
//	public void setLevel(Level level) {
//		this.level = level;
//	}



	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public void sufferDamage(int i) {
	this.hp-=i;
	}
	
	
}
