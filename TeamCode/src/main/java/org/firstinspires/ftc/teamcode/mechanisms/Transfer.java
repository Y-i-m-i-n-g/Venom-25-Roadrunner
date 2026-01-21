package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Transfer {

    private CRServo transfer;

    public void init(HardwareMap hw) {
        //hardware mapping
        transfer = hw.get(CRServo.class, "transfer");
    }

    public String transfer(Gamepad g2) {
        if (g2.dpad_up) { //run transfer
            transfer.setPower(0.6);
            return "1";
        } else if (g2.dpad_down) {
            transfer.setPower(-0.6);
            return "2";
        } else {
            transfer.setPower(0);
            return "3";
        }
    }
}
