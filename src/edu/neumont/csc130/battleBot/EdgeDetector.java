package edu.neumont.csc130.battleBot;

import edu.neumont.csc130.eventHandling.CustomEvent;
import edu.neumont.csc130.eventHandling.CustomListener;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

public class EdgeDetector implements CustomListener {

	private LightSensor edgeSensor = new LightSensor(SensorPort.S4);
	
	private CustomEvent battleBotReference;
	private Thread currentThread = Thread.currentThread();
	
	public EdgeDetector(CustomEvent battleBotReference){
		edgeSensor.calibrateHigh();
		this.battleBotReference = battleBotReference;
	}
	
	public boolean edgeFound(){
		return edgeSensor.readValue() > edgeSensor.getHigh();
	}

	@Override
	public void eventFired(CustomEvent event) {
		BattleBot battleBot = (BattleBot) event.getSource();
		battleBot.backUpFromEdge();
	}
	
	@Override
	public void run() {
		// Loop forever!
		while(!currentThread.isInterrupted()){
			//Check if the edge has been found
			if(edgeFound()){
				// If it has, fire that event!
				this.eventFired(battleBotReference);
			}
		}
	}

	public LightSensor getEdgeSensor() {
		return edgeSensor;
	}

	public void setEdgeSensor(LightSensor edgeSensor) {
		this.edgeSensor = edgeSensor;
	}
	
	public Thread getEdgeDetectorThread(){
		return currentThread;
	}
	
	
}
