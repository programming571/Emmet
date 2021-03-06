// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc571.emmet;

import org.usfirst.frc571.emmet.commands.CloseHands;
import org.usfirst.frc571.emmet.commands.LowerElevator;
import org.usfirst.frc571.emmet.commands.OpenHands;
import org.usfirst.frc571.emmet.commands.RaiseElevator;
import org.usfirst.frc571.emmet.commands.StopElevator;
import org.usfirst.frc571.emmet.commands.TimedForward;
import org.usfirst.frc571.emmet.commands.ToggleHands;
import org.usfirst.frc571.emmet.commands.Turn;
import org.usfirst.frc571.emmet.commands.TurnTo;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


	public Joystick driveStick;
	public Joystick opStick;
    public JoystickButton togglehandsButton;
    public JoystickButton turnForwardButton;
    public JoystickButton turnLeftButton;
    public JoystickButton turnRightButton;
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
    	driveStick = new Joystick(0);
    	opStick = new Joystick(1);
    	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        togglehandsButton = new JoystickButton(opStick, 1);
        togglehandsButton.toggleWhenPressed(new ToggleHands());
        
        // drive stick - 1, 3 + 4 = absolute turn
        //turnForwardButton = new JoystickButton(driveStick, 1);
        //turnForwardButton.whenPressed(new TurnTo(0));
        turnLeftButton = new JoystickButton(driveStick, 3);
        turnLeftButton.whenPressed(new TurnTo(-90.0));
        turnRightButton = new JoystickButton(driveStick, 4);
        turnRightButton.whenPressed(new TurnTo(90.0));
        

        // SmartDashboard Buttons
        SmartDashboard.putData("Open Hands", new OpenHands());
        SmartDashboard.putData("Close Hands", new CloseHands());
        SmartDashboard.putData("Raise Elevator", new RaiseElevator());
        SmartDashboard.putData("Lower Elevator", new LowerElevator());
        SmartDashboard.putData("Stop Elevator", new StopElevator());
        SmartDashboard.putData("TimedForward: timeout", new TimedForward(1, 0)); //do we need this??

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getDrive() {
        return driveStick;
    }
    public Joystick getOpStick() {
        return opStick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

