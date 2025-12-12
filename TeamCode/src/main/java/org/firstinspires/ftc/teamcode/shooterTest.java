package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.Shooter;

@TeleOp
public class shooterTest extends OpMode {

    Shooter shoot = new Shooter();
    public void init() {
        shoot.init(hardwareMap);
    }

    public void loop() {
        shoot.velocityShoot();

    }
}
