package org.usfirst.frc571.emmet.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TargetSwitch extends CommandGroup {

	public TargetSwitch(int pos) {
		if(!SmartDashboard.getBoolean("ahrs/connected", false)) {
			addSequential(new TimedForward(3, 0));
		}
		else {
			
		addParallel(new RaiseElevator(2,0.3));
		addSequential(new TimedForward(2.6, 0));

		if (pos == 1) {
			addSequential(new TurnTo(90));
			addSequential(new RaiseElevator(1,1));
			addSequential(new TimedForward(0.6, 90));
		} else if (pos == 3) {
			addSequential(new TurnTo(-90));
			addSequential(new RaiseElevator(1,1));
			addSequential(new TimedForward(0.6, -90));
		}

		addSequential(new OpenHands());
		}
	}
	
}