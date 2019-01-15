package org.usfirst.frc571.emmet.commands;

import org.usfirst.frc571.emmet.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TargetScale extends CommandGroup {

	public TargetScale(int pos) {
		if(!SmartDashboard.getBoolean("ahrs/connected", false)) {
			addSequential(new TimedForward(3, 0));
		}
		else {
		
		// get the cube
			addParallel(new RaiseElevator(2,0.3));
			addSequential(new TimedForward(4.8, 0));

			if (pos == 1) {
				addSequential(new TurnTo(90));
				addSequential(new RaiseElevator(3,1));
				addSequential(new TimedForward(0.3, 90));
			} else if (pos == 3) {
				addSequential(new TurnTo(-90));
				addSequential(new RaiseElevator(3,1));
				addSequential(new TimedForward(0.3, -90));
			}

			addSequential(new OpenHands());
		}
	}
}