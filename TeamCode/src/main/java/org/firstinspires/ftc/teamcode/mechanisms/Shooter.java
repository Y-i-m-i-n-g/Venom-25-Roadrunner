package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Shooter {

    private DcMotorEx fly;
    private boolean wasPressed;
    private double speedMod;

    public void init(HardwareMap hw) {
        //hardware mapping
        fly = hw.get(DcMotorEx.class, "flyWheel"); //TODO: Add hood servo
        fly.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fly.setDirection(DcMotor.Direction.REVERSE);

        //currently obsolete, used to set default speed of shooter
        speedMod = 0.65;
    }

    public void shoot(Telemetry telemetry, Gamepad g2) {
        if (g2.right_trigger >= 0.8) { //run flywheel
            fly.setPower(-speedMod); //TODO: Use setVelocity and setPIDFCoefficients or whatever
        } else if (g2.left_trigger >= 0.8) {
            fly.setPower(speedMod);
        } else {
            fly.setPower(0);
        }

        if (g2.left_bumper && !wasPressed) { //speed controls (checks last state)
            speedMod = Math.max(0, speedMod - 0.05);
            wasPressed = true;
        } else if (g2.right_bumper && !wasPressed) {
            speedMod = Math.min(1, speedMod + 0.05);
            wasPressed = true;
        } else if (!g2.left_bumper && !g2.right_bumper){
            wasPressed = false;
        }

    }

    public double getspeedMod() {
        return speedMod;
    }

    public double getVelocity() {
        return fly.getVelocity();
    }


//Obsolete PID code, left for posterity

//    private ElapsedTime timer;

//    private double kP, kI, kD;
//    private double integralSum;
//    private double previous_error, previous_time;


//        //PID coefficents + variables
//        kP = coefficents[0];
//        kI = coefficents[1];
//        kD = coefficents[2];
//        integralSum = 0;
//
//        //Timer for PID
//        ElapsedTime timer = new ElapsedTime();



//    public void PIDshoot (double current_error, double previous_error, double current_time, double previous_time){
//        //double current_time = timer.seconds();
//        //double error = goal_speed - current_speed;
//
//        double p = kP * current_error;
//
//        double i = kI * current_error * (current_time - previous_time);
//        i = Math.min(i, 1);
//        i = Math.max(i, -1);
//
//        double d = kD * (current_error - previous_error) / (current_time - previous_time);
//        fly.setVelocityPIDFCoefficients();
//        flyWheel.setVelocity(p + i + d);
//
//
//   }



}
