/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc5124.VisionDrive;

import edu.wpi.first.wpilibj.SendableBase;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;

/**
 * Add your docs here.
 */
public class Location extends SendableBase {

    public double x;
    public double y;
    public double dir;

    public Location (double x, double y, double dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.setActuator(false);
        builder.setSmartDashboardType("Location");
        builder.addDoubleProperty("X:  ", () -> x,   (x)   -> this.x   = x);
        builder.addDoubleProperty("Y:  ", () -> y,   (y)   -> this.y   = y);
        builder.addDoubleProperty("Dir:", () -> dir, (dir) -> this.dir = dir);
	}

}