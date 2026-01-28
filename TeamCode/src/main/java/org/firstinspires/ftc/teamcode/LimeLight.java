package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.ftc.OTOSIMU;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

@TeleOp(name = "Sensor: Limelight3A", group = "Sensor")
@Disabled

public class LimeLight extends LinearOpMode {

    private Limelight3A camera;
    private IMU imu;

    @Override

    public void runOpMode() throws InterruptedException{

        imu = hardwareMap.get(IMU.class, "imu");
        camera = hardwareMap.get(Limelight3A.class, "limelight");
        camera.setPollRateHz(100);
        telemetry.setMsTransmissionInterval(11);
        camera.pipelineSwitch(0);

        camera.start();
        IMU.Parameters parameters = new IMU.Parameters(
                new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD));
        imu.initialize(parameters);
        telemetry.addData(">", "Robot Ready.  Press Play.");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();
            camera.updateRobotOrientation(orientation.getYaw(AngleUnit.DEGREES));
            LLResult result = camera.getLatestResult();
            if (result != null) {
                if (result.isValid()) {
                    Pose3D botPose = result.getBotpose_MT2();
                    // Use botPose data
                }
            }
        }
    }
}
