package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.Constants.PortID;

public class PneumaticSubsystem
{
    private Compressor Compressor;
    private Solenoid Solenoid;
    private boolean status;

    public PneumaticSubsystem()
    {
        Compressor = new Compressor(PneumaticsModuleType.CTREPCM);
        Solenoid = new Solenoid(PneumaticsModuleType.CTREPCM,PortID.solenoid.value);
        status = false;

        Compressor.enableDigital();
    }

    public void periodic()
    {
        // This method will be called once per scheduler run
        Solenoid.set(status);
    }
}
