package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Turret {

    private DcMotorEx turret;

    public void init(HardwareMap hw) {
        //hardware mapping
        turret = hw.get(DcMotorEx.class, "turnTable");
    }

    public void rotate(Gamepad g2) {
    }
}