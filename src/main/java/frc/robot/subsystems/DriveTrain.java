// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  private WPI_TalonSRX leftLeader;
  private WPI_TalonSRX rightLeader;
  private WPI_TalonSRX leftFollower;
  private WPI_TalonSRX rightFollower; 

  // private Encoder leftEncoder = new Encoder(0, 1, false, EncodingType.k2X);
  // private Encoder rightEncoder;

  private DifferentialDrive driveTrain;

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    this.leftLeader = new WPI_TalonSRX(1);
    this.leftFollower = new WPI_TalonSRX(2);
    this.rightLeader = new WPI_TalonSRX(3);
    this.rightFollower = new WPI_TalonSRX(4);

    leftFollower.follow(leftLeader);
    rightFollower.follow(rightLeader);

    rightLeader.setInverted(true);
    rightFollower.setInverted(true);

    this.driveTrain = new DifferentialDrive(leftLeader, rightLeader);

  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    driveTrain.tankDrive(leftSpeed, rightSpeed);
  }

  public void arcadeDrive(double speed, double rotation) {
    driveTrain.arcadeDrive(speed, rotation);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
