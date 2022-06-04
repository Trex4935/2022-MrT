package frc.robot.extensions;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class leftTriggerBool extends Trigger {
    @Override
    public boolean get() {
        /*
         * checks if the left trigger axis is above 0.25 then return true or false
         */
        if (RobotContainer.controller.getRawAxis(Constants.lTriggerAxis) >= 0.25) {
            // trigger is pressed
            return true;
        } else {
            // trigger isn't pressed
            return false;
        }

    }
}
