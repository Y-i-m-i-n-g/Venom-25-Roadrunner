package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.DriveTrain;
import org.firstinspires.ftc.teamcode.mechanisms.Intake;
import org.firstinspires.ftc.teamcode.mechanisms.Shooter;
import org.firstinspires.ftc.teamcode.mechanisms.Transfer;
import org.firstinspires.ftc.teamcode.mechanisms.Turret;

@TeleOp
public class ShooterTest extends OpMode {
    Shooter Shoot = new Shooter();

    @Override
    public void init() {
        Shoot.init(hardwareMap);
    }


    @Override
    public void loop() {
        Shoot.shoot(gamepad2);
        telemetry.addLine(String.format("Shoot Speed: %.2f", Shoot.getSpeed()));
        telemetry.update();
    }
}