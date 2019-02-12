package org.usfirst.frc571.emmet.commands;

import org.usfirst.frc571.emmet.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorMax extends Command {

	private double speed;
	
	public ElevatorMax() {
	    	this(0.8);
	    	requires(Robot.elevator);
	    }
	    
	    public ElevatorMax(double speed) {
	    	this.speed = speed;
	    	requires(Robot.elevator);
	    }

	    // Called just before this Command runs the first time
	    @Override
	    public void initialize() {
	    }

	    // Called repeatedly when this Command is scheduled to run
	    @Override
	    protected void execute() {
	    	Robot.elevator.moveUp(speed);
	    }
	    
	    // Make this return true when this Command no longer needs to run execute()
		@Override
		protected boolean isFinished() {
			return !Robot.elevator.getUpperLimitSwitch();
		}

	    // Called once after isFinished returns true
	    @Override
	    protected void end() {
	    	Robot.elevator.move(0);
	    }

}