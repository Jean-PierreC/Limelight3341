// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Limelight;
import frc.robot.RobotContainer;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Align {
  /** Creates a new PathABlue. */
  Limelight li = new Limelight();
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    int test = 0;
    double x = li.getX();
    public void turn(){
    while(test==0){
        x = li.getX();
        if(li.getX()>.1){
          RobotContainer.returnDrive().tankDrive(0.02 * x, -0.02 * x);
       }
       if(li.getX()<-.1){
         RobotContainer.returnDrive().tankDrive(-0.02 * x/50, 0.02 * x);
       }
       if(li.getX()>-.1 && li.getX()<.1){
          test=1;
       }
   }
  }
    double distance = li.getDistance();
  public void closer(){
    int reached = 0;
    double x = li.getX();
    while (reached == 0){
      x = li.getX();
      if(distance > 1){
        RobotContainer.returnDrive().tankDrive(0.25 + x/100, 0.25 - x/100);
      }
      if(-.1<x && x<.1){
        reached = 1;
      }
    }
  }
}


