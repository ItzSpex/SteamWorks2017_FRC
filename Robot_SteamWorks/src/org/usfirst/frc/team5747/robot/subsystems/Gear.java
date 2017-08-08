package org.usfirst.frc.team5747.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gear extends Subsystem {
	public static final double GEAR_OPEN_FULL = 0.9;
	
	private SpeedController motor;

	public Gear(SpeedController motor) {
		this.motor = motor;
	}

	public void open(double speed) {
		motor.set(speed);

	}

	
	

	public void initDefaultCommand() {

	}
}
