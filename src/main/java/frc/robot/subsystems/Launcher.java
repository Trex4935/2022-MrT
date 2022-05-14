// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Launcher extends SubsystemBase {

  WPI_TalonSRX motorTop;
  WPI_TalonSRX motorBottom;

  MotorControllerGroup launcherMotorGroup;

  /** Creates a new Launcher. */
  public Launcher() {
    motorTop = new WPI_TalonSRX(Constants.motorTop);
    motorBottom = new WPI_TalonSRX(Constants.motorBottom);

    launcherMotorGroup = new MotorControllerGroup(motorTop, motorBottom);

  }

  public void runLauncher(double speed) {
    launcherMotorGroup.set(speed);
  }

  public void stopLauncher() { 
    motorTop.stopMotor();
    motorBottom.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
