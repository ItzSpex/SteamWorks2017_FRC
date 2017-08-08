package org.usfirst.frc.team5747.robot.subsystems;

import org.usfirst.frc.team5747.robot.Robot;
import org.usfirst.frc.team5747.robot.commands.DriveArcade;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
	public static final double DRIVING_SPEED = 0.7;
	private SpeedController leftDrive;
	private SpeedController rightDrive;

	public Drivetrain(SpeedController leftDrive, SpeedController rightDrive) {
		this.leftDrive = leftDrive;
		this.rightDrive = rightDrive;
	}

	public void move(double leftSpeed, double rightSpeed) {
		leftDrive.set(-leftSpeed);
		rightDrive.set(rightSpeed);
	}

	

	public void initDefaultCommand() {
		setDefaultCommand(new DriveArcade(Robot.drivetrain, Robot.oi::getForwardDriver, Robot.oi::getRotationDriver));
	}

}
