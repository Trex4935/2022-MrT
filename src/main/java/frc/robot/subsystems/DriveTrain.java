// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {

  WPI_TalonSRX leftTop;
  WPI_TalonSRX leftBottomleft;
  WPI_TalonSRX leftBottomright;
  WPI_TalonSRX rightTop;
  WPI_TalonSRX rightBottomleft;
  WPI_TalonSRX rightBottomright;

  MotorControllerGroup leftMotorGroup;
  MotorControllerGroup rightMotorGroup;

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    // motor canbus
    leftTop = new WPI_TalonSRX(Constants.leftTopCanID);
    leftBottomleft = new WPI_TalonSRX(Constants.leftBottomLeftCanID);
    leftBottomright = new WPI_TalonSRX(Constants.leftBottomRightCanID);
    rightTop = new WPI_TalonSRX(Constants.rightTopCanID);
    rightBottomleft= new WPI_TalonSRX(Constants.rightBottomLeftCanID);
    rightBottomright = new WPI_TalonSRX(Constants.rightBottomRightCanID);

    // motor group
    leftMotorGroup = new MotorControllerGroup(leftTop, leftBottomleft, leftBottomright);
    rightMotorGroup = new MotorControllerGroup(rightTop, rightBottomleft, rightBottomright);

  }

  public void driveWithController() {

  }

  public void stopMotors() {
    leftTop.stopMotor();
    leftBottomleft.stopMotor();
    leftBottomright.stopMotor();
    rightTop.stopMotor();
    rightBottomleft.stopMotor();
    rightBottomright.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
