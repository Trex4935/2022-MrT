// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {

  WPI_TalonSRX leftTop;
  WPI_TalonSRX leftBottom;
  WPI_TalonSRX rightTop;
  WPI_TalonSRX rightBottom;

  MotorControllerGroup leftMotorGroup;
  MotorControllerGroup rightMotorGroup;

  int leftInvert;
  int rightInvert;

  double motorSpeedMultiplier;

  DifferentialDrive drive;

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    // motor canbus
    leftTop = new WPI_TalonSRX(Constants.leftTopCanID);
    leftBottom = new WPI_TalonSRX(Constants.leftBottomCanID);
    rightTop = new WPI_TalonSRX(Constants.rightTopCanID);
    rightBottom = new WPI_TalonSRX(Constants.rightBottomCanID);

    // motor group
    leftMotorGroup = new MotorControllerGroup(leftTop, leftBottom);
    rightMotorGroup = new MotorControllerGroup(rightTop, rightBottom);
    rightMotorGroup.setInverted(true);

    // invert
    leftInvert = Constants.leftInvert;
    rightInvert = Constants.rightInvert;

    // motor speed multiplier
    motorSpeedMultiplier = Constants.motorSpeedMultiplier;

    // arcade drive
    drive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);

  }

  public void driveWithController(XboxController controller) {
    drive.tankDrive((((controller.getRawAxis(Constants.leftAxis)) * leftInvert) * motorSpeedMultiplier),
        (((controller.getRawAxis(Constants.rightAxis)) * rightInvert) * motorSpeedMultiplier*Constants.motorSpeedMultiplierRight));
    System.out.println((((controller.getRawAxis(Constants.leftAxis)) * leftInvert) * motorSpeedMultiplier*Constants.motorSpeedMultiplierLeft));
  }
  public void driveStraight(Double speed){
    drive.tankDrive(speed, speed);
  }

  public void stopMotors() {
    leftTop.stopMotor();
    leftBottom.stopMotor();
    rightTop.stopMotor();
    rightBottom.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
