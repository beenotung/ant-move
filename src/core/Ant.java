package core;

import myutils.Colors;
import myutils.Vector2D;

public class Ant {
	Vector2D location, velocity, dest;
	int color = Colors.get(1, 0.5, 0);
	//float rate = 0.05f;
	float rate = 0.1f;

	public Ant(Vector2D location) {
		this.location = location;
		velocity = new Vector2D();
		dest = location.clone();
	}

	public void findDest(Ant ant) {
		dest = ant.location.clone();
	}

	public void move() {
		velocity = Vector2D.subtract(dest, location);
		velocity.multiply(rate);
		location.add(velocity);
	}
}
