package org.firstinspires.ftc.teamcode.teleops;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

import org.firstinspires.ftc.teamcode.mechanisms.DriveTrain;
import org.firstinspires.ftc.teamcode.mechanisms.Intake;
import org.firstinspires.ftc.teamcode.mechanisms.Shooter;
import org.firstinspires.ftc.teamcode.mechanisms.Transfer;
import org.firstinspires.ftc.teamcode.mechanisms.Turret;

@Config
@TeleOp
public class ShooterTest extends OpMode {
    Shooter Shoot = new Shooter();

    public static PIDFCoefficients pidfCoefficients = new PIDFCoefficients();
    public static double CurrentVelocity;

    @Override
    public void init() {
        Shoot.init(hardwareMap);
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
    }


    @Override
    public void loop() {
        Shoot.shoot(telemetry, gamepad2);
        telemetry.addData("Current Velocity", Shoot.getVelocity());
        telemetry.addLine("Speed: " + Shoot.getspeedMod());
        telemetry.update();
    }
}

