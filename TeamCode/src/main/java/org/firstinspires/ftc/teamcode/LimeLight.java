package org.firstinspires.ftc.teamcode;


import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;

public class LimeLight extends OpMode {

    private Limelight3A camera;
    private IMU imu;
    @Override
    public void init() {
        imu = hardwareMap.get(IMU.class, "imu");
        imu.initialize(new IMU.Parameters(
                new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP,
                        RevHubOrientationOnRobot.UsbFacingDirection.FORWARD)));
        camera = hardwareMap.get(Limelight3A.class, "limelight");
        camera.setPollRateHz(100);
        telemetry.setMsTransmissionInterval(11);
        camera.pipelineSwitch(8);
    }

    @Override
    public void start(){
        camera.start();
    }
    @Override
    public void loop(){
        camera.updateRobotOrientation(imu.getRobotYawPitchRollAngles().getYaw());
        LLResult llResult = camera.getLatestResult();
        if (llResult != null && llResult.isValid()){
            Pose3D botPose = llResult.getBotpose();
            telemetry.addData("tx", llResult.getTx());
            telemetry.addData("ty", llResult.getTy());
            telemetry.addData("BotPose", botPose.toString());
        }
    }
}
