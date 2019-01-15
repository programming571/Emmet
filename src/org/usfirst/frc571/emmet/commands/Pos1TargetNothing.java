package org.usfirst.frc571.emmet.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos1TargetNothing extends CommandGroup {

	Pos1TargetNothing() {
		//get the cube
		addSequential(new RaiseElevator(.2));
		
		//move forward towards left scale
		addSequential(new TimedForward(.2));
		addSequential(new Turn(-90));
		addSequential(new TimedForward(.2));
		addSequential(new Turn(90));
		
		addSequential(new TimedForward(2));
	}
	
}
