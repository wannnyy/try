package component;

import java.util.ArrayList;
import java.util.List;

public class Map {
	private List<Entity> objectContainer;

	public Map() {
		objectContainer = new ArrayList<Entity>();
	}

	public ArrayList<Entity> buildMap1() {
		Tree tree, tree1;
		Hole hole;
		Rock rock;
		Wall wall1;
		tree = new Tree(200, 400);
		tree1 = new Tree(400, 400);
		hole = new Hole(100, 200);
		wall1 = new Wall(350, 250, 20, 70);
		rock = new Rock(300, 300);
		objectContainer.add(tree);
		objectContainer.add(tree1);
		objectContainer.add(hole);
		objectContainer.add(wall1);
		objectContainer.add(rock);
		return (ArrayList<Entity>) objectContainer;
	}
	public ArrayList<Entity> buildMap2() {
		Tree tree, tree1;
		Hole hole;
		Rock rock;
		Wall wall1;
		tree = new Tree(200, 400);
		tree1 = new Tree(400, 400);
		hole = new Hole(100, 200);
		wall1 = new Wall(350, 250, 20, 70);
		rock = new Rock(300, 300);
		objectContainer.add(tree);
		objectContainer.add(tree1);
		objectContainer.add(hole);
		objectContainer.add(wall1);
		objectContainer.add(rock);
		return (ArrayList<Entity>) objectContainer;
	}
}
