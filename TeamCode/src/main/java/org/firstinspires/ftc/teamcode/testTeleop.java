package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.testmechanisms.testDriveTrain;

public class testTeleop extends OpMode {
    public void init() {
        testDriveTrain mecha1 = new testDriveTrain();
        mecha1.initDriveTrain(hardwareMap);
    }

    public void loop() {

    }
}
