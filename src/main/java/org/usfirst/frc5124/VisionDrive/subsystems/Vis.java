/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc5124.VisionDrive.subsystems;

import org.usfirst.frc5124.VisionDrive.Location;
import org.usfirst.frc5124.VisionDrive.Robot;
import org.usfirst.frc5124.VisionDrive.commands.Sub_Vis;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Add your docs here.
 */
public class Vis extends PIDSubsystem {

  //private double turn;
  //private double dst;
  public double xCurve;

  private Location cameraTarget = new Location(0, 0, 90);

  /**
   * Add your docs here.
   */
  public Vis() {

    super("VisionTurner", 0.08, 0, 0.075);
    // setSetpoint(0.0);
    setAbsoluteTolerance(0.5);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Sub_Vis());
  }

  @Override
  protected double returnPIDInput() {
    SmartDashboard.putNumber("PID Input", Robot.drive.getGyro());
    return Robot.drive.getGyro();
  }

  @Override
  protected void usePIDOutput(double output) {
    SmartDashboard.putNumber("PID Output", output);
    Robot.drive.arcadeDrive(0, output);
    // xCurve = output;
  }
/*
  public void setTurn (double turn) {
    SmartDashboard.putNumber("Turn Set", turn);
    this.turn = turn;
  }

  public void setDistance (double dst) {
    SmartDashboard.putNumber("Dst Set", -dst);
    this.dst = -dst;
  }
*/
  public void setTarget (Location l) {
    cameraTarget = l;
  }

  public Location getTarget () {
    return cameraTarget;
  }

}
