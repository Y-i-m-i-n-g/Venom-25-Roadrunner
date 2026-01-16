package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.mechanisms.Intake;
import org.firstinspires.ftc.teamcode.mechanisms.Shooter;

public class IntakeTest extends OpMode {
    Intake Intake = new Intake();

    @Override
    public void init() {
        Intake.init(hardwareMap);
    }


    @Override
    public void loop() {
        Intake.intake(gamepad2);
    }
}
