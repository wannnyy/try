package component;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class Field implements IRenderable {

	@Override
	public int getZ() {
		return -9999;
	}

	@Override
	public void draw(GraphicsContext gc) {
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
