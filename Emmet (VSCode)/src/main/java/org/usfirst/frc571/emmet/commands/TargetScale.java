package org.usfirst.frc571.emmet.commands;

import org.usfirst.frc571.emmet.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TargetScale extends CommandGroup {

	public TargetScale(int pos) {
		if(!SmartDashboard.getBoolean("ahrs/connected", false)) {
			addSequential(new TimedForward(2.96, 0));
		}
		else {
			
			System.out.println("Targeting Scale");
			
			// get the cube
			addParallel(new ElevatorMax());
			addSequential(new TimedForward(2.53, 0, 0.8)); // 4.5
			addSequential(new WaitCommand(0.5));

			if (pos == 1) {
				// score first cube
				addSequential(new CurveTo(45,0.6,1.5,false));
				addSequential(new TimedForward(0.35, 45));
				addSequential(new OpenHands());
				addSequential(new WaitCommand(0.5));
//				System.out.println("First  cube scored");
				
				// get second cube
				addSequential(new TimedBackward(0.35));
				addSequential(new WaitCommand(0.3));
				addParallel(new TurnTo(155));
				addSequential(new ElevatorMin()); //(4, 0.7));
				addSequential(new TimedForward(1.4, 155));
				addSequential(new CloseHands());
				addSequential(new WaitCommand(0.5));
//				System.out.println("Second cube retrieved");
				
				// score second cube
				addParallel(new ElevatorMax()); //(4));
				addSequential(new TimedBackward(0.7)); // 1.0
				addSequential(new TurnTo(20));
				addSequential(new WaitCommand(1.0));
				addSequential(new TimedForward(0.7, 20)); // 0.5
//				addSequential(new OpenHands());
				addSequential(new WaitCommand(0.5));
				
			} else if (pos == 3) {
				// score first cube
				addSequential(new CurveTo(-45,0.6,1.5,true));
				addSequential(new TimedForward(0.35, -45));
				addSequential(new OpenHands());
				addSequential(new WaitCommand(0.5));
//				System.out.println("First  cube scored");
				
				// get second cube
				addSequential(new TimedBackward(0.35));
				addSequential(new WaitCommand(0.3));
				addParallel(new TurnTo(-155));
				addSequential(new ElevatorMin()); //(4, 0.7));
				addSequential(new TimedForward(1.4, -155));
				addSequential(new CloseHands());
				addSequential(new WaitCommand(0.5));
//				System.out.println("Second cube retrieved");
				
				// score second cube
				addParallel(new ElevatorMax()); //(4));
				addSequential(new TimedBackward(0.7)); // 1.0
				addSequential(new TurnTo(-20));
				addSequential(new WaitCommand(1.0));
				addSequential(new TimedForward(0.7, -20)); // 0.5
//				addSequential(new OpenHands());
				addSequential(new WaitCommand(0.5));
			}
			
			//done
//			addSequential(new TimedBackward(0.7));
			// addSequential(new LowerElevator(4));

		}
	}
}