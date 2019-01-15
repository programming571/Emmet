package org.usfirst.frc571.emmet.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class Pos1TargetScale extends CommandGroup {

	public Pos1TargetScale() {
		//get the cube
		addSequential(new RaiseElevator(.2));
		
		//score in left scale
		addSequential(new TimedForward(.2));
		addSequential(new Turn(-90));
		addSequential(new TimedForward(.2));
		addSequential(new Turn(90));
		addSequential(new TimedForward(2));
		addParallel(new RaiseElevator(2));
		addSequential(new OpenHands());
	}
}
