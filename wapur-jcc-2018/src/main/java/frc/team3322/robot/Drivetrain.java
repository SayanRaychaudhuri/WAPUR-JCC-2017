package frc.team3322.robot;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;

public class Drivetrain {
    RobotDrive robotDrive;
    private double error;
    public enum pControl {
        DRIVE,
        PDRIVE
    }

    public Drivetrain() {
        CANTalon frontLeftMotor = new CANTalon(RobotMap.frontLeftMotor);
        CANTalon rearLeftMotor = new CANTalon(RobotMap.rearLeftMotor);
        CANTalon frontRightMotor = new CANTalon(RobotMap.frontRightMotor);
        CANTalon rearRightMotor = new CANTalon(RobotMap.rearRightMotor);

        frontLeftMotor.setInverted(true);
        rearLeftMotor.setInverted(true);
        frontRightMotor.setInverted(true);
        rearRightMotor.setInverted(true);

        robotDrive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
    }

    public void drive(double move, double rotate) {
        robotDrive.arcadeDrive(move, rotate);
    }

}
