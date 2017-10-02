package game2.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class KeyInput extends KeyAdapter {
		
		private Handler handler;
		public KeyInput(Handler handler) {
			this.handler=handler;
		}
		public void keyPressed(KeyEvent e) {
			int key=e.getKeyCode();
			for(int i=0;i<handler.objects.size();i++)
			{
				GameObject temp=handler.objects.get(i);
				if(temp.getId()==ID.Player) {
					if(key==KeyEvent.VK_W)handler.setUp(true);
					if(key==KeyEvent.VK_S)handler.setDown(true);
					if(key==KeyEvent.VK_A)handler.setLeft(true);
					if(key==KeyEvent.VK_D)handler.setRight(true);
				}
			}
			if(key==KeyEvent.VK_ESCAPE)System.exit(69);
		}
		
		public void keyReleased(KeyEvent e) {
			int key=e.getKeyCode();
			for(int i=0;i<handler.objects.size();i++)
			{
				GameObject temp=handler.objects.get(i);
				if(temp.getId()==ID.Player) {
					if(key==KeyEvent.VK_W)handler.setUp(false);
					if(key==KeyEvent.VK_S)handler.setDown(false);
					if(key==KeyEvent.VK_A)handler.setLeft(false);
					if(key==KeyEvent.VK_D)handler.setRight(false);
				}
			}
		}
}
