package edu.neumont.csc130.battleBot;

import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import edu.neumont.csc130.eventHandling.CustomEvent;
import edu.neumont.csc130.eventHandling.CustomListener;

public class ObjectDetector implements CustomListener{

	private UltrasonicSensor ultraSonic = new UltrasonicSensor(SensorPort.S2);
	private CustomEvent battleBotReference;
	private int visualRange = 37;
	
	public ObjectDetector(CustomEvent battleBotReference) {
		this.battleBotReference = battleBotReference;
	}
	
	@Override
	public void eventFired(CustomEvent event) {
		// 
		BattleBot theBot = (BattleBot)event.source;
	}

	@Override
	public void run() {
		//while forever
		while(true){
			//Check if the object within visual range
			if(ultraSonic.getDistance() <= visualRange){
				// If it has, fire that event!
				eventFired(battleBotReference);
			}
		}
	}

	public int getVisualRange() {
		return visualRange;
	}

	public void setVisualRange(int visualRange) {
		this.visualRange = visualRange;
	}
}
