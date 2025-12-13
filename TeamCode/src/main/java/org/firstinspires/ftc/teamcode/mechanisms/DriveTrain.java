package org.firstinspires.ftc.teamcode.mechanisms;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveTrain {
    private DcMotorEx fL, bL, fR, bR;
    private boolean wasPressed;
    private double speedMod; //used as speed coefficient (e.g. 0.8 would be 80% speed, and so on
    public void init(HardwareMap hw) {
        fL = hw.get(DcMotorEx.class, "frontLeft");
        bL = hw.get(DcMotorEx.class, "backLeft");
        fR = hw.get(DcMotorEx.class, "frontRight");
        bR = hw.get(DcMotorEx.class, "backRight");

        fR.setDirection(DcMotor.Direction.REVERSE);
        bR.setDirection(DcMotor.Direction.REVERSE);

        speedMod = 1;

        wasPressed = false;


    }

    public void mecanumDrive(Gamepad g1, Gamepad g2) {
        double y = g1.left_stick_y; // Remember, Y stick value is reversed
        double x = -g1.left_stick_x; // Counteract imperfect strafing
        double rx = -g1.right_stick_x;

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double fLPow = (y + x + rx) / denominator;
        double bLPow = (y - x + rx) / denominator;
        double fRPow = (y - x - rx) / denominator;
        double bRPow = (y + x - rx) / denominator;

        fL.setPower(fLPow * speedMod);
        bL.setPower(bLPow * speedMod);
        fR.setPower(fRPow * speedMod);
        bR.setPower(bRPow * speedMod);

        if (g1.left_bumper && !wasPressed) {
            speedMod = Math.max(0, speedMod - 0.3);
            wasPressed = true;
        } else if (g1.right_bumper && !wasPressed) {
            speedMod = Math.min(1, speedMod + 0.3);
            wasPressed = true;
        }
        if (!g1.left_bumper && !g1.right_bumper){
            wasPressed = false;
        }
    }

    public double getSpeed() {
        return speedMod;
    }

    public boolean pressed() {
        return wasPressed;
    }
}
