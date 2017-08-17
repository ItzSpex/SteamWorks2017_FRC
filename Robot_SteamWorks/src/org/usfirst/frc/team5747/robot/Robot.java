
package org.usfirst.frc.team5747.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import org.usfirst.frc.team5747.robot.subsystems.Feeder;
import org.usfirst.frc.team5747.robot.subsystems.Gear;
import org.usfirst.frc.team5747.robot.subsystems.Omni;
import org.usfirst.frc.team5747.robot.commands.commandgroups.GearCenter;
import org.usfirst.frc.team5747.robot.commands.commandgroups.Line;
import org.usfirst.frc.team5747.robot.subsystems.Climber;
import org.usfirst.frc.team5747.robot.subsystems.Drivetrain;
import org.usfirst.frc.team5747.robot.subsystems.Shooter;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	
	public static OI oi;
	public static Drivetrain drivetrain;
	public static Shooter shooter;
	public static Feeder feeder;
	public static Gear gear;
	public static Climber climber;
	public static Omni omni;
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		drivetrain = new Drivetrain(
				new TalonSRX(RobotMap.PWM.DRIVE_LEFT_MOTOR), new TalonSRX(RobotMap.PWM.DRIVE_RIGHT_MOTOR));
		shooter = new Shooter(
				new VictorSP(RobotMap.PWM.WHEEL_MOTOR));
		feeder = new Feeder(
				new VictorSP(RobotMap.PWM.INTAKE_MOTOR));
		gear = new Gear(
				new VictorSP(RobotMap.PWM.GEAR_MOTOR));
		climber = new Climber(
				new TalonSRX(RobotMap.PWM.CLIMB_MOTOR));
		omni = new Omni(
				new Spark(RobotMap.PWM.OMNI_MOTOR));
		oi = new OI();
				
		chooser.addDefault("Line", new Line());
		chooser.addObject("Gear Center",new GearCenter());
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
