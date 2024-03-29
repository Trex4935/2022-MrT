// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Launcher;

public class c_reverseLauncherUntilSmakna extends CommandBase {

  private final Launcher launch;

  /** Creates a new c_startLauncher. */
  public c_reverseLauncherUntilSmakna(Launcher lch) {
    launch = lch;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(launch);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    launch.runLauncher(-Constants.intakeSpeed);
    SmartDashboard.putString("LED_Control", Constants.ledBlink);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    launch.stopLauncher();
    SmartDashboard.putString("LED_Control", Constants.LED_Default);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return launch.getBottomSmacna();
  }
}
