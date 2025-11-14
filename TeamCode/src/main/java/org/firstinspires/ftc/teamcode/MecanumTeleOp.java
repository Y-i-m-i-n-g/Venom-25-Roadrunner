package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.mechanisms.DriveTrain;
import org.firstinspires.ftc.teamcode.mechanisms.Shooter;

@TeleOp
public class MecanumTeleOp extends OpMode {
    DriveTrain Drive = new DriveTrain();
    Shooter Shoot = new Shooter();
    @Override
    public void init() {
        Drive.init(hardwareMap);
        Shoot.init(hardwareMap);
    }

    @Override
    public void loop() {
        Drive.mecanumDrive(gamepad1, gamepad2);
        Shoot.shoot(gamepad2);

        telemetry.addLine(String.format("Drivetrain Speed: %.1f", Drive.getSpeed()));
        telemetry.addLine(String.format("Shoot Speed: %.1f", Shoot.getSpeed()));
        telemetry.addLine("Gamepad 2: Bumpers to spin flywheel, X and B to spin servos, D pad to modify speed");
        telemetry.update();
    }
}
