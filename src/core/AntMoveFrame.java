package core;

import java.awt.Color;
import java.util.ArrayList;

import myutils.CanvasShell;
import myutils.Colors;
import myutils.Utils;
import myutils.Vector2D;

public class AntMoveFrame extends CanvasShell {
	private static final long serialVersionUID = 1L;
	public static String TITLE = "ant-move 1.0";

	public ArrayList<Ant> ants;

	public AntMoveFrame(int width, int height, int scale, double nsPerTick, double nsPerRender) {
		super(width, height, scale, TITLE, nsPerTick, nsPerRender);
	}

	@Override
	protected void init() {
		ants = new ArrayList<Ant>();
		for (int i = 0; i < 100; i++)
			ants.add(new Ant(new Vector2D((Utils.random.nextFloat() * 2 - 1) * cx,
					(Utils.random.nextFloat() * 2 - 1) * cy)));
	}

	@Override
	protected void myTick() {

	}

	@Override
	protected void myRender() {
		screen.clear(Colors.get(0, 0, 0));
		for (Ant ant : ants) {
			screen.add(ant.location, ant.color);
		}
	}

	@Override
	protected void myDebugInfo() {

	}

	@Override
	protected void myKeyHandling() {

	}

	@Override
	protected void myMouseHandling() {

	}
}
