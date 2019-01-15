package org.usfirst.frc571.emmet.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class Pos1TargetSwitch extends CommandGroup {

	Pos1TargetSwitch() {
		//get the cube
		addSequential(new RaiseElevator(.2));
		
		//score in left switch
		addSequential(new TimedForward(.2));
		addSequential(new Turn(-90));
		addSequential(new TimedForward(.2));
		addSequential(new Turn(90));
		addSequential(new TimedForward(.5));
		addSequential(new Turn(90));
		addSequential(new TimedForward(.3));
		addSequential(new OpenHands());
	}
}
