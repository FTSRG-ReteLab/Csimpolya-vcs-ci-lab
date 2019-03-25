package hu.bme.mit.train.system;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.user.TrainUserImpl;

public class TrainSystem implements Runnable{

	private TrainController controller = new TrainControllerImpl();
	private TrainUser user = new TrainUserImpl(controller);
	private TrainSensor sensor = new TrainSensorImpl(controller, user);
	
	public TrainSystem() {
		new Thread(this).start();
	}

	public TrainController getController() {
		return controller;
	}
	
	public TrainSensor getSensor() {
		return sensor;
	}

	public TrainUser getUser() {
		return user;
	}

	@Override
	public void run() {
		while(true) {
			try {
				this.wait(500);
				this.controller.followSpeed();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
