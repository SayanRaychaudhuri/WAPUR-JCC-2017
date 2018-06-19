package frc.team3322.robot;

public class Auton {
    private int state = 0;
    Robot robot;

    Auton() {
        robot = new Robot();
    }

    public void run() {
        switch (state) {
            case 0:
                if (System.currentTimeMillis() - robot.getAutonStartTime() >= 5000) {
                    state++;
                } else {
                    Robot.arm.getGrabberMotor().set(1);
                }
                break;
            case 1:
                if (System.currentTimeMillis() - robot.getAutonStartTime() >= 8500) {
                    state++;
                } else {
                    Robot.drivetrain.drive(1,0);
                }
                break;
        }
    }
}
