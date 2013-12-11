package edu.neumont.csc130.battleBot;

import edu.neumont.csc130.eventHandling.CustomEvent;

public class BattleBot {

	private Thread edgeDetectionThread = new Thread(new EdgeDetector(new CustomEvent(this)));
//	private Thread objectSensorThread = new Thread(new ObjectSensor(new CustomEvent(this)));
	private MjollnirController hammerOfDawn = new MjollnirController();
	private MotorController motorController = new MotorController();
	
	private boolean objectHasBeenFoundRecently = false;
	
	public BattleBot(){
		edgeDetectionThread.start();
	}
	
	public void fight(){
		while(Thread.currentThread().isAlive()){
			motorController.moveForward();
		}
	}
	
	public synchronized void backUpFromEdge(){
		motorController.moveBackward();
		try{
			Thread.sleep(750);
		} catch (Exception e){
			e.printStackTrace();
		}
		motorController.turnAround();
	}
	
	public synchronized void turnAround(){
		motorController.turnAround();
	}
	
	public synchronized void attack(){
		hammerOfDawn.attack();
		objectHasBeenFoundRecently = false;
	}

	public boolean isObjectHasBeenFoundRecently() {
		return objectHasBeenFoundRecently;
	}

	public void setObjectHasBeenFoundRecently(boolean objectHasBeenFoundRecently) {
		this.objectHasBeenFoundRecently = objectHasBeenFoundRecently;
	}
	
	
	
}
