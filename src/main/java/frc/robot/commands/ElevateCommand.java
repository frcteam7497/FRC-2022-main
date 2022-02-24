// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ElevateSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ElevateCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private ElevateSubsystem my_elevate;
  private Timer            timer;
  private boolean          finished;

  /**
   * Creates a new ElevateCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ElevateCommand(ElevateSubsystem my_elevate) {
    this.my_elevate = my_elevate;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(my_elevate);
    timer           = new Timer();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
    finished = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // if(timer.get() <= 2.0f)
    // {
    //   my_elevate.Climb(0.1f);
    //   my_elevate.Rotate(0.1f);
    // }
    // else if(timer.get() <= 4.0f)
    // {
    //   my_elevate.Climb(-0.1f);
    //   my_elevate.Rotate(-0.1f);
    // }
    // else if(timer.get() <= 6.0f)
    // {
    //   my_elevate.Climb(0.1f);
    //   my_elevate.Rotate(0.1f);
    // }
    // else if(timer.get() <= 8.0f)
    // {
    //   my_elevate.Climb(-0.1f);
    //   my_elevate.Rotate(-0.1f);
    // }
    // else if(timer.get() <= 10.0f)
    // {
    //   my_elevate.Climb(0.1f);
    //   my_elevate.Rotate(0.1f);
    // }
    // else if(timer.get() <= 12.0f)
    // {
    //   my_elevate.Climb(-0.1f);
    //   my_elevate.Rotate(-0.1f);
    // }
    // else
    // {
    //   finished = true;
    // }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // my_elevate.ClimbStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
