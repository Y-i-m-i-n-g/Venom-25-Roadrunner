package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooter {
    private DcMotor fly;
    private CRServo lFeed, rFeed;
    private boolean wasPressed;
    private double speedMod;
    public void init(HardwareMap hw) {
        fly = hw.get(DcMotorEx.class, "flyWheel");
        fly.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lFeed = hw.get(CRServo.class, "leftFeeder");
        rFeed = hw.get(CRServo.class, "rightFeeder");
        speedMod = 0.65;
    }

    public void shoot(Gamepad g2) {
        if (g2.right_trigger >= 0.8) { //run flywheel
            fly.setPower(-speedMod);
        } else if (g2.left_trigger >= 0.8) {
            fly.setPower(speedMod);
        } else {
            fly.setPower(0);
        }

        if (g2.x) { //feed ball into the shooter
            lFeed.setPower(1);
            rFeed.setPower(-1);
        } else if (g2.b) {
            lFeed.setPower(-1);
            rFeed.setPower(1);
        } else {
            lFeed.setPower(0);
            rFeed.setPower(0);
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

    public double getSpeed() {
        return speedMod;
    }

}
