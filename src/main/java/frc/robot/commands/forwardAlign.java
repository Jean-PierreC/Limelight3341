// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Limelight;
import frc.robot.RobotContainer;

public class forwardAlign extends SequentialCommandGroup {
  /** Creates a new forwardAlign. */
  Limelight li = new Limelight();
  public forwardAlign() {
    // Use addRequirements() here to declare subsystem dependencies.
     

    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    double x = li.getX();
    double distance = li.getDistance();
    if(distance > 1){
      RobotContainer.returnDrive().tankDrive(0.25 + x/100, 0.25 - x/100);
    }
  }

  
  
}
