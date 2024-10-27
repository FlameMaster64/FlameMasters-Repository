package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.robotcore.external.navigation.AngularVelocity;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import static com.qualcomm.hardware.rev.RevHubOrientationOnRobot.xyzOrientation;

@Autonomous

public class AbubakarHassanIMU {

    double kp = 0.5;
    double ki = 0.5;
    double kd = 0.5;
    double previous = 0;
    double integral = 0;
    double angleRadians = Math.toRadians(90);
    ElapsedTime elapsedTime = new ElapsedTime();
    
    private DcMotor frontleftDrive = null;
    private DcMotor frontrightDrive = null;
    private DcMotor backleftDrive = null;
    private DcMotor backrightDrive = null;
    
    IMU imu;

    @Override public void runOpMode() throws InterruptedException {

        double xRotation = 0;
        double yrotation = 0;
        double zRotation = 0;

        Orientation hubRotation = xyzOrientation(xRotation, yRotation, zRotation);
        
        frontleftDrive  = hardwareMap.get(DcMotor.class, "frontLeft");
        frontrightDrive = hardwareMap.get(DcMotor.class, "frontRight");
        backleftDrive  = hardwareMap.get(DcMotor.class, "backLeft");
        backrightDrive  = hardwareMap.get(DcMotor.class, "backRight");
        
        frontleftDrive.setDirection(DcMotor.Direction.REVERSE);
        frontrightDrive.setDirection(DcMotor.Direction.FOWARD);
        backleftDrive.setDirection(DcMotor.Direction.REVERSE);
        backrightDrive.setDirection(DcMotor.Direction.FORWARD);


        imu = hardwareMap.get(IMU.class, "imu");

      //  RevHubOrientationOnRobot.LogoFacingDirection logoDirection = RevHubOrientationOnRobot.LogoFacingDirection.UP;
      //  RevHubOrientationOnRobot.UsbFacingDirection  usbDirection  = RevHubOrientationOnRobot.UsbFacingDirection.FORWARD;

        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(hubRotation);


        imu.initialize(new IMU.Parameters(orientationOnRobot));
        
        waitForStart();
        
        imu.resetYaw();

        while (!isStopRequested()) {
            
            double power = PIDController(angleRadians, imu.getAngularOrientation().firstAngle);
            frontLeftDrive.setPower(power);
            backLeftDrive.setPower(power);
            frontRightDrive.setPower(-power);
            backRightDrive.setPower(-power);

            telemetry.addData("Hub orientation", "Logo=%s   USB=%s\n ", logoDirection, usbDirection);

            // if (gamepad1.y) {
            //     telemetry.addData("Yaw", "Resetting\n");
            //     imu.resetYaw();
            // } else {
            //     telemetry.addData("Yaw", "Press Y (triangle) on Gamepad to reset\n");
            // }

            YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();
            AngularVelocity angularVelocity = imu.getRobotAngularVelocity(AngleUnit.DEGREES);

            telemetry.addData("Yaw (Z)", "%.2f Deg. (Heading)", orientation.getYaw(AngleUnit.DEGREES));
            telemetry.addData("Pitch (X)", "%.2f Deg.", orientation.getPitch(AngleUnit.DEGREES));
            telemetry.addData("Roll (Y)", "%.2f Deg.\n", orientation.getRoll(AngleUnit.DEGREES));
            telemetry.addData("Yaw (Z) velocity", "%.2f Deg/Sec", angularVelocity.zRotationRate);
            telemetry.addData("Pitch (X) velocity", "%.2f Deg/Sec", angularVelocity.xRotationRate);
            telemetry.addData("Roll (Y) velocity", "%.2f Deg/Sec", angularVelocity.yRotationRate);
            telemetry.update();
        }
    }
    
    public double PIDController(double target, double current){
        double currentTime = elapsedTime.time();
        double proportionError = target - current;
        integral += proportionError * currentTime;
        double derivative = (current - previous) / (currentTime);
        previous = current;
        elapsedTime.reset();
        return proportionError * kp + integral * ki + derivative * kd;
    }

  public double anglewrap(double radians) {
    while (radians > 180) {
        radians -= 360;
      }
   while (radians < -180) {
        radians += 360;
      }
      return radians;
  }

}   
