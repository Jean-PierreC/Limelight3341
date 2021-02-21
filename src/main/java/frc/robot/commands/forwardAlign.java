// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.Limelight;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
public class forwardAlign extends CommandBase {
  Limelight li;
  /** Creates a new forwardAlign. */
  private double dist;
  public forwardAlign() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    li = new Limelight();
    dist = li.getDistance();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    dist = li.getDistance();
    System.out.println("test: "+li.getDistance()); 
    if(dist>10){
    RobotContainer.returnDrive().tankDrive(-0.25, -.25);
    System.out.println("MOVE");
    }
 
    //if(dist<10)
    //RobotContainer.returnDrive().tankDrive(0,0);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.returnDrive().tankDrive(0, 0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(dist<=10){
      System.out.println("STOOOOP!");
      RobotContainer.returnDrive().tankDrive(0,0);

    return true;
    }
    return false;
  }
}
