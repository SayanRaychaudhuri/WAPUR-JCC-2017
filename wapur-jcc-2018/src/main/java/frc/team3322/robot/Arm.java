package frc.team3322.robot;

import edu.wpi.first.wpilibj.Talon;

public class Arm {
    private Talon armMotor;
    private Talon grabberMotor;

    public Arm() {
        armMotor = new Talon(RobotMap.armMotor);
        grabberMotor = new Talon(RobotMap.grabberMotor);
    }

    public void moveArm(double forward, double backward) {
        armMotor.set(forward - backward);
    }

    public void moveGrabber(boolean forward, boolean backward) {
        if (forward && backward) {
            return;
        }

        grabberMotor.set(forward ? 1 : backward ? -1 : 0);
    }

    public Talon getArmMotor() {
        return armMotor;
    }

    public Talon getGrabberMotor() {
        return grabberMotor;
    }
}
