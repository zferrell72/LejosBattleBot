package edu.neumont.csc130.battleBot;

import java.util.Timer;
import java.util.TimerTask;

import edu.neumont.csc130.eventHandling.CustomEvent;
import edu.neumont.csc130.eventHandling.CustomListener;

public class CustomTimer implements CustomListener {

	private Thread currentThread = Thread.currentThread();
	private CustomEvent battleBotReference = null;
	
	private Timer myTimer = new Timer();
	
	public CustomTimer(CustomEvent event){
		battleBotReference = event;
		myTimer.schedule(new myTask(), 5000, 5000);
	}
	
	@Override
	public void eventFired(CustomEvent event) {
		// Tell robot to turn around
		BattleBot theBot = (BattleBot) battleBotReference.getSource();
		theBot.turnAround();
	}

	@Override
	public void run() {
		// While thread has not been interrupted
		while(!currentThread.isInterrupted()){
			
		}
	}
	
	private class myTask extends TimerTask {

		@Override
		public void run() {
			// check if objectHasNotBeenFound
			BattleBot theBot = (BattleBot) battleBotReference.getSource();
			if(!theBot.isObjectHasBeenFoundRecently()){
				// Fire Event
				eventFired(battleBotReference);
			}
		}
		
	}

}
