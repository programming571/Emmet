package org.usfirst.frc571.emmet.commands;

import org.usfirst.frc571.emmet.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TargetOppositeScale extends CommandGroup {

	public TargetOppositeScale(int pos) {
		if (!SmartDashboard.getBoolean("ahrs/connected", false)) {
			addSequential(new TimedForward(3, 0));
		} else {

			System.out.println("Targeting Opposite Scale");

			// get the cube
			// addParallel(new RaiseElevator(4,0.7));
			addSequential(new TimedForward(1.65, 0, 0.95));
			addParallel(new ElevatorMax());

			if (pos == 1) {
				System.out.println("Targeting Right Scale");
				addSequential(new CurveTo(90, 0.7, 3, false));
				addSequential(new TimedForward(1.30, 90, 0.8)); // 1.32
				addSequential(new WaitCommand(0.5));
				addSequential(new TurnTo(0));
				addSequential(new TimedForward(0.75, 0));
				addSequential(new OpenHands());
				addSequential(new WaitCommand(0.7));

				// get second cube
				addSequential(new TimedBackward(0.9));
				addParallel(new TurnTo(-170));
				addSequential(new ElevatorMin()); // (4, 0.7));
				// addSequential(new TimedForward(0.8, -170));
				// addSequential(new CloseHands());
				addSequential(new WaitCommand(0.2));

				// addSequential(new TimedBackward(0.5));

			} else if (pos == 3) {
				System.out.println("Targeting Left Scale");
				addSequential(new CurveTo(-90, 0.7, 3, true));
				addSequential(new TimedForward(1.30, -90, 0.8)); // 1.32
				addSequential(new WaitCommand(0.5));
				addSequential(new TurnTo(0));
				addSequential(new TimedForward(0.75, 0));
				addSequential(new OpenHands());
				addSequential(new WaitCommand(0.7));

				// get second cube
				addSequential(new TimedBackward(0.9));
				addParallel(new TurnTo(170));
				addSequential(new ElevatorMin()); // (4, 0.7));
				// addSequential(new TimedForward(0.8, 170));
				// addSequential(new CloseHands());
				addSequential(new WaitCommand(0.2));

				// addSequential(new TimedBackward(0.5));
			}

			// addSequential(new TurnTo(0));

			// addSequential(new TimedForward(.3, 0));
			// addSequential(new OpenHands());

			// addSequential(new CloseHands());
			// addSequential(new LowerElevator(3));
		}
	}
}