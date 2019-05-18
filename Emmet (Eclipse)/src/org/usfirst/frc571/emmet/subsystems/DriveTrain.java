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

import org.usfirst.frc571.emmet.RobotMap;
import org.usfirst.frc571.emmet.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class DriveTrain extends Subsystem implements PIDOutput {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	private final DifferentialDrive robotDrive = RobotMap.driveTrainRobotDrive;
	PIDController turnController;
	double rotateToAngleRate;

	/** PID Constants for angular rotation **/
//	static final double kP = 0.08;
//	static final double kI = 0.02;
//	static final double kD = 0.29;
//	static final double kF = 0.00;
	
	static final double kP = 0.10;
	static final double kI = 0.00;
	static final double kD = 0.15;
	static final double kF = 0.00;

	static final double kToleranceDegrees = 2.0f;

	/** deleteMe delete this auto generated code **/
	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public DriveTrain() {
		turnController = new PIDController(kP, kI, kD, kF, RobotMap.sensor.getAHRS(), this);
		turnController.setInputRange(-180.0f, 180.0f);
		turnController.setOutputRange(-0.6, 0.6);
		turnController.setAbsoluteTolerance(kToleranceDegrees);
		turnController.setContinuous(true);
		
	}

	@Override
	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		setDefaultCommand(new ArcadeDrive());

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	@Override
	public void periodic() {
		// Put code here to be run every loop
//		SmartDashboard.putNumber("DriveTrain/Voltage/LeftDrive1 Voltage",
//				RobotMap.driveTrainLDrive1.getMotorOutputVoltage());
//		SmartDashboard.putNumber("DriveTrain/Amperage/LeftDrive1 Amperage",
//				RobotMap.driveTrainLDrive1.getOutputCurrent());
//		SmartDashboard.putNumber("DriveTrain/Voltage/LeftDrive2 Voltage",
//				RobotMap.driveTrainLDrive2.getMotorOutputVoltage());
//		SmartDashboard.putNumber("DriveTrain/Amperage/LeftDrive2 Amperage",
//				RobotMap.driveTrainLDrive2.getOutputCurrent());
//		SmartDashboard.putNumber("DriveTrain/Voltage/RightDrive1 Voltage",
//				RobotMap.driveTrainRDrive1.getMotorOutputVoltage());
//		SmartDashboard.putNumber("DriveTrain/Amperage/RightDrive1 Amperage",
//				RobotMap.driveTrainRDrive1.getOutputCurrent());
//		SmartDashboard.putNumber("DriveTrain/Voltage/RightDrive2 Voltage",
//				RobotMap.driveTrainRDrive2.getMotorOutputVoltage());
//		SmartDashboard.putNumber("DriveTrain/Amperage/RightDrive2 Amperage",
//				RobotMap.driveTrainRDrive2.getOutputCurrent());
		SmartDashboard.putNumber("ahrs/kP", kP);
		SmartDashboard.putNumber("ahrs/kI", kI);
		SmartDashboard.putNumber("ahrs/kD", kD);
		SmartDashboard.putNumber("ahrs/kF", kF);
		
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void drive(double leftSpeed, double rightSpeed) {
		robotDrive.tankDrive(leftSpeed, rightSpeed);
	}

	public void arcadeDrive(double speed, double rotation) {
		robotDrive.arcadeDrive(speed, rotation);
	}
	
	public void turn(double amount) {
		turnTo(SmartDashboard.getNumber("ahrs/angle", 0) + amount);
		System.out.println("angle: " + SmartDashboard.getNumber("ahrs/angle", 0) + " amount: " + amount + " goal: " + (SmartDashboard.getNumber("ahrs/angle", 0) + amount));
	}

	public void turnTo(double angle) {
		double currentRotationRate;
		turnController.setP(SmartDashboard.getNumber("ahrs/kP", kP));
		turnController.setI(SmartDashboard.getNumber("ahrs/kI", kI));
		turnController.setD(SmartDashboard.getNumber("ahrs/kD", kD));
		turnController.setF(SmartDashboard.getNumber("ahrs/kF", kF));
		turnController.setSetpoint(angle);
		turnController.enable();
		currentRotationRate = rotateToAngleRate;
		robotDrive.arcadeDrive(0, currentRotationRate);
	}

	/* This function is invoked periodically by the PID Controller, */
	/* based upon navX MXP yaw angle input and PID Coefficients. */
	public void pidWrite(double output) {
		SmartDashboard.putNumber("DriveTrain/ahrs/rotateRate", output);
		rotateToAngleRate = output;
	}
	
}