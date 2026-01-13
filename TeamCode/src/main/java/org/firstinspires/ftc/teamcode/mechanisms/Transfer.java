package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Transfer {

    private DcMotorEx transfer;

    public void init(HardwareMap hw) {
        //hardware mapping
        transfer = hw.get(DcMotorEx.class, "transfer");
    }

    public void transfer(Gamepad g2) {
        if (g2.b) { //run flywheel
            transfer.setPower(0.6);
        } else if (g2.x) {
            transfer.setPower(-0.6);
        } else {
            transfer.setPower(0);
        }
    }
}
