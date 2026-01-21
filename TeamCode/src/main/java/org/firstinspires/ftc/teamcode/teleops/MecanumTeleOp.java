package org.firstinspires.ftc.teamcode.teleops;
import android.annotation.SuppressLint;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.DriveTrain;
import org.firstinspires.ftc.teamcode.mechanisms.Intake;
import org.firstinspires.ftc.teamcode.mechanisms.Shooter;
import org.firstinspires.ftc.teamcode.mechanisms.Transfer;
import org.firstinspires.ftc.teamcode.mechanisms.Turret;

@TeleOp(name = "USE THIS TELEOP")
public class MecanumTeleOp extends OpMode {
    DriveTrain Drive = new DriveTrain();

    Intake Intake = new Intake();
    Transfer Transfer = new Transfer();

    Shooter Shoot = new Shooter();
    //Turret Rotate = new Turret(); TODO: Add turntable for next robot

    @Override
    public void init() {
        Drive.init(hardwareMap);

        Intake.init(hardwareMap);
        Transfer.init(hardwareMap);

        Shoot.init(hardwareMap);
        //Rotate.init(hardwareMap);
    }


    @Override
    public void loop() {
        Drive.mecanumDrive(gamepad1);

        telemetry.addLine(Intake.intake(gamepad2));
        Transfer.transfer(gamepad2);

        Shoot.shoot(gamepad2);
        //Rotate.rotate(gamepad2);

        telemetry.addLine(String.format("Drivetrain Speed: %.2f", Drive.getSpeed()));
        telemetry.addLine(String.format("Shoot Speed: %.2f", Shoot.getSpeed()));

        telemetry.update();

    }
}
