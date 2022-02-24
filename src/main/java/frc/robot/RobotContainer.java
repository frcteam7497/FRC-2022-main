// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ElevateCommand;
import frc.robot.subsystems.ElevateSubsystem;
import frc.robot.subsystems.IndexSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer
{
  // The robot's subsystems and commands are defined here...
  private final XboxController xbox_main  = new XboxController(0);
  private final XboxController xbox_vice  = new XboxController(1);

  private final ElevateSubsystem m_ElevateSubsystem = new ElevateSubsystem();
  private final IndexSubsystem   m_IndexSubsystem   = new IndexSubsystem();
  private final IntakeSubsystem  m_IntakeSubsystem  = new IntakeSubsystem();

  private final ElevateCommand m_autoCommand = new ElevateCommand(m_ElevateSubsystem);

  private static Timer  timer = new Timer(); 

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer()
  {
    timer.start();
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings()
  {
    /*
      Drive
    */

    // index
    new JoystickButton(xbox_main, XboxController.Button.kA.value).whenPressed(() -> m_IndexSubsystem.index(0.5));
    new JoystickButton(xbox_main, XboxController.Button.kA.value).whenReleased(() -> m_IndexSubsystem.indexStop());
    new JoystickButton(xbox_main, XboxController.Button.kB.value).whenPressed(() -> m_IndexSubsystem.trigger(0.5));
    new JoystickButton(xbox_main, XboxController.Button.kB.value).whenReleased(() -> m_IndexSubsystem.triggerStop());

    // intake
    new JoystickButton(xbox_main, XboxController.Button.kX.value).whenPressed(() -> m_IntakeSubsystem.intake(0.5));
    new JoystickButton(xbox_main, XboxController.Button.kX.value).whenReleased(() -> m_IntakeSubsystem.intakeStop());
    new JoystickButton(xbox_main, XboxController.Button.kY.value).whenPressed(() -> m_IntakeSubsystem.intake(-0.5));
    new JoystickButton(xbox_main, XboxController.Button.kY.value).whenReleased(() -> m_IntakeSubsystem.intakeStop());

    /*
      Co-pilot
    */

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ElevateCommand will run in autonomous
    return m_autoCommand;
  }
}
