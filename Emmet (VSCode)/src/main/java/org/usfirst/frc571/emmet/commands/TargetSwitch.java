package org.usfirst.frc571.emmet.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TargetSwitch extends CommandGroup {

	public TargetSwitch(int pos) {
		if (!SmartDashboard.getBoolean("ahrs/connected", false)) {
			addSequential(new TimedForward(3, 0));
		} else {

			addParallel(new RaiseElevator(2, 0.3));
			addSequential(new TimedForward(1.8, 0, 0.8)); // 2.6 sec 0.7 speed

			if (pos == 1) {
				addSequential(new TurnTo(90));
				addSequential(new RaiseElevator(1, 1));
				addSequential(new TimedForward(0.6, 90));
			} else if (pos == 3) {
				addSequential(new TurnTo(-90));
				addSequential(new RaiseElevator(1, 1));
				addSequential(new TimedForward(0.6, -90));
			}

			addSequential(new OpenHands());
			addSequential(new WaitCommand(.2));
			
			addParallel(new ElevatorMin());
			addSequential(new TimedBackward(0.4));
			addSequential(new TurnTo(0));
			addSequential(new TimedForward(1.0, 0));
			addSequential(new TurnTo(-155));
			addSequential(new TimedForward(1.0,-155));
			addSequential(new CloseHands());
			addSequential(new WaitCommand(0.2));
//			addSequential(new CurveTo(-180, 0.8, 5, true));
//			addSequential(new TimedForward(1.0, 0));
//			addSequential(new TurnTo(-90));
		}
	}

}