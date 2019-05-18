package org.usfirst.frc571.emmet.commands;

import org.usfirst.frc571.emmet.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Pos2TargetSwitch extends CommandGroup {

	public Pos2TargetSwitch(int switchPos) {
		if(!SmartDashboard.getBoolean("ahrs/connected", false)) {
			addSequential(new TimedForward(3, 0));
		}
		else {
		// get the cube
		addSequential(new TimedForward(0.5, 0));
		
		if (switchPos == 1) {
			addSequential(new TurnTo(-90));
			addParallel(new RaiseElevator(2,0.5));
			addSequential(new TimedForward(1.1, -90));
		} else if (switchPos == 2) {
			addSequential(new TurnTo(90));
			addParallel(new RaiseElevator(2,0.5));
			addSequential(new TimedForward(0.9, 90));
		}
		
		addSequential(new TurnTo(0));
		addParallel(new RaiseElevator(1,1));
		addSequential(new TimedForward(2, 0));
		addSequential(new WaitCommand(0.5));
		
		addSequential(new OpenHands());
		}
	}

}