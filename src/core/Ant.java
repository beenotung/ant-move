package core;

import com.sun.org.apache.xml.internal.utils.NSInfo;

import myutils.Colors;
import myutils.Utils;
import myutils.Colors.RGB;
import myutils.Vector2D;

public class Ant {
	Vector2D acceleration,location, velocity, dest;	
	int color = Colors.get(1, 0.5, 0);
	// float rate = 0.05f;
	float rate = 0.01f;

	public Ant(Vector2D location) {
		this.location = location;
		velocity = new Vector2D();
		acceleration=new Vector2D();
		dest = location.clone();
	}

	public void findDest(Ant ant) {
		dest = ant.location.clone();
	}

	public void move() {
		//Vector2D distance=Vector2D.subtract(dest, location);
		//acceleration= dis
		//velocity.add(acceleration);
		velocity=Vector2D.subtract(dest, location);
		velocity.multiply(rate);
		location.add(velocity);
		if (Vector2D.subtract(dest, location).getMagnitude() < 1) {
			//setRandomColor();
			addRandomColor();
			findDestByColor();			
		}
	}

	public void findDestByColor() {
		float x = 0, y = 0;
		RGB rgb = Colors.decode(color);
		x += rgb.r;
		y += rgb.g;
		x -= rgb.b;
		y -= rgb.b;
		dest = new Vector2D(x, y);
	}

	public void setRandomColor() {
		color = Utils.random.nextInt(Colors.get(1, 1, 1));
	}
	public void addRandomColor() {
		int ve=1;
		if(Utils.random.nextBoolean())ve*=-1;
		//color += Utils.random.nextInt(Colors.get(1, 1, 1))*ve*0.01;
		int n=10;
		//color+=Utils.random.nextInt(n*2)-n;
		color+=1f/rate;
	}
}
