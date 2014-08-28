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
	private Vector2D lastMouseMove;

	public AntMoveFrame(int width, int height, int scale, double nsPerTick, double nsPerRender, int pl) {
		super(width, height, scale, TITLE, nsPerTick, nsPerRender);
		this.pl = pl;
	}

	private void checkant() {
		if (ants.size() >= pl)
			ants.remove(0);
	}
	private void addant(int I) {
		for (int i = 0; i < I; i++)
			{Ant ant=new Ant(new Vector2D((Utils.random.nextFloat() * 2 - 1) * cx,
					(Utils.random.nextFloat() * 2 - 1) * cy));
			ant.color=Utils.random.nextInt(Colors.get(1, 1, 1));
			ants.add(ant);}
	}

	@Override
	protected void init() {
		ants = new ArrayList<Ant>();
		addant(1);
		lastMouseMove=new Vector2D(cx,cy);
	}

	@Override
	protected void myTick() {
		checkant();
		/*if (!((mouseHandler.mouseMoved.locationRelativeAbsolute.x==lastMouseMove.x)&&(mouseHandler.mouseMoved.locationRelativeAbsolute.y==lastMouseMove.y))){
			lastMouseMove=mouseHandler.mouseMoved.locationRelativeAbsolute.clone();
			ants.add(new Ant(lastMouseMove.clone()));
		}*/
		addant(1);
		// ants.get(0).findDest(ants.get(ants.size()-1));
		/*
		 * ants.get(0).dest.x = mouseHandler.mouseMoved.x / SCALE - cx;
		 * ants.get(0).dest.y = mouseHandler.mouseMoved.y / SCALE - cy;
		 */
		ants.get(0).findDest(ants.get(ants.size()-1));
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
