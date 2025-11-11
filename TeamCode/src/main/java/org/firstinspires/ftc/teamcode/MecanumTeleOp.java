package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.DriveTrain;

@TeleOp
public class MecanumTeleOp extends OpMode {
    DriveTrain Drive = new DriveTrain();
    @Override
    public void init() {
        Drive.init(hardwareMap);
    }

    @Override
    public void loop() {
        Drive.mecanumDrive(gamepad1, gamepad2);
    }
}
