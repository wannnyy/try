package component;

import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import logic.CollidableEntity;
import logic.GameLogic;
import sharedObject.RenderableHolder;

public class GolfBall extends CollidableEntity {
	private GameLogic gameLogic;  
	public final double maxSpeed = 10;
	private int powerPercent;
	private int shotCount;
	private double speed, angle;
	private final double speedDecayRate = 0.25;

	public GolfBall(double x, double y , GameLogic gameLogic) {
		this.gameLogic = gameLogic;
		this.setPowerPercent(0);
		this.setSpeed(0);
		this.setShotCount(0);
		this.setX(x);
		this.setY(y);
		this.radius = 10;
	}

	public int getShotCount() {
		return shotCount;
	}

	public void setShotCount(int shotCount) {
		this.shotCount = shotCount;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public void move() {
		this.x += Math.cos(angle) * speed;
		this.y -= Math.sin(angle) * speed;
	}

	public double calculatePower() {
		double dx = x - InputUtility.mousePosX;
		double dy = y - InputUtility.mousePosY;
		double distance = Math.sqrt(dx * dx + dy * dy);
		double speed = distance / 10.0; // Adjust this value as necessary
		return Math.min(speed, 10.0); // Limit the speed to a maximum of 10.0 units per frame
	}

	public void update() {
		if (InputUtility.mouseRelease && this.getSpeed() == 0) {
			setSpeed(Math.min(maxSpeed, calculatePower()));
			InputUtility.mouseRelease = false;
			angle = calculateAngle();
			System.out.println(angle);
			RenderableHolder.hitSound.play();
			setShotCount(shotCount + 1);
		}
		if (speed != 0) {
			setSpeed(getSpeed() - speedDecayRate);
			hitGameScreen();
			move();
		}
	}

	public void hitGameScreen() {
		if (this.x <= this.radius || this.x >= 800 - this.radius) {
			hitObstacle();
		}
		if (this.y <= this.radius || this.y >= 640 - 75 - this.radius) {
			hitObstacle();
		}
	}

	public double calculateAngle() {
		double dx = this.x - InputUtility.mousePosX;
		double dy = -this.y + InputUtility.mousePosY;
		System.out.println("" + dx + " " + dy + " " + Math.atan2(dy, dx));
		return Math.atan2(dy, dx);
	}

	public void reverseXVelocity() {
		double currentAngle = angle;
		double currentXVelocity = speed * Math.cos(currentAngle);
		double currentYVelocity = speed * Math.sin(currentAngle);

		double newXVelocity = -currentXVelocity;
		double newYVelocity = currentYVelocity;

		speed = Math.sqrt(newXVelocity * newXVelocity + newYVelocity * newYVelocity);
		angle = Math.toDegrees(Math.atan2(newYVelocity, newXVelocity));
	}

	public void reverseYVelocity() {
		double currentAngle = angle;
		double currentXVelocity = speed * Math.cos(currentAngle);
		double currentYVelocity = speed * Math.sin(currentAngle);

		double newXVelocity = currentXVelocity;
		double newYVelocity = -currentYVelocity;

		speed = Math.sqrt(newXVelocity * newXVelocity + newYVelocity * newYVelocity);
		angle = Math.toDegrees(Math.atan2(newYVelocity, newXVelocity));
	}

	public int getPowerPercent() {
		return powerPercent;
	}

	public void setPowerPercent(int powerPercent) {
		this.powerPercent = powerPercent;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getX() {
		return this.x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getY() {
		return this.y;
	}

	public void setSpeed(double speed) {
		if (speed <= 0) {
			speed = 0;
		}
		this.speed = speed;
	}

	public double getSpeed() {
		return this.speed;
	}

	public void hitObstacle() {
		this.angle += Math.PI;
//		setSpeed(maxSpeed);
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.BLUE);
		gc.fillArc(x - radius, y - radius, radius * 2, radius * 2, 0, 360, ArcType.OPEN);
		gc.translate(x, y);
		gc.translate(-x, -y);

		if (speed == 0 && InputUtility.isDrag) {
			double dx = x - InputUtility.mousePosX;
			double dy = y - InputUtility.mousePosY;
			double distance = Math.sqrt(dx * dx + dy * dy); // Calculate the distance between the two points
			double arrowLength = Math.min(distance, 200); // Set arrowLength to the distance, but no more than 20.0
			double arrowWidth = 20;
			// Calculate the angle between the line and the x-axis
			double angle = Math.atan2(dy, dx);

			// Calculate the coordinates of the arrowhead
			double arrowEndX = x + arrowLength * Math.cos(angle);
			double arrowEndY = y + arrowLength * Math.sin(angle);
			double arrowTip1X = arrowEndX + arrowWidth * Math.cos(angle + Math.toRadians(135));
			double arrowTip1Y = arrowEndY + arrowWidth * Math.sin(angle + Math.toRadians(135));
			double arrowTip2X = arrowEndX + arrowWidth * Math.cos(angle - Math.toRadians(135));
			double arrowTip2Y = arrowEndY + arrowWidth * Math.sin(angle - Math.toRadians(135));

			// Draw the line with an arrowhead at the end
			gc.setStroke(Color.RED);
			gc.setLineWidth(4.0);
			gc.strokeLine(x, y, arrowEndX, arrowEndY);
			gc.strokeLine(arrowEndX, arrowEndY, arrowTip1X, arrowTip1Y);
			gc.strokeLine(arrowEndX, arrowEndY, arrowTip2X, arrowTip2Y);
		}

	}

}
