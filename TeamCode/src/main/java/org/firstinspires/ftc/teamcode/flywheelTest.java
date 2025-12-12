package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp(name = "FLYWHEELTEST")

public class flywheelTest extends OpMode {

    private double speedMod;
    private DcMotor fly;
    private boolean wasPressed;

    public void init() {
        fly = hardwareMap.get(DcMotorEx.class, "fly");
        speedMod = 1;
        wasPressed = false;
    }

    public void loop() {
        if (gamepad1.right_trigger >= 0.8) { //run flywheel
            fly.setPower(-speedMod);
        } else if (gamepad1.left_trigger >= 0.8) {
            fly.setPower(speedMod);
        } else {
            fly.setPower(0);
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

        telemetry.addLine("FLYWHEEL SPEED: " + speedMod);
        telemetry.update();

    }
}
