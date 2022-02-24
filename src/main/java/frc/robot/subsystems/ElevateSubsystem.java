// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.PortReversed;

public class ElevateSubsystem extends SubsystemBase {
  private TalonFX climb;
  private TalonFX rotate;
  
  /** Creates a new ElevateSubsystem. */
  public ElevateSubsystem() {
    climb = new TalonFX(6);
    rotate = new TalonFX(7);

    MotorInit();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  public void Climb(double speed)
  {
    climb.set(ControlMode.PercentOutput, speed);
  }
  public void Rotate(double speed)
  {
    rotate.set(ControlMode.PercentOutput, speed);
  }

  public void ClimbStop(){
    climb.set(ControlMode.PercentOutput, 0.0f);
  }
  public void RotateStop(){
    rotate.set(ControlMode.PercentOutput, 0.0f);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
  /**
   * Initilize the Shoot motor settings
   */
  private void MotorInit()
  {
    climb.configFactoryDefault();
    climb.configOpenloopRamp(Constants.kMotorRampRate);
    climb.setInverted(PortReversed.climb_reversed.value);
    climb.setNeutralMode(NeutralMode.Brake);

    rotate.configFactoryDefault();
    rotate.configOpenloopRamp(Constants.kMotorRampRate);
    rotate.setInverted(PortReversed.rotate_reversed.value);
    rotate.setNeutralMode(NeutralMode.Brake);
  }
}