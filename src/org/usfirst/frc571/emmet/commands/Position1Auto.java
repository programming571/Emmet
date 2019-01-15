// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc571.emmet.commands;

import org.usfirst.frc571.emmet.Robot;
import edu.wpi.first.wpilibj.command.InstantCommand;

import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class Position1Auto extends InstantCommand {


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
    public Position1Auto() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS
//    	addSequential(new fmsConditionalPos1());
//        addSequential(new TimedForward(1.6));
//        addSequential(new Turn(90));
//        
//        addSequential(new Turn());
//        addSequential(new TimedForward(0.5));
//        addSequential(new OpenHands());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS
    	    	
    }
    
    public void execute() {
    	
    	new WaitCommand(SmartDashboard.getNumber("Auto Delay", 0)).start();

    	if (Robot.gameData.charAt(0) == 'L') {
    		new TargetSwitch(1).start();
    	} else if (Robot.gameData.charAt(1) == 'L') {
    		new TargetScale(1).start();
    	} else {
//    		System.out.println("no left target available...");
//    		new TargetNothing(2).start();
    		new TargetOppositeScale(1);
    	}
    	
    }
}
