package gameobjects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import game.Level;

public class Shield extends MovableObject{

	Sprite shieldSprite;
	
	public Shield(int x, int y, EntityObject owner) {
		super(x, y);
		this.owner = owner;
		setImageAndRect("img/shield.png");
		shieldSprite = new Sprite(img);
		this.setHp(10f);
		
	}

	public void update(){
		move();
		this.getRect().x=owner.position.x-owner.width;
		this.getRect().y=owner.position.y-owner.height;
	}
	
	public void move(){
		this.setPosition(owner.getPosition());
		
	}
	
	public void render(SpriteBatch batch){

		//shieldSprite.draw(batch, alphaModulation
//		Color c = batch.getColor();
//		batch.setColor(c.r, c.g, c.b, .1f);//set alpha to 0.3
		batch.draw(shieldSprite,position.x-(owner.width),position.y-(owner.height));
//		batch.setColor(c.r, c.g, c.b, 1f);//set alpha to 0.3
	}
	
}
