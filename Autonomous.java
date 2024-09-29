package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous

public class OmarCompition extends LinearOpMode {
    DcMotor fl = null;
    DcMotor fr = null;
    DcMotor bl = null;
    DcMotor br = null;
    
    @Override
    public void runOpMode() {
        
            
        fl  = hardwareMap.get(DcMotor.class, "fl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        bl  = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");
        
        fr.setDirection(DcMotor.Direction.REVERSE);
        bl.setDirection(DcMotor.Direction.FORWARD);
        fl.setDirection(DcMotor.Direction.FORWARD);
        br.setDirection(DcMotor.Direction.REVERSE);
        
        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        br.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
        
        
        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        waitForStart();
        
    }
    
     public void move(int lTarget, int rTarget, double speed){
         bl.setTargetPosition(lTarget);
         fl.setTargetPosition(lTarget);
         br.setTargetPosition(rTarget);
         fr.setTargetPosition(rTarget);
         
         
         fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
         fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
         bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
         br.setMode(DcMotor.RunMode.RUN_TO_POSITION);
         
        fl.setPower(speed);
         fr.setPower(speed);
         bl.setPower(speed);
         br.setPower(speed);
         
         while (opModeIsActive() && (fl.isBusy() || bl.isBusy() || br.isBusy())){
             telemetry.addData("fr position", fr.getCurrentPosition());
             telemetry.addData("br position", br.getCurrentPosition());
             telemetry.addData("fl position", fl.getCurrentPosition());
             telemetry.addData("bl position", bl.getCurrentPosition());
             telemetry.update();
             idle();
         }
         fr.setPower(0);
         
     }
 }
