// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants
{
    public static enum PortID
    {
        left_front(2),
        left_back(3),
        right_front(4),
        right_back(5),

        index(8),
        trigger(9),

        intake(10),

        solenoid(0),

        climb(6),
        rotate(7),
        compressor_port(0);

        public final int value;
        PortID(int value) { this.value = value; }
    }
    
    public static enum PortReversed
	{
		left_front_reversed(true),
        left_back_reversed(true),
        right_front_reversed(true),
        right_back_reversed(true),

        index_reversed(true),
        trigger_reversed(true),

        intake_reversed(false),

        climb_reversed(false),
		rotate_reversed(false);

		@SuppressWarnings("MemberName")
		public final boolean value;

		PortReversed(boolean value) { this.value = value; }
	}

    public static final double kMotorRampRate 	= 0.25f;
}
