package org.usfirst.frc.team5747.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public interface PWM{
		public static final int DRIVE_LEFT_MOTOR = 1;
		public static final int DRIVE_RIGHT_MOTOR = 2;
		public static final int GEAR_MOTOR = 3;
		public static final int OMNI_MOTOR = 4;
		public static final int INTAKE_MOTOR = 6;
		public static final int WHEEL_MOTOR = 7;
		public static final int CLIMB_MOTOR = 8;
		
	}
	
}


