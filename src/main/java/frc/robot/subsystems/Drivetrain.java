// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import frc.robot.Constants;
import frc.robot.Limelight;
import frc.robot.RobotContainer;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.SPI;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  private AHRS navx = new AHRS(SPI.Port.kMXP);
  private WPI_TalonSRX leftTalon = new WPI_TalonSRX(Constants.leftDrivePort);
  private WPI_TalonSRX rightTalon = new WPI_TalonSRX(Constants.rightDrivePort);
  private Ultrasonic ultra = new Ultrasonic(Constants.ultrasonicPort1, Constants.ultrasonicPort2);
  private static Drivetrain drive;

  
  private double kTicksToInches = 12 * Math.PI * (1/1440) * 3;
  Limelight li = new Limelight();
  public Drivetrain() {
    //setting up left and right talons and encoders
    leftTalon.configFactoryDefault();
    leftTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);

    rightTalon.configFactoryDefault();
    leftTalon.setInverted(true);
    rightTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);

    resetEncoders();

    //settings for sensors (ultrasonic and gyro)
    Ultrasonic.setAutomaticMode(true);
    navx.zeroYaw();
  }

  public Drivetrain getInstance() {
    if (drive == null) {
      drive = new Drivetrain();
    }
    return drive;
  }

  public void tankDrive(double leftPow, double rightPow) {
    leftTalon.set(ControlMode.PercentOutput, leftPow);
    rightTalon.set(ControlMode.PercentOutput, rightPow);
  }

  public void resetEncoders() {
    leftTalon.setSelectedSensorPosition(0, 0, 10);
    rightTalon.setSelectedSensorPosition(0, 0, 10);
  }

  public double getEncoderDistance() {
    return (leftTalon.getSelectedSensorPosition(0) + rightTalon.getSelectedSensorPosition(0)) * 0.5 * kTicksToInches;
  }

  public void resetNavx() {
    navx.zeroYaw();
  }

  public double getAngle() {
    return navx.getYaw();
  }

  public double getUltraDistance() {
    return ultra.getRangeInches();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    li.getDistance();
   // li.getArea();
    //System.out.println("aa");
    tankDrive(RobotContainer.returnLeftJoy().getY(), RobotContainer.returnRightJoy().getY());
  }
}
