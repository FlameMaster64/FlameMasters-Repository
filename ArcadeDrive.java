package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "AbubakarHassanArcadeDrive", group = "Linear OpMode")

public class AbubakarHassanArcadeDrive extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontleftDrive = null;
    private DcMotor frontrightDrive = null;
    private DcMotor backleftDrive = null;
    private DcMotor backrightDrive = null;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        
        frontleftDrive  = hardwareMap.get(DcMotor.class, "frontLeft");
        frontrightDrive = hardwareMap.get(DcMotor.class, "frontRight");
        backleftDrive  = hardwareMap.get(DcMotor.class, "backLeft");
        backrightDrive  = hardwareMap.get(DcMotor.class, "backRight");
        
        frontleftDrive.setDirection(DcMotor.Direction.REVERSE);
        frontrightDrive.setDirection(DcMotor.Direction.REVERSE);
        backleftDrive.setDirection(DcMotor.Direction.FORWARD);
        backrightDrive.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            
            double leftPower;
            double rightPower;
            
            double drive = -gamepad1.left_stick_y;
            double strafe = -gamepad1.left_stick_x;
            double turn  =  gamepad1.right_stick_x;
            leftPower    = Range.clip(drive + strafe + turn, -1.0, 1.0);
            rightPower   = Range.clip(drive - turn, -1.0, 1.0);
            frontleftDrive.setPower(leftPower);
            frontrightDrive.setPower(leftPower);
            backleftDrive.setPower(rightPower);
            backrightDrive.setPower(rightPower);


            



            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();
        }
    }
}
