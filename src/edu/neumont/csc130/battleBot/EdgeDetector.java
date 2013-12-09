package edu.neumont.csc130.battleBot;

import edu.neumont.csc130.eventHandling.CustomEvent;
import edu.neumont.csc130.eventHandling.CustomListener;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

public class EdgeDetector implements CustomListener {

	private LightSensor edgeSensor = new LightSensor(SensorPort.S4);
	private MotorController motorController = new MotorController();
	
	public EdgeDetector(){
		edgeSensor.calibrateHigh();
	}
	
	public boolean edgeFound(){
		return edgeSensor.readValue() > edgeSensor.getHigh();
	}

	@Override
	public void eventFired(CustomEvent event) {
		// Back the robot up a small amount
		// Turn the robot around
	}
	
	@Override
	public void run() {
		// Loop forever!
			//Check if the edge has been found
				// If it has, fire that event!
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
