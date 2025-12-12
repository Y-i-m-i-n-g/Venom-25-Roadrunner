package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp(name = "SYSTEMSTEST")

public class systemsTest extends OpMode {

    private double speedMod1, speedMod2;
    private DcMotor intake;
    private DcMotor fly;
    private boolean wasPressed1, wasPressed2;

    public void init() {
        intake = hardwareMap.get(DcMotorEx.class, "intake");
        fly = hardwareMap.get(DcMotorEx.class, "fly");

        speedMod1 = 1;
        speedMod2 = 1;
        wasPressed1 = false;
        wasPressed2 = false;
    }

    public void loop() {
        if (gamepad1.right_trigger >= 0.8) { //run flywheel
            intake.setPower(-speedMod1);
        } else if (gamepad1.left_trigger >= 0.8) {
            intake.setPower(speedMod1);
        } else {
            intake.setPower(0);
        }

        if (gamepad1.left_bumper && !wasPressed1) { //speed controls (checks last state)
            speedMod1 = Math.max(0, speedMod1 - 0.05);
            wasPressed1 = true;
        } else if (gamepad1.right_bumper && !wasPressed1) {
            speedMod1 = Math.min(1, speedMod1 + 0.05);
            wasPressed1 = true;
        } else if (!gamepad1.left_bumper && !gamepad1.right_bumper){
            wasPressed1 = false;
        }

        if (gamepad2.right_trigger >= 0.8) { //run flywheel
            fly.setPower(-speedMod2);
        } else if (gamepad2.left_trigger >= 0.8) {
            fly.setPower(speedMod2);
        } else {
            fly.setPower(0);
        }

        if (gamepad2.left_bumper && !wasPressed2) { //speed controls (checks last state)
            speedMod2 = Math.max(0, speedMod2 - 0.05);
            wasPressed2 = true;
        } else if (gamepad2.right_bumper && !wasPressed2) {
            speedMod2 = Math.min(1, speedMod2 + 0.05);
            wasPressed2 = true;
        } else if (!gamepad2.left_bumper && !gamepad2.right_bumper){
            wasPressed2 = false;
        }
        telemetry.addLine("INTAKE SPEED: " + speedMod1);

        telemetry.addLine("FLYWHEEL SPEED: " + speedMod2);
        telemetry.update();

    }
}
