// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class RobotContainer {
  private static final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  private static final ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    m_intakeSubsystem.setDefaultCommand(m_intakeSubsystem.runIntakeCommand());
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
