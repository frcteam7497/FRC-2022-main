package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.Constants.PortID;
import frc.robot.Constants.PortReversed;

public class IntakeSubsystem
{
  private VictorSPX intake;
    
  public IntakeSubsystem()
  {
    intake = new VictorSPX(PortID.intake.value);
    MotorInit();
  }

  private void MotorInit()
  {
    intake.configFactoryDefault();
    intake.setInverted(PortReversed.intake_reversed.value);
    intake.setNeutralMode(NeutralMode.Brake);
  }

  public void intake(double speed)
  {
    intake.set(ControlMode.PercentOutput, speed);
  }

  public void intakeStop()
  {
    intake(0.0f);
  }
}
