// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.c_BallCount;
import frc.robot.commands.c_autoBackUp;
import frc.robot.commands.c_autoShootThenBackUp;
import frc.robot.commands.c_autoShootThenBackUpAndPickUp;
import frc.robot.commands.c_controlLeds;
import frc.robot.commands.c_driveWithController;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.LED;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;
import frc.robot.commands.c_runLauncher;
import frc.robot.commands.c_runLauncherUntilSmakna;
import frc.robot.commands.c_toggleSpeed;
import frc.robot.subsystems.Launcher;
import frc.robot.commands.c_reverseLauncher;
import frc.robot.commands.c_reverseLauncherUntilSmakna;
import frc.robot.extensions.leftTriggerBool;
import frc.robot.extensions.rightTriggerBool;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  public static XboxController controller;
  // The robot's subsystems and commands are defined here...
  private final DriveTrain driveTrain;
  private final LED LED;
  private final c_driveWithController driveWithController;
  private final c_runLauncher runLauncher;
  private final c_reverseLauncher reverseLauncher;
  private final Launcher launch;
  private final c_BallCount ballCount;
  private final c_autoBackUp autoBackUp;
  private final c_autoShootThenBackUp autoShootThenBackUp;
  private final c_runLauncherUntilSmakna runLauncherUntilSmakna;
  private final c_controlLeds controlLeds;
  private final c_autoShootThenBackUpAndPickUp autoShootThenBackUpAndPickUp;
  private final c_reverseLauncherUntilSmakna reverseLauncherUntilSmakna;
  private final c_toggleSpeed toggleSpeed;

  // triggers and buttons
  private JoystickButton button_a, button_b, button_x, button_y, bumper_r, bumper_l;
  private rightTriggerBool rTrigger;
  private leftTriggerBool lTrigger;

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    // controller
    controller = new XboxController(Constants.xboxID);
    // subsystems
    driveTrain = new DriveTrain();
    launch = new Launcher();
    LED = new LED();

    // commands
    driveWithController = new c_driveWithController(driveTrain, controller);
    autoBackUp = new c_autoBackUp(driveTrain);
    runLauncher = new c_runLauncher(launch);
    reverseLauncher = new c_reverseLauncher(launch);
    autoShootThenBackUp = new c_autoShootThenBackUp(launch, driveTrain);
    autoShootThenBackUpAndPickUp = new c_autoShootThenBackUpAndPickUp(launch, driveTrain);
    runLauncherUntilSmakna = new c_runLauncherUntilSmakna(launch);
    reverseLauncherUntilSmakna = new c_reverseLauncherUntilSmakna(launch);
    controlLeds = new c_controlLeds(launch);
    ballCount = new c_BallCount(LED);
    toggleSpeed = new c_toggleSpeed(driveTrain);

    driveTrain.setDefaultCommand(driveWithController);
    LED.setDefaultCommand(ballCount);
    // launch.setDefaultCommand(controlLeds);

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    bumper_r = new JoystickButton(controller, XboxController.Button.kRightBumper.value);
    bumper_r.whenHeld(runLauncherUntilSmakna);

    bumper_l = new JoystickButton(controller, XboxController.Button.kLeftBumper.value);
    bumper_l.whenHeld(reverseLauncherUntilSmakna);

    rTrigger = new rightTriggerBool();
    rTrigger.whileActiveOnce(runLauncher);

    lTrigger = new leftTriggerBool();
    lTrigger.whileActiveOnce(reverseLauncher);

    button_a = new JoystickButton(controller, XboxController.Button.kA.value);
    button_a.toggleWhenPressed(controlLeds);

    button_x = new JoystickButton(controller, XboxController.Button.kX.value);
    button_x.toggleWhenPressed(toggleSpeed);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return autoShootThenBackUpAndPickUp;
  }
}
