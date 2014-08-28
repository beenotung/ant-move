package testing;

import core.AntMoveFrame;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("main start");

		int width = 800;
		int height = 600;
		int scale = 3;
		double nsPerTick = 1e9D / 100D;
		double nsPerRender = 1e9D / 60D;
		int pl=width*height/scale/10;
		AntMoveFrame antMoveFrame = new AntMoveFrame(width, height, scale,  nsPerTick,
				nsPerRender,pl);
		antMoveFrame.start();
		// cs.stop();
		System.out.println("main end");
	}

}
