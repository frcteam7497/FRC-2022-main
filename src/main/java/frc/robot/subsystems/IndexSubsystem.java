package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.Constants.PortID;
import frc.robot.Constants.PortReversed;

public class IndexSubsystem
{
    private VictorSPX index;
    private VictorSPX trigger;

    public IndexSubsystem()
    {
        index = new VictorSPX(PortID.index.value);
        trigger = new VictorSPX(PortID.trigger.value);

        MotorInit();
    }

    private void MotorInit()
    {
        index.configFactoryDefault();
        trigger.configFactoryDefault();

        index.setInverted(PortReversed.index_reversed.value);
        trigger.setInverted(PortReversed.trigger_reversed.value);

        index.setNeutralMode(NeutralMode.Brake);
        trigger.setNeutralMode(NeutralMode.Brake);
    }
    
    public void index(double speed)
    {
        index.set(ControlMode.PercentOutput, speed);
    }
    public void indexStop()
    {
        index(0.0f);
    }
    public void trigger(double speed)
    {
        trigger.set(ControlMode.PercentOutput, speed);
    }
    public void triggerStop()
    {
        trigger(0.0f);
    }
}
