package edu.neumone.csc130.eventHandling;

public interface CustomListener extends Runnable {
	public void eventFired(CustomEvent event);
	
	@Override
	public void run();
}
