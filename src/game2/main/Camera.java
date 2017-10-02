package game2.main;

public class Camera {
	private float x,y;
	public Camera(float x, float y) {
		this.x=x;
		this.y=y;
	}
	public void tick(GameObject go) {
		x+=((go.getX()-x)-1080/2)*0.05f;
		y+=((go.getY()-y)-810/2)*0.05f;
		if(x<=0)x=0;
		else if(x>980)x=980;
		if(y<0)y=0;
		else if(y>1275)y=1275;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	
}
