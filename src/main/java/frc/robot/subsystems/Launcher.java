// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.extensions.FlippedDIO;

public class Launcher extends SubsystemBase {

  WPI_TalonSRX motorTop;
  WPI_TalonSRX motorBottom;
  FlippedDIO smacnaTop;
  FlippedDIO smacnaBottom;
  int ballcount;
  int i;
  boolean ballDetect;

  MotorControllerGroup launcherMotorGroup;

  /** Creates a new Launcher. */
  public Launcher() {
    motorTop = new WPI_TalonSRX(Constants.motorTop);
    motorBottom = new WPI_TalonSRX(Constants.motorBottom);

    // default setting
    motorTop.configFactoryDefault();
    motorBottom.configFactoryDefault();

    // invert
    motorTop.setInverted(true);
    motorBottom.setInverted(false);

    // launcherMotorGroup = new MotorControllerGroup(motorTop, motorBottom);
    smacnaTop = new DigitalInput(Constants.smacnaTopDIO);
    smacnaBottom = new DigitalInput(Constants.smacnaBottomDIO);
    ballcount = 0;
    i = 0;
    ballDetect = false;

  }

  public void runLauncher(double speed) {
    // launcherMotorGroup.set(speed);
    motorTop.set(speed);
    motorBottom.set(speed);
  }

  public void stopLauncher() {
    motorTop.stopMotor();
    motorBottom.stopMotor();
  }

  public boolean getTopSmacna() {

    return smacnaTop.get();

  }

  public boolean getBottomSmacna() {
    return smacnaBottom.get();
  }

  public void singulateball() {
    // if (!ballDetect) {
    // runLauncher(0.5);
    // }
    // // If i see bal run motors
    // if (getBottomSmacna()) {
    // ballDetect = true;
    // i = 0;
    // runLauncher(0.5);

    // } else if { // if i dont see ball stop motor after 10 ticks than count.
    // if (i == 10) {
    // stopLauncher();
    // ballcount = ballcount + 1;
    // ballDetect = false;
    // } else {
    // i = i + 1;
    // }

    // }

  }

  public void countball() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
