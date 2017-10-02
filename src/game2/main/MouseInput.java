package game2.main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter{
	private Handler handler;
	private Camera camera;
	public MouseInput(Handler handler,Camera camera) {
		this.handler=handler;
		this.camera=camera;
	}
	public void mousePressed(MouseEvent e) {
		int mx=(int)(e.getX()+camera.getX());
		int my=(int)(e.getY()+camera.getY());
		for(int i=0;i<handler.objects.size();i++) {
			GameObject temp=handler.objects.get(i);
			if(temp.getId()==ID.Player) {
				handler.addObject(new Bullet(temp.getX()+16,temp.getY()+24,ID.Bullet,handler,mx,my));
			}
		}
	}
}
