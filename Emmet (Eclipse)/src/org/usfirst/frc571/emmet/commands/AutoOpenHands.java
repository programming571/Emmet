package org.usfirst.frc571.emmet.commands;

import org.usfirst.frc571.emmet.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class AutoOpenHands extends TimedCommand {

	public AutoOpenHands() {
		this(0);
	}
	
	public AutoOpenHands(double timeout) {
		super(timeout);
		requires(Robot.hands);
	}
	
    // Called just before this Command runs the first time
	@Override
	public void initialize() {
		
	}
	
    // Called repeatedly when this Command is scheduled to run
	@Override
	public void execute() {
		Robot.hands.openHands();
	}
	
    // Make this return true when this Command no longer needs to run execute()
	@Override
	public boolean isFinished() {
		return super.isFinished();
	}
	
	// Called once after isFinished returns true
    @Override
    protected void end() {
    	System.out.println("cube scored");
    }
    
}
