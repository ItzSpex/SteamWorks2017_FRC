package org.usfirst.frc.team5747.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	public static final double SHOOTING_SPEED = 0.8;
    private SpeedController wheelMotor;
    
    
    public Shooter(SpeedController wheelMotor){
    	this.wheelMotor = wheelMotor;
    }
    
    public void shoot (double speed){
    	wheelMotor.set(speed);
    	
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

