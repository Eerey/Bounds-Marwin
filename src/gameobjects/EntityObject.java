package gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import game.Level;

public class EntityObject extends MovableObject {

	float laserSpeed, rocketSpeed;
	float laserDamage, rocketDamage;
	Shield shield;
	Cannon cannon1 = null; // front
	Cannon cannon2 = null; // inner left
	Cannon cannon3 = null; // inner right
	Cannon cannon4 = null; // outer left
	Cannon cannon5 = null; // outer right

	boolean alive = true;
	boolean showHealth = true;
	boolean prim_attack = false;
    int prim_attack_cd = 1;
    int prim_attack_cd_live = 0;
	boolean sec_attack = false;
    int sec_attack_cd = 10;
    int sec_attack_cd_live = 0;
	Texture healthBar;

	public EntityObject(int x, int y) {
		super(x, y);
		healthBar = new Texture("img/Bar.png");
	}

	public void showHp(SpriteBatch batch) {

		for (int i = 0; i <= ((getHp() / 20)); i++) {
			batch.draw(healthBar, getPosition().x + (i * 8),
					getPosition().y + 48, 0f, 0f, healthBar.getWidth(),
					healthBar.getHeight(), 0.3f, 0.3f, 0, 0, 0, 25, 18, false,
					false);

		}

	}

	public void sufferDamage(int amount) {
		this.hp -= amount;
	}

	public void addCannon(int amountOfCannons) {
		if (amountOfCannons == 1)
			cannon1 = new Cannon(position.x, position.y, this,1);
		if (amountOfCannons == 2) {
			cannon1 = new Cannon(position.x, position.y, this,1);
			cannon2 = new Cannon(position.x, position.y, this,2);
		}
		if (amountOfCannons == 3) {
			cannon1 = new Cannon(position.x, position.y, this,1);
			cannon2 = new Cannon(position.x, position.y, this,2);
			cannon3 = new Cannon(position.x, position.y, this,3);
		}
		if (amountOfCannons == 4) {
			cannon1 = new Cannon(position.x, position.y, this,1);
			cannon2 = new Cannon(position.x, position.y, this,2);
			cannon3 = new Cannon(position.x, position.y, this,3);
			cannon4 = new Cannon(position.x, position.y, this,4);
		}
		if (amountOfCannons == 5) {
			cannon1 = new Cannon(position.x, position.y, this,1);
			cannon2 = new Cannon(position.x, position.y, this,2);
			cannon3 = new Cannon(position.x, position.y, this,3);
			cannon4 = new Cannon(position.x, position.y, this,4);
			cannon5 = new Cannon(position.x, position.y, this,5);
		}
		if (amountOfCannons<1||amountOfCannons>5) Gdx.app.log("tooManyCannons, ", "no!");
	}

	// Getter + Setter
	public boolean isShowHealth() {
		return showHealth;
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setShowHealth(boolean showHealth) {
		this.showHealth = showHealth;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public Shield getShield() {
		return shield;
	}

	public void setShield(Shield shield) {
		this.shield = shield;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public Texture getHealthBar() {
		return healthBar;
	}

	public void setHealthBar(Texture healthBar) {
		this.healthBar = healthBar;
	}

	public float getLaserSpeed() {
		return laserSpeed;
	}

	public void setLaserSpeed(float laserSpeed) {
		this.laserSpeed = laserSpeed;
	}

	public float getRocketSpeed() {
		return rocketSpeed;
	}

	public void setRocketSpeed(float rocketSpeed) {
		this.rocketSpeed = rocketSpeed;
	}

	public float getLaserDamage() {
		return laserDamage;
	}

	public void setLaserDamage(float laserDamage) {
		this.laserDamage = laserDamage;
	}

	public float getRocketDamage() {
		return rocketDamage;
	}

	public void setRocketDamage(float rocketDamage) {
		this.rocketDamage = rocketDamage;
	}
	public boolean isPrim_attack() {
		return prim_attack;
	}

	public void setPrim_attack(boolean prim_attack) {
		this.prim_attack = prim_attack;
	}

	public boolean isSec_attack() {
		return sec_attack;
	}

	public void setSec_attack(boolean sec_attack) {
		this.sec_attack = sec_attack;
	}

}
