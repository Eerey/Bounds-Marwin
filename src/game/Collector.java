package game;

import gameobjects.Enemy;
import gameobjects.GameObject;
import gameobjects.Player;
import gameobjects.ARocket;

import java.util.ArrayList;

public class Collector {

	ArrayList<GameObject> players;
	ArrayList<GameObject> enemies;
	ArrayList<GameObject> playerProjectiles;
	ArrayList<GameObject> enemyProjectiles;
	
	public Collector(){
		
	}
	
	public void add(GameObject obj){
		if (obj instanceof Player) players.add(obj);
		if (obj instanceof Enemy) enemies.add(obj);
		if (obj instanceof ARocket)  if(((ARocket) obj).getOwner() instanceof Player) playerProjectiles.add(obj);
		if (obj instanceof ARocket)  if(((ARocket) obj).getOwner() instanceof Enemy) enemyProjectiles.add(obj);
	}
	
}
