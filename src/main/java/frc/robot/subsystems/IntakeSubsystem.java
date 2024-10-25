package frc.robot.subsystems;

import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import static frc.robot.Constants.Intake.*;

public class IntakeSubsystem extends SubsystemBase {
    private final CANSparkMax m_intakeMotor = new CANSparkMax(kIntakeMotorId, MotorType.kBrushless);
    private final CANSparkMax m_upwardMotor = new CANSparkMax(kUpwardMotorId, MotorType.kBrushless);
    private final CANSparkMax m_chamberFlywheelMotor = new CANSparkMax(kChamberFlywheelMotorId, MotorType.kBrushless);

    boolean enabled = false;

    public IntakeSubsystem() {

    }

    public Command runIntakeCommand() {
        return this.run(
            () -> {
                System.out.println(enabled);
                if (this.enabled) this.on(); 
                else this.off();
            }
        );
    }

    void on() {
        m_intakeMotor.set(kIntakeSpeed);
        m_upwardMotor.set(kUpwardSpeed);
        m_chamberFlywheelMotor.set(kChamberFlywheelSpeed);
    }

    void off() {
        m_intakeMotor.set(0);
        m_upwardMotor.set(0);
        m_chamberFlywheelMotor.set(0);
    }

    @Override
    public void initSendable(SendableBuilder sb) {
        super.initSendable(sb);
        sb.setSmartDashboardType("IntakeSubsystem");
        sb.addBooleanProperty("enabled", () -> enabled, (e) -> this.enabled = e);
    }

    @Override 
    public void periodic() {
        SmartDashboard.putData(this);
    }
}
