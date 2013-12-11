package edu.neumont.csc130.battleBot;

import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import edu.neumont.csc130.eventHandling.CustomEvent;
import edu.neumont.csc130.eventHandling.CustomListener;

public class ObjectDetector implements CustomListener{

	private UltrasonicSensor ultraSonic = new UltrasonicSensor(SensorPort.S2);
	private CustomEvent battleBotReference;
	private int visualRange = 20;
	private Thread thisThread = Thread.currentThread();
	
	public ObjectDetector(CustomEvent battleBotReference) {
		this.battleBotReference = battleBotReference;
	}
	
	@Override
	public void eventFired(CustomEvent event) {
		// Have the battle bot do something
		BattleBot theBot = (BattleBot)event.source;
		System.out.println("IN DAT EVENT");
		theBot.setObjectHasBeenFoundRecently(true);
		theBot.attack();
	}

	@Override
	public void run() {
		//while forever
		while(!thisThread.isInterrupted()){
			//Check if the object within visual range
			if(isObjectInSensor()){
				// If it has, fire that event!
				System.out.println("FOUND IT!");
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
	
	public boolean isObjectInSensor(){
		return ultraSonic.getDistance() <= visualRange;
	}
}