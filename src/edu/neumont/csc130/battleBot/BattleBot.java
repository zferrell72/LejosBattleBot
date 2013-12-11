package edu.neumont.csc130.battleBot;

import edu.neumont.csc130.eventHandling.CustomEvent;

public class BattleBot {

	private Thread edgeDetectionThread = new Thread(new EdgeDetector(new CustomEvent(this)));
	private Thread objectSensorThread = new Thread(new ObjectDetector(new CustomEvent(this)));
	private CustomTimer turnAroundTimer = new CustomTimer(new CustomEvent(this)); 
	private MjollnirController hammerOfDawn = new MjollnirController();
	private MotorController motorController = new MotorController();
	
	private boolean objectHasBeenFoundRecently = false;
	
	public BattleBot(){
		edgeDetectionThread.start();
		objectSensorThread.start();
	}
	
	public void fight(){
		while(Thread.currentThread().isAlive()){
			motorController.moveForward();
		}
	}
	
	public void backUpFromEdge(){
		motorController.moveBackward();
		try{
			Thread.sleep(750);
		} catch (Exception e){
			e.printStackTrace();
		}
		motorController.turnAround();
	}
	
	public void turnAround(){
		motorController.turnAround();
	}
	
	public void stop(){
		motorController.stopBoth();
	}
	
	public void attack(){
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
