package gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PowerUp extends MovableObject{

	public PowerUp(float x, float y) {
		super(x, y);
		setImageAndRect("img/explosion03.png");
		rect=null;
		scaler = 1.01f;
		//setTimeToDie(12);
		setId(99);
	}
	public void render(SpriteBatch batch){
		//shieldSprite.draw(batch, alphaModulation
//		Color c = batch.getColor();
//		batch.setColor(c.r, c.g, c.b, .1f);//set alpha to 0.3
		//batch.draw(img,position.x,position.y);
//		batch.setColor(c.r, c.g, c.b, 1f);//set alpha to 0.3
		batch.draw(img,position.x,position.y,width2,height2,width,height,scaler,scaler,0f,0,0,img.getWidth(),img.getHeight(),false,false);
		Color c = batch.getColor();
		batch.setColor(c.r, c.g, c.b, .5f);//set alpha to 0.3
		batch.draw(img,position.x,position.y,width2,height2,width,height,scaler*2,scaler*2,scaler*370,0,0,img.getWidth(),img.getHeight(),false,false);
		batch.setColor(c.r, c.g, c.b, 1f);//set alpha to 0.3
	}
	public void update(){
		//if(timeToDie.update()) aboutToDie = true;
		//scaler+=0.1f;
		System.out.println(isCollided());
	}
	
}
