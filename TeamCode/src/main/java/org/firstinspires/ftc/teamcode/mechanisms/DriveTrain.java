package org.firstinspires.ftc.teamcode.mechanisms;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveTrain {
    private DcMotorEx fL, bL, fR, bR;
    public void init(HardwareMap hw) {
        fL = hw.get(DcMotorEx.class, "frontLeft");
        bL = hw.get(DcMotorEx.class, "backLeft");
        fR = hw.get(DcMotorEx.class, "frontRight");
        bR = hw.get(DcMotorEx.class, "backRight");

        fR.setDirection(DcMotor.Direction.REVERSE);
        bR.setDirection(DcMotor.Direction.REVERSE);


    }

    public void mecanumDrive(Gamepad g1, Gamepad g2) {
        double y = g1.left_stick_y; // Remember, Y stick value is reversed
        double x = -g1.left_stick_x; // Counteract imperfect strafing
        double rx = -g1.right_stick_x;

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;

        fL.setPower(frontLeftPower);
        bL.setPower(backLeftPower);
        fR.setPower(frontRightPower);
        bR.setPower(backRightPower);
    }
}
