package frc.team3322.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
    static Drivetrain drivetrain;
    static Arm arm;
    static CandyCane candyCane;
    static XboxController xbox;
    static Auton auton;

    private double autonStartTime, teleopStartTime;

    public Robot() {
        drivetrain = new Drivetrain();
        arm = new Arm();
        candyCane = new CandyCane();
        xbox = new XboxController(0);
    }

    @Override
    public void robotInit() {
        SmartDashboard.putNumber("FrontLeftMotor", RobotMap.frontLeftMotor);
        SmartDashboard.putNumber("RearLeftMotor", RobotMap.rearLeftMotor);
        SmartDashboard.putNumber("FrontRightMotor", RobotMap.frontRightMotor);
        SmartDashboard.putNumber("RearRightMotor", RobotMap.rearRightMotor);
        SmartDashboard.putNumber("ArmMotor", RobotMap.armMotor);
        SmartDashboard.putNumber("CandyCane", RobotMap.candyCane);
        SmartDashboard.putNumber("CubeHolderMotor", RobotMap.grabberMotor);
    }

    @Override
    public void disabledInit() { }

    @Override
    public void autonomousInit() {
        autonStartTime = System.currentTimeMillis();
    }

    @Override
    public void teleopInit() {
        teleopStartTime = System.currentTimeMillis();
    }

    @Override
    public void testInit() { }


    @Override
    public void disabledPeriodic() { }
    
    @Override
    public void autonomousPeriodic() {
        auton.run();

        SmartDashboard.putString("Elapsed Time", getElapsedTime(autonStartTime) + " seconds");
        SmartDashboard.putBoolean("AutonOver", !(getElapsedTime(autonStartTime) < 15));
    }

    @Override
    public void teleopPeriodic() {
        SmartDashboard.putString("Elapsed Time", getElapsedTime(teleopStartTime) + " seconds");
        SmartDashboard.putBoolean("AutonOver", !(getElapsedTime(teleopStartTime) < 135));

        drivetrain.drive(xbox.getY(GenericHID.Hand.kLeft), xbox.getX(GenericHID.Hand.kRight));

        arm.moveArm(xbox.getTriggerAxis(GenericHID.Hand.kLeft), xbox.getTriggerAxis(GenericHID.Hand.kRight));
        arm.moveGrabber(xbox.getAButton(), xbox.getBButton());

        candyCane.moveCane(xbox.getBumper(GenericHID.Hand.kLeft), xbox.getBumper(GenericHID.Hand.kRight));
    }

    @Override
    public void testPeriodic() { }

    private double getElapsedTime(double startTime) {
        double elapsedTime = (System.currentTimeMillis() - startTime)/1000;
        return (double) Math.round(elapsedTime * 100) / 100;
    }

    public double getAutonStartTime() {
        return autonStartTime;
    }
}