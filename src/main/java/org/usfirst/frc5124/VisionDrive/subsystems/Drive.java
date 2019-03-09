// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5124.VisionDrive.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SPI;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Drive extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private VictorSP left1;
    private VictorSP left2;
    private SpeedControllerGroup left;
    private VictorSP right1;
    private VictorSP right2;
    private SpeedControllerGroup right;
    private DifferentialDrive diffDrive;
    private AHRS gyro;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public Drive() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        left1 = new VictorSP(3);
        addChild("left1",left1);
        left1.setInverted(false);
        
        left2 = new VictorSP(4);
        addChild("left2",left2);
        left2.setInverted(false);
        
        left = new SpeedControllerGroup(left1, left2);
        addChild("left",left);
        
        
        right1 = new VictorSP(5);
        addChild("right1",right1);
        right1.setInverted(false);
        
        right2 = new VictorSP(6);
        addChild("right2",right2);
        right2.setInverted(false);
        
        right = new SpeedControllerGroup(right1, right2);
        addChild("right",right);
        
        diffDrive = new DifferentialDrive(left, right);
        addChild("diffDrive",diffDrive);
        diffDrive.setSafetyEnabled(true);
        diffDrive.setExpiration(0.1);
        diffDrive.setMaxOutput(1.0);

        gyro = new AHRS(SPI.Port.kMXP);
        addChild("NavX Gyro", gyro);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    public void arcadeDrive (double power, double turn) {
        diffDrive.arcadeDrive(power, turn);
    }

    public double getGyro() {
        return gyro.getAngle();
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}
