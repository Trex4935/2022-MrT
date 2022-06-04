// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.XboxController;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    // drive train

    public static final int leftTopCanID = 1;// 1;
    public static final int leftBottomCanID = 2;// 2;11;
    public static final int rightTopCanID = 5;// 5;2
    public static final int rightBottomCanID = 6;// 6;

    // controller
    // shooting axis
    public static final int rTriggerAxis = 3;
    public static final int lTriggerAxis = 2;
    // drive axis
    public static final int leftAxis = 1;
    public static final int rightAxis = 5;

    // xbox controller
    public static final int xboxID = 0;

    // Invert drive train

    public static final int leftInvert = -1;
    public static final int rightInvert = -1;

    public static final double motorSpeedMultiplier = 1;
    public static final double motorSpeedMultiplierLeft = 1;// 0.8;
    public static final double motorSpeedMultiplierRight = 1; // 0.9;

    // launcher motors
    public static final int motorTop = 3;// 3;Left
    public static final int motorBottom = 4;// 4 Right
    public static final double launcherSpeed = 0.7;// 0.725;
    public static final double intakeSpeed = 0.3;
    // gyro
    public static final int gyroID = 2;
    // smacna sensors
    public static final int smacnaTopDIO = 3;
    public static final int smacnaBottomDIO = 6;
}
