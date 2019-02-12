// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// PURPOSE: "all this does is publish data" - Mr. Schwartz (to the network tables)

package org.usfirst.frc571.emmet.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class PositionSensor extends Subsystem {

	private AHRS ahrs;

	public PositionSensor() {
		try {
			/***********************************************************************
			 * navX-MXP: - Communication via RoboRIO MXP (SPI, I2C, TTL UART) and USB. - See
			 * http://navx-mxp.kauailabs.com/guidance/selecting-an-interface.
			 * 
			 * navX-Micro: - Communication via I2C (RoboRIO MXP or Onboard) and USB. - See
			 * http://navx-micro.kauailabs.com/guidance/selecting-an-interface.
			 * 
			 * Multiple navX-model devices on a single robot are supported.
			 ************************************************************************/
//			ahrs = new AHRS(SerialPort.Port.kUSB);
			ahrs = new AHRS(SPI.Port.kMXP);
			// ahrs = new AHRS(SerialPort.Port.kMXP, SerialDataType.kProcessedData,
			// (byte)50);
			ahrs.enableLogging(true);
			ahrs.zeroYaw();
			System.out.println("zero");

		} catch (RuntimeException ex) {
			DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
		}
	}

	@Override
	public void initDefaultCommand() {
		// no default
//		System.out.println("init default command");
//		ahrs.zeroYaw();
	}

	@Override
	public void periodic() {
		// Put code here to be run every loop

		SmartDashboard.putBoolean("ahrs/connected", ahrs.isConnected());
		SmartDashboard.putNumber("ahrs/angle", ahrs.getAngle());
		SmartDashboard.putNumber("ahrs/rate", ahrs.getRate());
		SmartDashboard.putNumber("ahrs/pitch", ahrs.getPitch());

		int connection = 0;
		if (ahrs.isConnected()) {
			connection = 1;
		}
		SmartDashboard.putNumber("ahrs/connectedLog", connection);
	}
	
	public AHRS getAHRS() {
		return ahrs;
	}
	
	public void zeroIt() {
		ahrs.zeroYaw();
		System.out.println("zero");
	}

}