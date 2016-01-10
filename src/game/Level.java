package game;

import gameobjects.AAttackP;
import gameobjects.ALaser;
import gameobjects.Enemy;
import gameobjects.EntityObject;
import gameobjects.GameObject;
import gameobjects.HMinorExplosion;
import gameobjects.MovableObject;
import gameobjects.Obstacle;
import gameobjects.Player;
import gameobjects.ARocket;
import gameobjects.PowerUp;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Level {

	static ArrayList<GameObject> gameObjects; // bitte static entfernen, marwin >:[
	ArrayList<GameObject> incomingObjects;
	static Player player;
	Vector2 tempVect = new Vector2(0,0);
	Circle circle = new Circle(); // for nearest target
	
	
	public Level(){
		gameObjects = new ArrayList<GameObject>();
		incomingObjects = new ArrayList<GameObject>();
		
//		players = new ArrayList<GameObject>();
//		enemies = new ArrayList<GameObject>();
//		playerProjectiles = new ArrayList<GameObject>();
//		gameObjects = new ArrayList<GameObject>();
		
		player = new Player(300,300,this);
		gameObjects.add(player);
		initialize();
	}
	
	public void initialize(){
		gameObjects.clear();
		int pos_temp = 350;
		player.setAboutToDie(false);
		player.getPosition().set(pos_temp, pos_temp);
		player.getDirection().set(0,0);
		player.setHp(player.getInitialHp());
		player.setDirection(new Vector2(0,0));
		player.setVelocity(new Vector2(0,0));
		gameObjects.add(player);
		addEnemy();
		addEnemy();
		addEnemy();
		addEnemy();
		int round = 50;
		for (int i = 0; i<50;i++)
		gameObjects.add(new Obstacle((int)(Math.random()*round),(int)(Math.random()*round)));
		
	}
	
	
	
	public static GameObject getNearestTarget(GameObject origin){
		float minimumDistance = 50000f;
		GameObject temp = null;
		for (GameObject obj : gameObjects){
			if ((obj.getPosition().dst(origin.getPosition())<minimumDistance) && (!(obj.equals(origin.getOwner())))){
				if (!(obj instanceof AAttackP)){
					if (!(obj instanceof Player)){
					minimumDistance = obj.getPosition().dst(origin.getPosition());
					temp = obj;
					}
				}
			}
			
		}
		return temp;
	
		
	}
	
	
	public Vector2 getClosestGameObject(Vector2 vec){
		float distance = 2000;
		
		for (GameObject obj : gameObjects){
			if (vec.dst(obj.getPosition())<distance){
				distance = vec.dst(obj.getPosition());
				tempVect = obj.getPosition();
			}
		}
		return tempVect;
	}
	
	public void addEnemy(){ 
		gameObjects.add(new Enemy((int)(Math.random()*750),(int)(Math.random()*750),this));
		//gameObjects.add(new Enemy(500,300,this));
		//gameObjects.add(new Enemy(500,300,this));
		//gameObjects.add(new Enemy(500,300,this));
	}
	
	public void removeGameObject(GameObject obj){
		gameObjects.remove(obj);
	}
	
	public void addProjectile(GameObject owner){
		//incomingObjects.add(new ARocket(owner.getPosition().x,owner.getPosition().y,owner));
	}
	public void addLaser(GameObject owner){
		//incomingObjects.add(new ALaser(owner.getPosition().x,owner.getPosition().y,owner));
	}
	
	public void createMinorExplosion(float x, float y){
		HMinorExplosion h = new HMinorExplosion(x, y);
		//gameObjects.add(h);
		incomingObjects.add(h);
	}
	
public void collisionDetection(){
	for (GameObject g : getGameObjects()){
		for (GameObject h : getGameObjects()){
			if(!g.isCollided()||!h.isCollided()){
			if (g.getRect()!=null&&h.getRect()!=null)
			if((h != g)&&(h.getRect().overlaps(g.getRect()))){
				if (h.getId()!=g.getId()){
					if (g instanceof Player & h instanceof PowerUp) {
						((Player)g).setInitialHp(999f);
					System.out.println("lol?");	
					}
					if (g instanceof PowerUp & h instanceof Player) {
						((Player)h).setInitialHp(999f);
					System.out.println("2lol");
					}
				g.setAboutToDie(true); // Schwachstelle.. mehr als 2 Objekte können somit nicht kollidieren
				h.setAboutToDie(true);
				if (!(g instanceof HMinorExplosion)) g.setCollided(true); // wird auch nicht zurückgesetzt
				if (!(h instanceof HMinorExplosion)) h.setCollided(true);
				createMinorExplosion(g.getPosition().x,g.getPosition().y);
				if (g instanceof Player) ((Player) g).setHp(0);
				if (h instanceof Player) ((Player) h).setHp(0);
				
				}
			}
			}
		}
	}
}
	
	public void update(){
		
		if (player.getHp()<=0) initialize();
		for (GameObject obj : incomingObjects){
			gameObjects.add(obj); // addet erst mal die Incoming Objects
		}
		incomingObjects.clear();
		collisionDetection();
		for (GameObject obj : gameObjects){
			obj.update(); // wichtigstes Update
			if (obj.wantsToCreateObject()){ // Schaut nach, ob das GO Objekte launchen/erstellen will!
				for (GameObject inc : obj.getToBeGeneratedGameObjects()){
					incomingObjects.add(inc);
				}
				obj.setWantsToCreateObject(false); // setzt den Wunsch, ein Obj zu erzeugen, auf false
				obj.getToBeGeneratedGameObjects().clear(); // cleared die ArrayListe des Obj
			}
		}
		
		releaseDeadGameObjects();
		
	}
	public void render(SpriteBatch batch){
		
		
		for (GameObject obj : gameObjects){
			obj.render(batch);
		}
		
	}
	
	public void releaseDeadGameObjects(){
	for (int i = 0; i <gameObjects.size();i++){
		//if ((gameObjects.get(i) instanceof Player)) gameObjects.get(i).setAboutToDie(false);
		if(gameObjects.get(i).isAboutToDie()) gameObjects.remove(i);
	}
	}
	
	public ArrayList<GameObject> getGameObjects() {
		return gameObjects;
	}

	public void setGameObjects(ArrayList<GameObject> gameObjects) {
		this.gameObjects = gameObjects;
	}

	public static Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
