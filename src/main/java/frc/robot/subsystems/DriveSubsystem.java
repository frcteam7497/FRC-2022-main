package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.PortID;
import frc.robot.Constants.PortReversed;

public class DriveSubsystem extends SubsystemBase
{
    private XboxController my_xbox;

    private final CANSparkMax left_front  = new CANSparkMax(PortID.left_front.value, MotorType.kBrushless);
    private final CANSparkMax left_back   = new CANSparkMax(PortID.left_back.value, MotorType.kBrushless);
    private final CANSparkMax right_front = new CANSparkMax(PortID.right_front.value, MotorType.kBrushless);
    private final CANSparkMax right_back  = new CANSparkMax(PortID.right_back.value, MotorType.kBrushless);

    private DifferentialDrive my_chassis  = new DifferentialDrive(left_front, right_front);

    public DriveSubsystem(XboxController my_xbox)
    {
        this.my_xbox = my_xbox;

        MotorInit();
    }

    @Override
    public void periodic() 
    {
        // This method will be called once per scheduler run
        double speed = my_xbox.getRawAxis(1) * 0.8f * 0.75f;
        double turn  = my_xbox.getRawAxis(4) * 0.38f;
        
        double right_speed = speed + turn;
        double left_speed  = speed - turn;
    
        my_chassis.tankDrive(left_speed, right_speed);
    }

    private void MotorInit()
    {
        left_front.restoreFactoryDefaults();
        left_back.restoreFactoryDefaults();
        right_front.restoreFactoryDefaults();
        right_back.restoreFactoryDefaults();

        left_front.setOpenLoopRampRate(Constants.kMotorRampRate);
        left_back.setOpenLoopRampRate(Constants.kMotorRampRate);
        right_front.setOpenLoopRampRate(Constants.kMotorRampRate);
        right_back.setOpenLoopRampRate(Constants.kMotorRampRate);

        left_back.follow(left_front);
        right_back.follow(right_front);

        left_front.setInverted(PortReversed.left_front_reversed.value);
        left_back.setInverted(PortReversed.left_back_reversed.value);
        right_front.setInverted(PortReversed.right_front_reversed.value);
        right_back.setInverted(PortReversed.right_back_reversed.value);

        left_front.setIdleMode(IdleMode.kCoast);
        left_back.setIdleMode(IdleMode.kCoast);
        right_front.setIdleMode(IdleMode.kCoast);
        right_back.setIdleMode(IdleMode.kCoast);
    }
}
