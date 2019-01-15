// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc571.emmet.subsystems;

import org.usfirst.frc571.emmet.commands.*;
import org.usfirst.frc571.emmet.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */

public class Climber extends Subsystem {
	
	private final DigitalInput lowerClimberSwitch = RobotMap.climberLowerLimitSwitch;
	private final DigitalInput upperClimberSwitch = RobotMap.climberUpperLimitSwitch;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
	
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	
	private final WPI_TalonSRX winch = RobotMap.winch;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	@Override
	public void initDefaultCommand() {

		setDefaultCommand(new MoveWinch());

	}

	@Override
	public void periodic() {
		// Put code here to be run every loop
	}

	public void move(double speed) {
		if (speed > .05) {
			moveUp(speed);
		} else if (speed < -.05) {
			moveDown(speed);
		} else {
			stop();
		}
	}

	public void moveUp(double speed) {
		if (upperClimberSwitch.get()) {
			winch.set(speed);
		}
	}

	public void moveDown(double speed) {
		if (lowerClimberSwitch.get()) {
			winch.set(speed);
		}
	}

	public void stop() {
		winch.set(0);
	}

}