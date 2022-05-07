// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.DriveTrain;
import frc.robot.Constants;


public class c_driveWithController extends CommandBase {

  private final DriveTrain drive;
  private final XboxController controller;
  /** Creates a new c_driveWithControler. */
  public c_driveWithController(DriveTrain dt, XboxController xbc) {
    // Use addRequirements() here to declare subsystem dependencies.
    drive = dt;
    controller = xbc;
    addRequirements(drive);
  }
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drive.driveWithController(controller);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.stopMotors();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
