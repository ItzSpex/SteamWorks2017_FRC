package org.usfirst.frc.team5747.robot.commands;

import java.util.function.Supplier;

import org.usfirst.frc.team5747.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command moves a {@link TankDrivetrain} using the arcade control method used written by WPILIB.
 *
 * @author Unknown
 */
public class DriveArcade extends Command {
    private org.usfirst.frc.team5747.robot.subsystems.Drivetrain Drivetrain;
    private Supplier<Double> moveValueSupplier;
    private Supplier<Double> rotateValueSupplier;

    /**
     * This constructs a new {@link DriveArcade} command
     * that moves the given {@link TankDrivetrain} forward while also turning according the WPILIB's arcade drive.
     *
     * @param drivetrain  the drivetrain this command requires and moves.
     * @param moveValue   the speed to move forward with. Negative values go backwards.
     * @param rotateValue the speed to turn with. Negative values turn right.
     */
    public DriveArcade(Drivetrain drivetrain, double moveValue, double rotateValue) {
        this(drivetrain, () -> moveValue, () -> rotateValue);
    }

    /**
     * This constructs a new {@link DriveArcade} command
     * that moves the given {@link TankDrivetrain} forward while also turning using changing speeds according the WPILIB's arcade drive.
     *
     * @param drivetrain  the drivetrain this command requires and moves.
     * @param moveValueSupplier   the double {@link Supplier} supplying the speed to move forward with. Negative values go backwards.
     * @param rotateValueSupplier the double {@link Supplier} supplying the speed to turn with. Negative values go right.
     */
    public DriveArcade(Drivetrain drivetrain, Supplier<Double> moveValueSupplier, Supplier<Double> rotateValueSupplier) {
        requires(drivetrain);
        this.Drivetrain = drivetrain;
        this.moveValueSupplier = moveValueSupplier;
        this.rotateValueSupplier = rotateValueSupplier;
    }

    @Override
    protected void initialize() {
        

    }

    @Override
    protected void execute() {
        double leftSpeed, rightSpeed;
        double moveValue = moveValueSupplier.get();
        double rotateValue = rotateValueSupplier.get();
        if (moveValue > 0.0) {
            if (rotateValue > 0.0) {
                leftSpeed = moveValue - rotateValue;
                rightSpeed = Math.max(moveValue, rotateValue);
            } else {
                leftSpeed = Math.max(moveValue, -rotateValue);
                rightSpeed = moveValue + rotateValue;
            }
        } else {
            if (rotateValue > 0.0) {
                leftSpeed = -Math.max(-moveValue, rotateValue);
                rightSpeed = moveValue + rotateValue;
            } else {
                leftSpeed = moveValue - rotateValue;
                rightSpeed = -Math.max(-moveValue, -rotateValue);
            }
        }
        Drivetrain.move(leftSpeed, rightSpeed);
    }

    @Override
    protected boolean isFinished() {
        
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        Drivetrain.move(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
