package frc.team3322.robot;

import edu.wpi.first.wpilibj.Talon;

public class CandyCane {
    private Talon candyCane;

    CandyCane() {
        candyCane = new Talon(RobotMap.candyCane);
    }

    public void moveCane(boolean forward, boolean backward) {
        if (forward && backward) {
            return;
        }

        candyCane.set(forward ? 0.5 : backward ? -0.5 : 0);
    }
}
