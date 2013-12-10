package edu.neumont.csc130.battleBot;

import edu.neumont.csc130.eventHandling.CustomEvent;
import edu.neumont.csc130.eventHandling.CustomListener;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

public class EdgeDetector implements CustomListener {

	private LightSensor edgeSensor = new LightSensor(SensorPort.S4);
	private MotorController motorController = new MotorController();
	
	private Thread currentThread = Thread.currentThread();
	
	public EdgeDetector(){
		edgeSensor.calibrateHigh();
	}
	
	public boolean edgeFound(){
		return edgeSensor.readValue() > edgeSensor.getHigh();
	}

	@Override
	public void eventFired(CustomEvent event) {
		motorController.moveBackward();
		try{
			Thread.sleep(750);
		} catch (Exception e) {
			// opps
		}
		motorController.turnAround();
	}
	
	@Override
	public void run() {
		// Loop forever!
		while(!currentThread.isInterrupted()){
			//Check if the edge has been found
			if(edgeFound()){
				// If it has, fire that event!
				CustomEvent event = new CustomEvent(this);
				this.eventFired(event);
			}
		}
	}

	public LightSensor getEdgeSensor() {
		return edgeSensor;
	}

	public void setEdgeSensor(LightSensor edgeSensor) {
		this.edgeSensor = edgeSensor;
	}

	public MotorController getMotorController() {
		return motorController;
	}

	public void setMotorController(MotorController motorController) {
		this.motorController = motorController;
	}


	
	
	
}
