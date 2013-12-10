package edu.neumont.csc130.battleBot;

import edu.neumont.csc130.eventHandling.CustomEvent;

public class BattleBot {

	private Thread edgeDetectionThread = new Thread(new EdgeDetector(new CustomEvent(this)));
	private MjollnirController hammerOfDawn = new MjollnirController();
	private MotorController motorController = new MotorController();
	
	public BattleBot(){
		edgeDetectionThread.run();
	}
	
	public void fight(){
		 motorController.moveForward();
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
	
}
