package org.firstinspires.ftc.teamcode.mechanisms;


import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {

    private DcMotorEx intake;

    public void init(HardwareMap hw) {
        //hardware mapping
        intake = hw.get(DcMotorEx.class, "intake");
    }

    public String intake(Gamepad g2) {
        if (g2.y) { //run intake00
            intake.setPower(1);
            return "a";
        } else if (g2.a) {
            intake.setPower(-1);
            return "b";
        } else {
            intake.setPower(0);
            return "c";
        }
    }


}
