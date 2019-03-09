/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc5124.VisionDrive.commands;

import org.usfirst.frc5124.VisionDrive.Location;
import org.usfirst.frc5124.VisionDrive.Robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LaunchGyroVis extends Command {
  
  private NetworkTable limelightTable;
  private NetworkTableEntry xAngle;
  private NetworkTableEntry hasTarget;
  private NetworkTableEntry height;
  private NetworkTableEntry width;
  //private NetworkTableEntry camtran;

  private boolean finished;

  public LaunchGyroVis() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    limelightTable = NetworkTableInstance.getDefault().getTable("limelight");
    xAngle = limelightTable.getEntry("tx");
    hasTarget = limelightTable.getEntry("tv");
    //camtran = limelightTable.getEntry("camtran");
    height = limelightTable.getEntry("tvert");
    width = limelightTable.getEntry("thor");
    finished = false;
  }

  private static final double DISTANCE_CONSTANT = 1;
  private static final double TARGET_WIDTH = 1;
  private static final double k = 1;


  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
    if (hasTarget.getDouble(0) == 1) {
      //double[] camtranV = camtran.getDoubleArray(new double[6]);
      double turn = xAngle.getDouble(0);
      SmartDashboard.putNumber("Turn", turn);
      //double dst = Math.hypot(camtranV[0], camtranV[2]);
      if (height.getDouble(0) == 0) {
        SmartDashboard.putNumber("Amount Targets", 0);
        return;
      }
      double dst = DISTANCE_CONSTANT / height.getDouble(0);
      SmartDashboard.putNumber("Distance", dst);
      double relativeWidth = width.getDouble(0) / height.getDouble(0);
      // double fakeW = k * dst * Math.sqrt (2- Math.cos(27 * Math.PI / 180 * ))
      Robot.vis.setTarget(new Location(
        dst * Math.sin(turn),
        dst * Math.cos (turn),
        0
      ));
      SmartDashboard.putNumber("Amount Targets", 1);
      finished = true;
    }
    else {
      SmartDashboard.putNumber("Amount Targets", 0);
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return finished;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
