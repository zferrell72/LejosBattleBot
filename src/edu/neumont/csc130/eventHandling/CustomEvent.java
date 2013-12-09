package edu.neumont.csc130.eventHandling;

public class CustomEvent {
	
	public Object source;
	
	public CustomEvent(Object source){
		this.source = source;
	}
	
	public Object getSource(){
		return this.source;
	}
}
