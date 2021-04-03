// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class PathBBlue extends SequentialCommandGroup {
  /** Creates a new PathBBlue. */
  public PathBBlue() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new DriveForward(150), 
                new TurnRobot(-45),
                new DriveForward(85),
                new TurnRobot(90),
                new DriveForward(85),
                new TurnRobot(-45),
                new DriveForward(60)
              );
  }
}
