// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class c_toggleSpeed extends CommandBase {
  DriveTrain driveTrain;
  double startSpeed;

  /** Creates a new c_toggleSpeed. */
  public c_toggleSpeed(DriveTrain drive) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveTrain = drive;
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Constants.gear == "high") {
      Constants.gear = "low";
    } else {
      Constants.gear = "high";
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Constants.gearChange = true;

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
