// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

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

    // drive train PID
    public static final double dtkP = (1.0 / 360.0) * 15;

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

    public static final double motorSpeedMultiplier = 0.6;
    public static final double motorSpeedMultiplierLeft = 0.98;// 0.8;
    public static final double motorSpeedMultiplierRight = 1; // 0.9;

    public static boolean inLowGear = false;
    public static final double highGear = 0.9;
    public static final double lowGear = 0.5;

    // launcher motors
    public static final int motorTop = 3;// 3;Left
    public static final int motorBottom = 4;// 4 Right
    public static final double launcherSpeed = 0.9;// 0.725;
    public static final double intakeSpeed = 0.25;
    // gyro
    public static final int gyroID = 2;
    // smacna sensors
    public static final int smacnaTopDIO = 1;
    public static final int smacnaBottomDIO = 0;
    public static int ballcount = 0;

    // LED Control Objects
    public static final String ledBlink = "Blink";
    public static final String ledUnBlink = "UnBlink";
    public static final String ledRed = "Red";
    public static final String ledBlue = "Blue";
    public static final String LED_Default = "default";
    public static final String LED_OneBall = "one";
    public static final String LED_TwoBall = "two";
    public static final String LED_Error = "error";

}