package core;

import myutils.Colors;
import myutils.Vector2D;

public class Ant {
	Vector2D location, velocity, dest;
	int color=Colors.get(1, 0.5, 0);

	public Ant(Vector2D location) {
		this.location = location;
		velocity = new Vector2D();
		dest=location.clone();
	}
}
