package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import android.annotation.SuppressLint;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.mechanisms.DriveTrain;
import org.firstinspires.ftc.teamcode.mechanisms.Shooter;

@TeleOp(name = "A | USE THIS TELEOP")
public class MecanumTeleOp extends OpMode {
    DriveTrain Drive = new DriveTrain();
    Shooter Shoot = new Shooter();
    @Override
    public void init() {
        Drive.init(hardwareMap);
        Shoot.init(hardwareMap);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void loop() {
        Drive.mecanumDrive(gamepad1, gamepad2);
        //Shoot.shoot(gamepad2);

        telemetry.addLine(String.format("Drivetrain Speed: %.2f", Drive.getSpeed()));
        telemetry.addLine(String.format("Shoot Speed: %.2f", Shoot.getSpeed()));

        telemetry.addLine("\n\n\nControls\nDriver 1: Joysticks for Movement | Right Bumper: Increases speed by 0.2 | Left Bumper: Decreases speed by 0.2");
        telemetry.addLine("\nDriver 2: Right Trigger: Spins flywheel forward (shoots ball) | Left Trigger: Spins flywheel backwards | X: Feeds ball into flywheel | B: Retracts ball from flywheel | Right Bumper: Increases speed by 0.2 | Left Bumper: Decreases speed by 0.2");

        telemetry.update();

    }
}
