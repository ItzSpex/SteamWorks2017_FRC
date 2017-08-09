package org.usfirst.frc.team5747.robot.commands;

import java.util.function.Supplier;

import org.usfirst.frc.team5747.robot.subsystems.Omni;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveOmni extends Command {
	private Omni holonomicDrivetrain;
	private Supplier<Double> speedXLeftSupplier , SpeedXRightSupplier;

	public DriveOmni(Omni drivetrain, double speedRightX, double speedLeftX) {
		// Use requires() here to declare subsystem dependencieslier
		// eg. requires(chassis);
		this(drivetrain,() -> speedLeftX, () -> speedRightX);

	}

	public DriveOmni(Omni drivetrain, Supplier<Double> speedXLeftSupplier, Supplier<Double> speedXRightSupplier) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(drivetrain);
		this.holonomicDrivetrain = drivetrain;
		this.speedXLeftSupplier = speedXLeftSupplier;
		this.SpeedXRightSupplier = speedXRightSupplier;

	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		holonomicDrivetrain.moveSideways(speedXLeftSupplier.get(), SpeedXRightSupplier.get());

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		holonomicDrivetrain.moveSideways(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
