// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.LED;

public class c_UpdateLED extends CommandBase {
  /** Creates a new c_BallCount. */
  private final LED myled;

  public c_UpdateLED(LED led) {
    myled = led;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(myled);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    switch (Constants.ballcount) {
      case 1:
        SmartDashboard.putString("LED_Control", Constants.LED_OneBall);

      case 2:
        SmartDashboard.putString("LED_Control", Constants.LED_TwoBall);

      case 0:
        SmartDashboard.putString("LED_Control", Constants.LED_Error);

      default:
        SmartDashboard.putString("LED_Control", Constants.LED_Default);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
