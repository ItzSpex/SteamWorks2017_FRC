package org.usfirst.frc.team5747.robot;

import org.usfirst.frc.team5747.robot.commands.ClimbCommand;
import org.usfirst.frc.team5747.robot.commands.FeederCommand;
import org.usfirst.frc.team5747.robot.commands.GearCommand;
import org.usfirst.frc.team5747.robot.commands.ShootCommand;
import org.usfirst.frc.team5747.robot.subsystems.Climber;
import org.usfirst.frc.team5747.robot.subsystems.Feeder;
import org.usfirst.frc.team5747.robot.subsystems.Gear;
import org.usfirst.frc.team5747.robot.subsystems.Shooter;
import org.usfirst.frc.team5747.util.XboXUID;

import edu.wpi.first.wpilibj.buttons.Button;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private XboXUID Driver = new XboXUID(0);
	private XboXUID Opreator = new XboXUID(1);
	private Button shootingButton;
	private Button intakeButton;
	private Button gearButton;
	private Button climbButton;

	public OI() {
		shootingButton = Opreator.getLbButton();
		intakeButton = Opreator.getGreenButton();
		gearButton = Driver.getGreenButton();
		climbButton = Opreator.getYellowButton();
		opreator();
		driverbuttons();

	}

	public void opreator() {
		shootingButton.toggleWhenPressed(new ShootCommand(Shooter.SHOOTING_SPEED));
		intakeButton.whileHeld(new FeederCommand(Feeder.INTAKE_SPEED));
		climbButton.whileHeld(new ClimbCommand(Climber.CLIMB_FAST_SPEED));
	}

	public void driverbuttons() {
		gearButton.whileHeld(new GearCommand(Gear.GEAR_OPEN_FULL));
		
	}

	public double getForwardDriver() {
		return Driver.getLeftY();
	}
	
	public double getRotationDriver() {
		return Driver.getRightX();
	}
	
	
}