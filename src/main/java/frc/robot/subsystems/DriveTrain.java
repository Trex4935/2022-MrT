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
  WPI_TalonSRX leftBottom;
  WPI_TalonSRX rightTop;
  WPI_TalonSRX rightBottom;

  MotorControllerGroup leftMotorGroup;
  MotorControllerGroup rightMotorGroup;

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    // motor canbus
    leftTop = new WPI_TalonSRX(Constants.leftTop);
    leftBottom = new WPI_TalonSRX(Constants.leftBottom);
    rightTop = new WPI_TalonSRX(Constants.rightTop);
    rightBottom = new WPI_TalonSRX(Constants.rightBottom);

    // motor group
    leftMotorGroup = new MotorControllerGroup(leftTop, leftBottom);
    rightMotorGroup = new MotorControllerGroup(rightTop, rightBottom);

  }

  public void driveWithController() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
