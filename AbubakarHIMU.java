// package org.firstinspires.ftc.teamcode;

// import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
// import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
// import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
// import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
// import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
// import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
// import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.util.ElapsedTime;
// import com.qualcomm.hardware.bosch.BNO055IMU;

// @Autonomous

// public class AbubakarHIMU extends LinearOpMode {

//     BNO055IMU imu;
    
//     double kp = 0.5;
//     double ki = 0.5;
//     double kd = 0.5;
//     double previous = 0;
//     double integral = 0;
    
//     ElapsedTime elapsedTime = new ElapsedTime();
    
//     @Override
//     public void runOpMode() {
        

//         BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
//         imu = hardwareMap.get(BNO055IMU.class, "imu");
//         parameters.mode = BNO055IMU.SensorMode.IMU(
//             new RevHubOrientationOnRobot(
//                 RevHubOrientationOnRobot.LogofacingDirection.UP,
//                 RevHubOrientationOnRobot.UsbFacingDirection.RIGHT
//             ));
            
//         parameters.mode = BNO055IMU.SensorMode.IMU;
//         parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
//         imu.initialize(parameters);
        
//         YawPitchRollAngles robotOrientation;
//         robotOrientation = imu.getRobotOrientation( 
//          AxesReference.INTRINSIC,
//          AxesOrder.XYZ,
//          AngleUnit.DEGREES
//          );
        
//         waitForStart();
        
    
    
         
//          while (opModeIsActive){
             
//              float Yaw = robotOrientation.firstAngle;
//              float Pitch = robotOrientation.secondAngle;
//              float Roll = robotOrientation.thirdAngle;
//              telmentry.addData("imu yaw:", Yaw);
//              telmentry.addData("imu pitch:", Pitch);
//              telmentry.addData("imu roll:", Roll);
//              telemetry.update();
//              idle();
//          }
         
     
//     }
    
//      public double PIDController(double target, double current){
//          double currentTime = elapsedTime.time();
//          double proportionError = target - current;
//          integral += proportionError * currentTime;
//          double derivative = (current - previous) / (currentTime);
//          previous = current;
//          elapsedTime.reset();
//          return proportionError * kp + integral * ki + derivative * kd;
//      }
//  }
