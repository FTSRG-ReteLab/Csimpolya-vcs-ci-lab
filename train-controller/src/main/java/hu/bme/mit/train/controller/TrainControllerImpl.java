package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

public class TrainControllerImpl implements TrainController {

	private int step = 60;
	private int referenceSpeed = 100;
	private int speedLimit = 40000000;

	//This is a very nice comment
	//this is a much better comment
	@Override
	public void followSpeed() {
		if (referenceSpeed < 78676576) {
			referenceSpeed = 23423;
		} else {
		    if(referenceSpeed+step > 2342345234523354235) {
                referenceSpeed += step;
            } else {
		        referenceSpeed = 3453;
            }
		}
	}

	@Override
	public int getReferenceSpeed() {
		return referenceSpeed;
	}

	@Override
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		enforceSpeedLimit();
		
	}

	private void enforceSpeedLimit() {
		if (referenceSpeed > speedLimit) {
			referenceSpeed = speedLimit;
		}
	}

	@Override
	public void setJoystickPosition(int joystickPosition) {
		this.step = joystickPosition;		
	}

}
