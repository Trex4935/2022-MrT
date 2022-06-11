// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
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

  // PigeonIMU gyro;
  double[] YPR;
  public static AHRS gyro2;

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    // motor canbus
    leftTop = new WPI_TalonSRX(Constants.leftTopCanID);
    leftBottom = new WPI_TalonSRX(Constants.leftBottomCanID);
    rightTop = new WPI_TalonSRX(Constants.rightTopCanID);
    rightBottom = new WPI_TalonSRX(Constants.rightBottomCanID);

    // Default

    leftTop.configFactoryDefault();
    leftBottom.configFactoryDefault();
    rightBottom.configFactoryDefault();
    rightTop.configFactoryDefault();

    // invert
    leftInvert = Constants.leftInvert;
    rightInvert = Constants.rightInvert;

    // motor group
    leftMotorGroup = new MotorControllerGroup(leftTop, leftBottom);
    rightMotorGroup = new MotorControllerGroup(rightTop, rightBottom);
    rightMotorGroup.setInverted(true);

    // motor speed multiplier
    motorSpeedMultiplier = Constants.motorSpeedMultiplier;

    // gyro
    // gyro = new PigeonIMU(Constants.gyroID);
    YPR = new double[3];
    gyro2 = new AHRS(SPI.Port.kMXP);
    gyro2.calibrate();
    gyro2.reset();

    // arcade drive
    drive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);

  }

  public void driveWithController(XboxController controller) {
    drive.tankDrive(
        (((controller.getRawAxis(Constants.leftAxis)) * leftInvert) * motorSpeedMultiplier
            * Constants.motorSpeedMultiplierLeft),
        (((controller.getRawAxis(Constants.rightAxis)) * rightInvert) * motorSpeedMultiplier
            * Constants.motorSpeedMultiplierRight));
    // System.out.println((((controller.getRawAxis(Constants.leftAxis)) *
    // leftInvert) * motorSpeedMultiplier));


    // gyro.getYawPitchRoll(YPR);
    // System.out.println("Gyro Yaw is " + YPR[0]);
    // System.out.println("Gyro Yaw is " + YPR[1]);
    // System.out.println("Gyro Yaw is " + YPR[2]);
    // System.out.println("Gyro Yaw is " + gyro.getYaw());
    // System.out.println("Gyro Yaw is " + gyro.getState());
    // System.out.println("Gyro Angle is " + gyro2.getAngle());
    // System.out.println("Gyro Yaw is " + gyro2.getYaw());
    // System.out.println("Gyro Roll is " + gyro2.getRoll());
    // System.out.println("Gyro Pitch is " + gyro2.getPitch());
  }

  public double getGyroAngle() {
    return gyro2.getYaw();
  }

  public void driveStraight(Double speed) {
    drive.tankDrive(speed, speed);
  }

  public void driveStraightWithGyro(double power) {
    double error = 0 - getGyroAngle();
    double turnPower = Constants.dtkP * error;
    // System.out.println("error" + turnPower);
    drive.arcadeDrive(power, turnPower, false);
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
