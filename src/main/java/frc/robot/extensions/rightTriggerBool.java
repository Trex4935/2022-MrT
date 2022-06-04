package frc.robot.extensions;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class rightTriggerBool extends Trigger {
    @Override
    public boolean get() {
        /*
         * checks if the right trigger axis is above 0.25 then return true or false
         */
        if (RobotContainer.controller.getRawAxis(Constants.rTriggerAxis) >= 0.25) {
            // trigger is pressed
            return true;
        } else {
            // trigger isn't pressed
            return false;
        }

    }
}
