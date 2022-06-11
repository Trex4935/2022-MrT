// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Launcher;

public class c_runLauncherUntilSmakna extends CommandBase {
  /** Creates a new c_runLauncherUntilSmakna. */
  public Launcher launcher;
  private boolean previousSmakna;

  public c_runLauncherUntilSmakna(Launcher launch) {
    launcher = launch;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(launcher);
    previousSmakna = launcher.getBottomSmacna();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    launcher.runLauncher(Constants.intakeSpeed);

    // If the bottom smacna doesn't equal the current smakna value
    if (launcher.getBottomSmacna() == previousSmakna) {
    }

    // Where the two don't match
    else {

      // If it has changed to true then we need to increment ball count
      if (launcher.getBottomSmacna()) {
        Constants.ballcount = Constants.ballcount + 1;
      }

      // Update previoussmakna with the current value of the sensor
      previousSmakna = launcher.getBottomSmacna();
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    launcher.stopLauncher();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return launcher.getTopSmacna();
  }
}
