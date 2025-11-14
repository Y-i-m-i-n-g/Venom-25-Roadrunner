package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooter {
    private DcMotor fly;
    private CRServo lFeed, rFeed;
    private double speedMod;

    public void init(HardwareMap hw) {
        fly = hw.get(DcMotorEx.class, "flyWheel");
        lFeed = hw.get(CRServo.class, "leftFeeder");
        rFeed = hw.get(CRServo.class, "rightFeeder");
        speedMod = 0.2;
    }

    public void shoot(Gamepad g2) {
        if (g2.right_bumper) {
            fly.setPower(-speedMod);
        } else if (g2.left_bumper) {
            fly.setPower(speedMod);
        } else {
            fly.setPower(0);
        }

        if (g2.x) {
            lFeed.setPower(1);
            rFeed.setPower(-1);
        } else if (g2.b) {
            lFeed.setPower(-1);
            rFeed.setPower(1);
        } else {
            lFeed.setPower(0);
            rFeed.setPower(0);
        }

            if (g2.dpadDownWasPressed()) {
            speedMod = Math.max(0, speedMod - 0.2);
        }
        if (g2.dpadUpWasPressed()) {
            speedMod = Math.min(1, speedMod + 0.2);
        }
    }

    public double getSpeed() {
        return speedMod;
    }

}
