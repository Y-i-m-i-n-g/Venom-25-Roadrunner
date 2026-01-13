package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveTrain {

    private DcMotorEx fL, bL, fR, bR;
    private boolean wasPressed; /*checks whether the bumpers were previously getPressed (ensures each
    bumper press only results in one change in speed)*/
    private double speedMod; //used as speed coefficient (e.g. 0.8 would be 80% speed, and so on)

    public void init(HardwareMap hw) {
        fL = hw.get(DcMotorEx.class, "frontLeft");
        bL = hw.get(DcMotorEx.class, "backLeft");
        fR = hw.get(DcMotorEx.class, "frontRight");
        bR = hw.get(DcMotorEx.class, "backRight");

        fR.setDirection(DcMotorSimple.Direction.REVERSE); //TODO: check and fix these
        bR.setDirection(DcMotor.Direction.REVERSE);

        speedMod = 1;
        wasPressed = false;
    }

    public void mecanumDrive(Gamepad g1) {
        double y = g1.left_stick_y;
        double x = -g1.right_stick_x;
        double rx = -g1.left_stick_x;

        //calculating coefficients
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1) / speedMod;
        double fLPow = (y + x + rx) / denominator;
        double bLPow = (y - x + rx) / denominator;
        double fRPow = (y - x - rx) / denominator;
        double bRPow = (y + x - rx) / denominator;

        fL.setPower(fLPow); //TODO: change these to setVelocity? TBD
        bL.setPower(bLPow);
        fR.setPower(fRPow);
        bR.setPower(bRPow);

        //if left bumper pressed, lower speed by 0.2. if right bumper pressed, raise by 0.2
        if (g1.left_bumper && !wasPressed) {
            speedMod = Math.max(0, speedMod - 0.2);
            wasPressed = true;
        } else if (g1.right_bumper && !wasPressed) {
            speedMod = Math.min(1, speedMod + 0.2);
            wasPressed = true;
        }
        if (!g1.left_bumper && !g1.right_bumper){
            wasPressed = false;
        }
    }

    public double getSpeed() {
        return speedMod;
    }

    public boolean getPressed() {
        return wasPressed;
    }
}
