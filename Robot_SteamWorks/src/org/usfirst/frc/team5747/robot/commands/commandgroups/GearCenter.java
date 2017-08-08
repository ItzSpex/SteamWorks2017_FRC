package org.usfirst.frc.team5747.robot.commands.commandgroups;

import org.usfirst.frc.team5747.robot.commands.Drive;
import org.usfirst.frc.team5747.robot.commands.GearCommand;
import org.usfirst.frc.team5747.robot.subsystems.Gear;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearCenter extends CommandGroup {
	public static final double DRIVE_SPEED = 0.7;
	
    public GearCenter() {
        addSequential(new Drive(DRIVE_SPEED,DRIVE_SPEED), 3);
        addSequential(new GearCommand(Gear.GEAR_OPEN_FULL));
        addSequential(new Drive(-DRIVE_SPEED,-DRIVE_SPEED), 3);
    }
}
