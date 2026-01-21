package org.firstinspires.ftc.teamcode.autos;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Config
@Autonomous(name = "USE THIS AUTO", group = "AUTO")
public class budgetAuto extends LinearOpMode{

    private DcMotor frontRightMotor;
    private DcMotor frontLeftMotor;
    private DcMotor backRightMotor;
    private DcMotor backLeftMotor;

//    ElapsedTime timers = new ElapsedTime();

    public void runOpMode() throws InterruptedException{

        frontRightMotor = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeftMotor = hardwareMap.get(DcMotor.class, "frontLeft");
        backRightMotor = hardwareMap.get(DcMotor.class, "backRight");
        backLeftMotor = hardwareMap.get(DcMotor.class, "backLeft");

        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE); //TODO: check and fix these
        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotor.Direction.FORWARD); //TODO: check and fix these
        backRightMotor.setDirection(DcMotor.Direction.FORWARD);

        frontRightMotor.setPower(0);
        frontLeftMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);

        waitForStart();
        if (isStopRequested()) return;

//        double time = System.nanoTime() / 1E9;
//        while (timers.seconds() < 2){
//            frontRightMotor.setPower(.8);
//            frontLeftMotor.setPower(.8);
//            backRightMotor.setPower(.8);
//            backLeftMotor.setPower(.8);
//        }
        frontRightMotor.setPower(.6);
        frontLeftMotor.setPower(.6);
        backRightMotor.setPower(.6);
        backLeftMotor.setPower(.6);
        sleep(500);
        frontRightMotor.setPower(0);
        frontLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        backLeftMotor.setPower(0);

//        timers.reset();

    }

}
