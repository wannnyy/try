package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;


public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	public static Image mapSprite;
	public static Image mineSprite,treeSprite;
	public static AudioClip  hitSound;
	public static AudioClip treeHit ;
	public static AudioClip rockHit ;
	public static Image rockSprite;

	static {
		loadResource();
	}

	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}

	public void setEntities(List<IRenderable> entities) {
		this.entities = entities;
	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public static void loadResource() {
		mapSprite = new Image(ClassLoader.getSystemResource("Grasses.png").toString());
		treeSprite = new Image(ClassLoader.getSystemResource("tree.png").toString());
		hitSound = new AudioClip(ClassLoader.getSystemResource("hitsound.mp3").toString());
		treeHit = new AudioClip(ClassLoader.getSystemResource("treehit.mp3").toString());
		rockHit = new AudioClip(ClassLoader.getSystemResource("rockhit.mp4").toString());
		rockSprite =  new Image(ClassLoader.getSystemResource("rock.png").toString());
	}

	public void add(IRenderable entity) {
		System.out.println("add");
		entities.add(entity);
		Collections.sort(entities, comparator);
	}

	public void update() {
		for (int i = entities.size() - 1; i >= 0; i--) {
			if (entities.get(i).isDestroyed())
				entities.remove(i);
		}
	}

	public List<IRenderable> getEntities() {
		return entities;
	}
}
