package org.usfirst.frc.team5747.robot.commands.commandgroups;

import org.usfirst.frc.team5747.robot.commands.Drive;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Line extends CommandGroup {
	public static final double DRIVE_SPEED = 0.7;
    public Line() {
    	addSequential(new Drive(DRIVE_SPEED,DRIVE_SPEED), 3);
    }
}
