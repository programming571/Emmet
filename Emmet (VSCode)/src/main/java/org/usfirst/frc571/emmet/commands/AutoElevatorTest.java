package org.usfirst.frc571.emmet.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoElevatorTest extends CommandGroup {

	public AutoElevatorTest() {
		
		addSequential(new RaiseElevator(2,0.3));
		addSequential(new RaiseElevator(1,1));
		addSequential(new OpenHands());
		
	}
	
}