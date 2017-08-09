package org.usfirst.frc.team5747.robot.subsystems;

import org.usfirst.frc.team5747.robot.Robot;
import org.usfirst.frc.team5747.robot.commands.DriveOmni;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Omni extends Subsystem {
	
	private SpeedController motor;
	
	public Omni(SpeedController motor) {
		this.motor = motor;
	}
	public void moveSideways(double rightSpeed, double leftSpeed) {
		if (rightSpeed > 0) {
			motor.set(rightSpeed);
		}else if (leftSpeed < 0){
			motor.set(leftSpeed);
			}else if (rightSpeed == 0 && leftSpeed == 0) {
				motor.set(0);
			}
	}
    
    public void initDefaultCommand() {
        setDefaultCommand(new DriveOmni(Robot.omni, Robot.oi::getSidewaysRight, Robot.oi::getSidewaysLeft));
    }
}

