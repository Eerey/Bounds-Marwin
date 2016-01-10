package gameobjects;

import java.util.ArrayList;

import game.Level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class GameObject {
	protected Vector2 position;
	protected Vector2 velocity;
	protected Vector2 direction;
	
	protected boolean collided = false;
	


	protected int id = 0; // für Collision Detection. 0 = default, 1 = player, 2 = gegner etc.


	protected Cooldown timeToDie; // This CD determines after how many updates
									// it dies.

	protected ArrayList<GameObject> toBeGeneratedGameObjects;
	public GameObject target, owner;




	public int height, width, height2, width2;
	public float scaler = 1; // scales the rendered image

	Texture img;
	Rectangle rect;
	boolean aboutToDie = false;
	boolean wantsToCreateObject = false;

	public GameObject() {

	}

	public GameObject(float x, float y) {
		position = new Vector2(x, y);
		direction = new Vector2(0, 0);
		velocity = new Vector2(0, 0);
		// rect = new Rectangle(x, y, 20, 20);
		// region.getRegionWidth(), region.getRegionHeight())
		img = new Texture("img/ship.png");

	}

	public GameObject(Vector2 pos, Vector2 vel, Vector2 dir) {
		position = pos.cpy();
		velocity = vel.cpy();
		direction = dir.cpy();

		// rect = new Rectangle(x, y, 20, 20);
		// region.getRegionWidth(), region.getRegionHeight())
		img = new Texture("img/ship.png");
		toBeGeneratedGameObjects = new ArrayList<GameObject>();
	}

	public void update() {
		move();
	}

	public void move() {

	}

	public void setImageAndRect(String imagePath) {
		img = new Texture(imagePath);
		setRect(new Rectangle(position.x, position.y, img.getHeight(),
				img.getWidth()));
		height = img.getHeight();
		width = img.getWidth();
		height2 = height / 2;
		width2 = width / 2;

	}

	public void render(SpriteBatch batch) {
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}
	public void setPosition(float x, float y) {
		this.position = position.set(x, y);
	}

	public Rectangle getRect() {
		return rect;
	}

	public void setRectToGO() {
		this.rect
				.set(position.x, position.y, getRect().width, getRect().height);
	}
	public void setRectToGOCentered() {
		this.rect
				.set(position.x-width2, position.y-height2, getRect().width, getRect().height);
	}

	public void setRectToGO(int preferredSquareSize) {
		this.rect.set(position.x, position.y, preferredSquareSize,
				preferredSquareSize);
	}

	public void setDirection(Vector2 direction) {
		this.direction = direction;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}

	public Texture getImg() {
		return img;
	}

	public void setImg(Texture img) {
		this.img = img;
	}

	public boolean isAboutToDie() {
		return aboutToDie;
	}

	public void setAboutToDie(boolean aboutToDie) {
		this.aboutToDie = aboutToDie;
	}

	public Vector2 getDirection() {
		return direction;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public ArrayList<GameObject> getToBeGeneratedGameObjects() {
		return toBeGeneratedGameObjects;
	}

	public void setToBeGeneratedGameObjects(
			ArrayList<GameObject> toBeGeneratedGameObjects) {
		this.toBeGeneratedGameObjects = toBeGeneratedGameObjects;
	}

	public void setTimeToDie(Cooldown timeToDie) {
		this.timeToDie = timeToDie;
	}

	public void setTimeToDie(int timeInUpdates) {
		this.timeToDie = new Cooldown(timeInUpdates);
	}

	public void clearToBeGeneratedList() {
		if (toBeGeneratedGameObjects != null)
			toBeGeneratedGameObjects.clear();
	}

	public void addToBeGeneratedGO(GameObject go) {
		if (toBeGeneratedGameObjects == null){
			toBeGeneratedGameObjects = new ArrayList<GameObject>();
		toBeGeneratedGameObjects.add(go);
		}
		else
			toBeGeneratedGameObjects.add(go);
	}

	public float getScaler() {
		return scaler;
	}

	public void setScaler(float scaler) {
		this.scaler = scaler;
	}

	public Cooldown getTimeToDie() {
		return timeToDie;
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void launchRocket(Vector2 pos, Vector2 vel, Vector2 dir,
			float damage, float extraSpeed, GameObject owner, GameObject target) {
		// ARocket r = new ARocket(pos,vel,dir);
	}

	public boolean wantsToCreateObject() {
		return wantsToCreateObject;
	}

	public void setWantsToCreateObject(boolean wantsToCreateObject) {
		this.wantsToCreateObject = wantsToCreateObject;
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
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isCollided() {
		return collided;
	}

	public void setCollided(boolean collided) {
		this.collided = collided;
	}
}
