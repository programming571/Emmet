// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc571.emmet;

import org.usfirst.frc571.emmet.subsystems.PositionSensor;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	
    public static WPI_TalonSRX driveTrainLDrive1;
    public static WPI_TalonSRX driveTrainRDrive1;
    public static DifferentialDrive driveTrainRobotDrive;
    public static Solenoid handsHandPiston;
    public static WPI_TalonSRX elevatorElevatorDrive;
    public static DigitalInput elevatorUpperLimitSwitch;
    public static DigitalInput elevatorLowerLimitSwitch;
    public static Solenoid elevatorElevatorBrake;
    public static WPI_TalonSRX winch;
    public static DigitalInput climberUpperLimitSwitch;
    public static DigitalInput climberLowerLimitSwitch;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    public static WPI_TalonSRX driveTrainLDrive2;
    public static WPI_TalonSRX driveTrainRDrive2;
    
    public static PositionSensor sensor;

    public static void init() {
    	SmartDashboard.putNumber("speedNanny", 1.0);
    	sensor = new PositionSensor();
    	
    	driveTrainLDrive1 = new WPI_TalonSRX(1);
    	driveTrainLDrive2 = new WPI_TalonSRX(2);
    	SpeedControllerGroup LDrive = new SpeedControllerGroup(driveTrainLDrive1, driveTrainLDrive2);
    	
    	driveTrainRDrive1 = new WPI_TalonSRX(3);
    	driveTrainRDrive2 = new WPI_TalonSRX(4);
    	SpeedControllerGroup RDrive = new SpeedControllerGroup(driveTrainRDrive1, driveTrainRDrive2);

        driveTrainRobotDrive = new DifferentialDrive(LDrive, RDrive);

    	/** deleteMe delete this auto generated code **/
        
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        LiveWindow.addActuator("DriveTrain", "RobotDrive", driveTrainRobotDrive);
        driveTrainRobotDrive.setSafetyEnabled(false);
        driveTrainRobotDrive.setExpiration(0.1);
        driveTrainRobotDrive.setMaxOutput(1.0);
        
//        driveTrainLDrive1.setSafetyEnabled(false);
//        driveTrainLDrive2.setSafetyEnabled(false);
//        driveTrainRDrive1.setSafetyEnabled(false);
//        driveTrainRDrive2.setSafetyEnabled(false);
        
        handsHandPiston = new Solenoid(6, 0);
        LiveWindow.addActuator("Hands", "Hand Piston", handsHandPiston);
        
        elevatorElevatorDrive = new WPI_TalonSRX(5);
        elevatorElevatorDrive.setSafetyEnabled(false);
        
        elevatorUpperLimitSwitch = new DigitalInput(1);
        LiveWindow.addSensor("Elevator", "Upper Limit Switch", elevatorUpperLimitSwitch);
        
        elevatorLowerLimitSwitch = new DigitalInput(0);
        LiveWindow.addSensor("Elevator", "Lower Limit Switch", elevatorLowerLimitSwitch);
        
        elevatorElevatorBrake = new Solenoid(6, 1);
        LiveWindow.addActuator("Elevator", "Elevator Brake", elevatorElevatorBrake);
        
        winch = new WPI_TalonSRX(7);
        winch.setSafetyEnabled(false);
        
        climberUpperLimitSwitch = new DigitalInput(2);
        LiveWindow.addSensor("Climber", "Climber Upper Limit Switch", climberUpperLimitSwitch);
        
        climberLowerLimitSwitch = new DigitalInput(3);
        LiveWindow.addSensor("Climber", "Climber Lower Limit Switch", climberLowerLimitSwitch);
        
//        LiveWindow.add(Robot.driveTrain);
//        LiveWindow.addChild(Robot.driveTrain, driveTrainRobotDrive);
//        
//        LiveWindow.add(Robot.hands);
//        LiveWindow.addChild(Robot.hands, handsHandPiston);
//        
//        LiveWindow.add(Robot.elevator);
//        LiveWindow.addChild(Robot.elevator, elevatorUpperLimitSwitch);
//        LiveWindow.addChild(Robot.elevator, elevatorLowerLimitSwitch);
//        LiveWindow.addChild(Robot.elevator, elevatorElevatorBrake);
    }
}
