// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.DriveTrain;

public class ArcadeDrive extends Command {
  /** Creates a new ArcadeDrive. */
  DriveTrain driveTrain;
  CommandXboxController controller;

  public ArcadeDrive(DriveTrain driveTrain, CommandXboxController controller) {
    this.driveTrain = driveTrain;
    this.controller = controller;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.arcadeDrive(
        0.7 * MathUtil.applyDeadband(controller.getLeftY(), 0.05),
        0.7 * MathUtil.applyDeadband(-1 * controller.getRightX(), 0.05));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
