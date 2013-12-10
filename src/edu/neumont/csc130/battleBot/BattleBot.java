package edu.neumont.csc130.battleBot;

public class BattleBot {

	private Thread edgeDetectionThread = new Thread(new EdgeDetector());
	private MjollnirController hammerOfDawn = new MjollnirController();
	
	// This shouldn't be here in the final product
	private MotorController theMotors = new MotorController();
	
	public BattleBot(){
		edgeDetectionThread.run();
	}
	
	public void fight(){
		theMotors.moveForward();
	}
	
}
