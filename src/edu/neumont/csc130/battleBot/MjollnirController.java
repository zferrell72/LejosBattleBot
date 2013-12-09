package edu.neumont.csc130.battleBot;

import lejos.nxt.Motor;
import lejos.nxt.MotorPort;
import lejos.nxt.NXTRegulatedMotor;

public class MjollnirController {
	NXTRegulatedMotor hammerMotor;
	public static final int OVER_POWER = 1100;
	
	public MjollnirController(){
		hammerMotor = new NXTRegulatedMotor(MotorPort.A);
		hammerMotor.setSpeed(OVER_POWER);
	}
	
	public void setSpeed(int motorSpeed){
		hammerMotor.setSpeed(motorSpeed);
	}
	
	public void stopHammerMovement(){
		hammerMotor.stop();
	}
	
	public int getSpeed(){
		return hammerMotor.getSpeed();
	}
	
	public void attack(){
		moveClockwise();
		moveCounterClockwise();
	}

	public boolean isHammerMoving(){
		return hammerMotor.isMoving();
	}
	
	private void moveCounterClockwise() {
		Motor.A.backward();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Was Moveing CounterClockwise");
		}
		Motor.A.stop();
	}

	private void moveClockwise() {
		Motor.A.forward();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Was Moveing Clockwise");
		}
		Motor.A.stop();
	}
}
