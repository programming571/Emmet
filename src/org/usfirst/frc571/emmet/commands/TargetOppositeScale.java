package org.usfirst.frc571.emmet.commands;

import org.usfirst.frc571.emmet.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class TargetOppositeScale extends CommandGroup {

	public TargetOppositeScale(int pos) {
//		if(!Robot.driveTrain.isAHRSConnected()) {
		System.out.println("targeting opposite scale");
			addSequential(new TimedForward(3, 0));
		/*}
		else {
		//get the cube
//		addSequential(new TimedForward(0.5, 0));
		addSequential(new RaiseElevator(0.4));
		addSequential(new TurnTo(45));
		
		Robot.driveTrain.zeroAHRSYaw();
		addSequential(new WaitCommand(0.5));
		
		addSequential(new TimedForward(3, 0)); // 3.7

		if (pos == 1) {
			addSequential(new TurnTo(90));
			addParallel(new RaiseElevator(3));
			addSequential(new TimedForward(3.7, 90));
		} else if (pos == 3) {
			addSequential(new TurnTo(-90));
			addParallel(new RaiseElevator(3));
			addSequential(new TimedForward(3.7, -90));
		}
		
		addSequential(new TurnTo(0));
		
		addSequential(new TimedForward(.3, 0));
		addSequential(new OpenHands());
		
		addSequential(new CloseHands());
		//addSequential(new LowerElevator(3));
		}*/
	}
}