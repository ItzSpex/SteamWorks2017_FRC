package org.usfirst.frc.team5747.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Feeder extends Subsystem {
	public static final double INTAKE_SPEED = 0.8;
	private SpeedController motor;
	
	public Feeder(SpeedController motor){
		this.motor = motor;
	}
	
	public void Intake(double speed){
		motor.set(speed);
	}
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

