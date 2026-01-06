package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.mechanisms.Shooter;

@TeleOp
public class drivetrainMotorsTest extends OpMode {

    private DcMotorEx fL, bL, fR, bR;
    public void init() {
        fL = hardwareMap.get(DcMotorEx.class, "frontLeft");
        bL = hardwareMap.get(DcMotorEx.class, "backLeft");
        fR = hardwareMap.get(DcMotorEx.class, "frontRight");
        bR = hardwareMap.get(DcMotorEx.class, "backRight");
    }

    public void loop() {
        if (gamepad1.a) {
            fL.setPower(1);
        }

        if (gamepad1.b) {
            bL.setPower(1);
        }

        if (gamepad1.y) {
            fR.setPower(1);
        }

        if (gamepad1.x) {
            bR.setPower(1);
        }
    }
}
