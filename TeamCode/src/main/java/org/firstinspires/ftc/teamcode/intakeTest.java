package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "INTAKETEST")

public class intakeTest extends OpMode {

    private double speedMod;
    private DcMotor intake;
    private boolean wasPressed;

    public void init() {
        DcMotor intake = hardwareMap.dcMotor.get("intake");
        speedMod = 1;
        wasPressed = false;
    }

    public void loop() {
        if (gamepad1.right_trigger >= 0.8) { //run flywheel
            intake.setPower(-speedMod);
        } else if (gamepad1.left_trigger >= 0.8) {
            intake.setPower(speedMod);
        } else {
            intake.setPower(0);
        }

        if (gamepad1.left_bumper && !wasPressed) { //speed controls (checks last state)
            speedMod = Math.max(0, speedMod - 0.05);
            wasPressed = true;
        } else if (gamepad1.right_bumper && !wasPressed) {
            speedMod = Math.min(1, speedMod + 0.05);
            wasPressed = true;
        } else if (!gamepad1.left_bumper && !gamepad1.right_bumper){
            wasPressed = false;
        }

    }
}
