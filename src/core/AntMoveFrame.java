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
	private int pl;

	public ArrayList<Ant> ants;

	public AntMoveFrame(int width, int height, int scale, double nsPerTick, double nsPerRender,int pl) {
		super(width, height, scale, TITLE, nsPerTick, nsPerRender);
		this.pl=pl;
	}

	@Override
	protected void init() {
		ants = new ArrayList<Ant>();
		for (int i = 0; i < pl; i++)
			ants.add(new Ant(new Vector2D((Utils.random.nextFloat() * 2 - 1) * cx,
					(Utils.random.nextFloat() * 2 - 1) * cy)));
	}

	@Override
	protected void myTick() {
		// ants.get(0).findDest(ants.get(ants.size()-1));
		ants.get(0).dest.x = mouseHandler.mouseMoved.x / SCALE - cx;
		ants.get(0).dest.y = mouseHandler.mouseMoved.y / SCALE - cy;
		for (int i = 1; i < ants.size(); i++)
			ants.get(i).findDest(ants.get(i - 1));
		for (Ant ant : ants) {
			ant.move();
		}
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
