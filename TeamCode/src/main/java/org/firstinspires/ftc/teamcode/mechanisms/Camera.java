package org.firstinspires.ftc.teamcode.mechanisms;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Camera extends OpMode {

    Limelight3A LL;

    public void init(){
        LL = hardwareMap.get(Limelight3A.class, "limeLight");
        LL.setPollRateHz(100);
        LL.start();
    }

}
