// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private static final Drivetrain m_drive = new Drivetrain();

  private Command m_autoCommand;

  private static Joystick leftJoy = new Joystick(Constants.leftJoy);
  private static Joystick rightJoy = new Joystick(Constants.rightJoy);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  //joystick and subsystem getters
  public static Joystick returnLeftJoy() {
    return leftJoy;
  }

  public static Joystick returnRightJoy() {
    return rightJoy;
  }

  public static Drivetrain returnDrive() {
    return m_drive;
  }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    //still need a way to distinguish in between
    if (m_drive.getUltraDistance() >= 50 && m_drive.getUltraDistance() <= 70) {
      m_autoCommand = new PathARed();
    } else if (m_drive.getUltraDistance() >= 140 && m_drive.getUltraDistance() <= 160) {
      m_autoCommand = new PathABlue();
    } else {
      m_autoCommand = new PathBBlue();
    }
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
