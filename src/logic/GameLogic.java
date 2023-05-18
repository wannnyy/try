package logic;

import java.util.ArrayList;
import java.util.List;

import component.Entity;
import component.Field;
import component.GolfBall;
import component.Hole;
import component.Map;
import component.Obstacle;
import component.Rock;
import component.Tree;
import component.Wall;
import main.Main;
import sharedObject.RenderableHolder;

public class GameLogic {
//	private static GameLogic instance = null;
	private List<Entity> gameObjectContainer;
	private int shotCounter;
	private int maxShot;

	private List<Obstacle> obstacle;
	private GolfBall golfBall;
	private Tree tree, tree1;
	private Hole hole;
	private Rock rock;
	private Wall wall1;
	private final Map map = new Map();

	public GameLogic(Main main) {
		this.maxShot = 8;
		Field field = new Field();
		shotCounter = 0;
		RenderableHolder.getInstance().add(field);
		this.gameObjectContainer = new ArrayList<Entity>();
		this.obstacle = new ArrayList<Obstacle>();
		selectMap(main.getSelectedMap());
	}

	public void selectMap(String selectedMap) {
		if (selectedMap.equals("Option 1")) {
			ArrayList<Entity> map1 = map.buildMap1();
			golfBall = new GolfBall(600, 400, this);
			hole = new Hole(100, 200);
			addNewObject(golfBall);
			addNewObject(hole);
			this.maxShot = 5;
			for (Entity e : map1) {
				addNewObject(e);
			}

		} else if (selectedMap.equals("Option 2")) {
			golfBall = new GolfBall(600, 400, this);
			tree = new Tree(200, 400);
			tree1 = new Tree(400, 400);
			hole = new Hole(100, 200);
			wall1 = new Wall(350, 250, 20, 70);
			rock = new Rock(300, 300);
			addNewObject(golfBall);
			addNewObject(rock);
			addNewObject(tree);
			addNewObject(tree1);
			addNewObject(hole);
			this.maxShot = 8;

		} else {
			golfBall = new GolfBall(600, 400, this);
			tree = new Tree(200, 400);
			tree1 = new Tree(400, 400);
			hole = new Hole(100, 200);
			wall1 = new Wall(350, 250, 20, 70);
			rock = new Rock(300, 300);
			addNewObject(golfBall);
			addNewObject(rock);
			addNewObject(tree);
			addNewObject(hole);
			addNewObject(wall1);
			this.maxShot = 4;
		}
	}

	public List<Entity> getGameObjectContainer() {
		return gameObjectContainer;
	}

	public void setGameObjectContainer(List<Entity> gameObjectContainer) {
		this.gameObjectContainer = gameObjectContainer;
	}

	public List<Obstacle> getObstacle() {
		return obstacle;
	}

	public int getMaxShot() {
		return maxShot;
	}

	public void setMaxShot(int maxShot) {
		this.maxShot = maxShot;
	}

	public void setObstacle(List<Obstacle> obstacle) {
		this.obstacle = obstacle;
	}

	protected void addNewObject(Entity entity) {
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
		if (entity instanceof Obstacle) {
			obstacle.add((Obstacle) entity);
		}
	}

	public void logicUpdate() {
		shotCounter = golfBall.getShotCount();
		golfBall.update();
		for (Obstacle e : obstacle) {
			if (golfBall.collideWith(e) && !e.isDestroyed()) {
				System.out.println("hit");
				e.onCollision(golfBall);
			}
		}
		if (hole.isBallInHole(golfBall) && golfBall.getSpeed() == 0) {
			System.out.println("GameEnded");
		}
	}

	public int getShotCounter() {
		return shotCounter;
	}

	public void setShotCounter(int shotCounter) {
		this.shotCounter = shotCounter;
	}
}
