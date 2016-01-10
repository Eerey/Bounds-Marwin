package gameobjects;

import com.badlogic.gdx.math.Vector2;


public class AAttackP extends MovableObject{

	public GameObject target, owner;
	
	public float damage, extraSpeed;
	public int type;
	


	public AAttackP(Vector2 pos, Vector2 vel, Vector2 dir,
			float damage, float extraSpeed,int type, GameObject owner, GameObject target) { //2nd Constructor
		this.position=pos;
		this.velocity=vel;
		this.direction=dir;
	this.owner = owner;
	this.target = target;
	this.damage = damage;
	this.extraSpeed = extraSpeed;
	this.type = type;
	// für Collision Detection:
	setId(owner.getId());
	//System.out.println(getId());
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
	
	public float getDamage() {
		return damage;
	}


	public void setDamage(float damage) {
		this.damage = damage;
	}


	public float getExtraSpeed() {
		return extraSpeed;
	}


	public void setExtraSpeed(float extraSpeed) {
		this.extraSpeed = extraSpeed;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}

}
