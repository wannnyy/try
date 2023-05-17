package component;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class Field implements IRenderable {

	private static int[][] field = { { 0, 0, 0, 0, 0, 0, 0, 0, -1, 0,0 ,0},
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0,0},
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,1,0}, 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,2,1},

			{ 0, 0, 0, 0, 0, 0, -2, 0, 0, 0 ,0,1},
			{ 0, -2, 0, 0, 0, 0, 0, 0, 0, 0 ,1,0},
			{ 0, 0, 0, 0, -1, 0, 0, 0, 0, 0 ,2,0},
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0,1} };

	public int getTerrain(int x, int y) {
		if (x < 0 || x >= field[0].length || y < 0 || y >= field.length)
			return -3;
		return field[y][x];
	}

	private int getTileIndex(int x, int y) {
		int terrain = getTerrain(x, y);
		if (terrain <= 0 && terrain >= -2)
			return -terrain;
		else
			return 0;
	}

	@Override
	public int getZ() {
		return -9999;
	}

	@Override
	public void draw(GraphicsContext gc) {
//		for (int x = 0; x <= field[0].length; x++) {
//			for (int y = 0; y <= field.length; y++) {
//				WritableImage croppedImage = new WritableImage(RenderableHolder.mapSprite.getPixelReader(),
//						getTileIndex(x, y) * 64, 0, 64, 64);
////				System.out.println(getTileIndex(x, y)*64);
//				gc.drawImage(croppedImage, x * 64, y * 64);
//			}
//		}
//		gc.setFill(Color.GREENYELLOW);
//		gc.fillRect(0,0, 800, 585);
		gc.drawImage(RenderableHolder.mapSprite, 0, 0);

	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}
}
