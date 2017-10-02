package game2.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject{
	private Handler handler;
	public Bullet(int x, int y, ID id,Handler handler, int mx,int my) {
		super(x, y, id);
		this.handler=handler;
		int dist=(int) Math.hypot((mx-x), (my-y));
		dist/=8;
		velX=(mx-x)/dist;
		velY=(my-y)/dist;
		
	}

	public void tick() {
		x+=velX;
		y+=velY;
		for(int i=0;i<handler.objects.size();i++) {
			GameObject temp=handler.objects.get(i);
			if(temp.getId()==ID.Block) {
				if(temp.getBounds().intersects(this.getBounds())) {
					handler.removeObject(this);
				}
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.fillOval(x, y, 8, 8);
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x,y,8,8);
	}
	
}
