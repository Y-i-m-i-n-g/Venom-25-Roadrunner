package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.mechanisms.Transfer;

public class TransferTest extends OpMode {
    Transfer Transfer = new Transfer();

    @Override
    public void init() {
        Transfer.init(hardwareMap);
    }


    @Override
    public void loop() {
        Transfer.transfer(gamepad2);
    }
}
