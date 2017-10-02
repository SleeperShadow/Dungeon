package game2.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Wizard extends GameObject{
	Handler handler;
	public Wizard(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		this.handler=handler;
	}

	
	public void tick() {
		x+=velX;
		y+=velY;
		collision();
		if(handler.isUp())velY=-5;
		else if(!handler.isDown())velY=0;
		
		if(handler.isDown())velY=5;
		else if(!handler.isUp())velY=0;
		
		if(handler.isLeft())velX=-5;
		else if(!handler.isRight())velX=0;
		
		if(handler.isRight())velX=5;
		else if(!handler.isLeft())velX=0;
		
		
	}

	private void collision() {
		for(GameObject i:handler.objects) {
			if(i.getId()==ID.Block) {
				if(getBounds().intersects(i.getBounds())) {
					x+=velX*(-1);
					y+=velY*(-1);
				}
					
			}
		}
	}
	public void render(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fill3DRect(x, y, 32, 32, true);
		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle(x,y,32,32);
	}
	
}
