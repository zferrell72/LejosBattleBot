package edu.neumont.csc130.battleBot;

import lejos.nxt.MotorPort;
import lejos.nxt.NXTMotor;

public class MotorController {
  
    private NXTMotor leftMotor;
    private NXTMotor rightMotor;
    private NXTMotor hammerMotor;
    private final int turning = 35;
    private final int forward = 40;
    private final int fullPower = 100;
    private final int halfPower = 50;
    private final int backward = 30;

    public MovementController(){
        hammerMotor = new NXTMotor(MotorPort.A);
        leftMotor = new NXTMotor(MotorPort.B);
        rightMotor = new NXTMotor(MotorPort.C);
    }

    public void turnLeft(){
        rightMotor.setPower(turning);
        rightMotor.forward();
    }

    public void turnRight(){
        leftMotor.setPower(turning);
        leftMotor.forward();
    }

    public void moveForward(){
        rightMotor.setPower(forward);
        leftMotor.setPower(forward);
        rightMotor.forward();
        leftMotor.forward();
    }

    public void moveForwardFullSpeed(){
        rightMotor.setPower(fullPower);
        leftMotor.setPower(fullPower);
        rightMotor.forward();
        leftMotor.forward();
    }

    public void moveBackward(){
        rightMotor.setPower(backward);
        leftMotor.setPower(backward);
        rightMotor.backward();
        leftMotor.backward();
    }

    public void stopBoth(){
        rightMotor.stop();
        leftMotor.stop();
    }

    public void hammerFullSpeed(){
       while(true){
        try{
        hammerMotor.setPower(fullPower);
        hammerMotor.forward();
            Thread.sleep(500);
        hammerMotor.backward();
            Thread.sleep(500);
        }
        catch (Exception e){
            e.printStackTrace();
        }
       }

    }

    public void hammerHalfSpeed(){
        while(true){
            try{
                hammerMotor.setPower(halfPower);
                hammerMotor.forward();
                Thread.sleep(700);
                hammerMotor.backward();
                Thread.sleep(700);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public void turnAround(){
        try{
            turnLeft();
            Thread.sleep(2000);
        } catch (Exception e){
            e.printStackTrace();
        }

        stopBoth();
    }

    public NXTMotor getLeftMotor() {
        return leftMotor;
    }

    public void setLeftMotor(NXTMotor leftMotor) {
        this.leftMotor = leftMotor;
    }

    public NXTMotor getRightMotor() {
        return rightMotor;
    }

    public void setRightMotor(NXTMotor rightMotor) {
        this.rightMotor = rightMotor;
    }

    public NXTMotor getHammerMotor() {
        return hammerMotor;
    }

    public void setHammerMotor(NXTMotor hammerMotor) {
        this.hammerMotor = hammerMotor;
    }
}



    private NXTMotor leftMotor;
    private NXTMotor rightMotor;
    private NXTMotor hammerMotor;
    private final int turning = 35;
    private final int forward = 40;
    private final int fullPower = 100;
    private final int halfPower = 50;
    private final int backward = 30;

    public MovementController(){
        leftMotor = new NXTMotor(MotorPort.C);
        rightMotor = new NXTMotor(MotorPort.A);
        stopBoth();
    }

    public void turnLeft(){
        rightMotor.setPower(turning);
        rightMotor.forward();
    }

    public void turnRight(){
        leftMotor.setPower(turning);
        leftMotor.forward();
    }

    public void moveForward(){
        rightMotor.setPower(forward);
        leftMotor.setPower(forward);
        rightMotor.forward();
        leftMotor.forward();
    }

    public void moveForwardFullSpeed(){
        rightMotor.setPower(fullPower);
        leftMotor.setPower(fullPower);
        rightMotor.forward();
        leftMotor.forward();
    }

    public void moveBackward(){
        rightMotor.setPower(backward);
        leftMotor.setPower(backward);
        rightMotor.backward();
        leftMotor.backward();
    }

    public void stopBoth(){
        rightMotor.stop();
        leftMotor.stop();
    }

    public void hammerFullSpeed(){
       while(true){
        try{
        hammerMotor.setPower(fullPower);
        hammerMotor.forward();
            Thread.sleep(500);
        hammerMotor.backward();
            Thread.sleep(500);
        }
        catch (Exception e){
            e.printStackTrace();
        }
       }

    }

    public void hammerHalfSpeed(){
        while(true){
            try{
                hammerMotor.setPower(halfPower);
                hammerMotor.forward();
                Thread.sleep(700);
                hammerMotor.backward();
                Thread.sleep(700);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public void turnAround(){
        try{
            turnLeft();
            Thread.sleep(2000);
        } catch (Exception e){
            e.printStackTrace();
        }

        stopBoth();
    }

    public NXTMotor getLeftMotor() {
        return leftMotor;
    }

    public void setLeftMotor(NXTMotor leftMotor) {
        this.leftMotor = leftMotor;
    }

    public NXTMotor getRightMotor() {
        return rightMotor;
    }

    public void setRightMotor(NXTMotor rightMotor) {
        this.rightMotor = rightMotor;
    }

    public NXTMotor getHammerMotor() {
        return hammerMotor;
    }

    public void setHammerMotor(NXTMotor hammerMotor) {
        this.hammerMotor = hammerMotor;
    }
}
