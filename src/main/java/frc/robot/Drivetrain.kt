package frc.robot

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.FeedbackDevice
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced
import com.ctre.phoenix.motorcontrol.can.TalonSRX
import com.ctre.phoenix.motorcontrol.can.VictorSPX
import edu.wpi.first.wpilibj.command.Subsystem

class Drivetrain : Subsystem() {

    private val leftMotorA = TalonSRX(Constants.leftMotorA)
    private val leftMotorB = TalonSRX(Constants.leftMotorB)
    private val leftMotorC = VictorSPX(Constants.leftMotorC)

    private val rightMotorA = TalonSRX(Constants.rightMotorA)
    private val rightMotorB = TalonSRX(Constants.rightMotorB)
    private val rightMotorC = VictorSPX(Constants.rightMotorC)

    init {

        leftMotorB.follow(leftMotorA)
        leftMotorC.follow(leftMotorA)

        rightMotorB.follow(rightMotorA)
        rightMotorC.follow(rightMotorA)

        arrayOf(leftMotorA, leftMotorB, leftMotorC).forEach { it.inverted = true }
        arrayOf(rightMotorA, rightMotorB, rightMotorC).forEach { it.inverted = false }

        arrayOf(leftMotorA, leftMotorB, leftMotorC, rightMotorA, rightMotorB, rightMotorC).forEach{
            if(it is TalonSRX){
                it.configPeakCurrentLimit(60)
                it.configPeakCurrentDuration(500)
                it.configContinuousCurrentLimit(38)
                it.enableCurrentLimit(true)
            }

            it.configVoltageCompSaturation(12.0)
            it.enableVoltageCompensation(true)

        }

        leftMotorA.setStatusFramePeriod(StatusFrameEnhanced.Status_3_Quadrature, 1)
        leftMotorA.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder)
        leftMotorA.setSensorPhase(false)

        rightMotorA.setStatusFramePeriod(StatusFrameEnhanced.Status_3_Quadrature, 1)
        rightMotorA.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder)
        rightMotorA.setSensorPhase(false)

    }

    fun set(left : Double, right : Double, isVelocity : Boolean = false) {
        if(isVelocity){
            leftMotorA.set(ControlMode.PercentOutput, left)
            rightMotorA.set(ControlMode.PercentOutput, right)
        } else {
            leftMotorA.set(ControlMode.Velocity, left)
            rightMotorA.set(ControlMode.Velocity, right)
        }
    }

    override fun initDefaultCommand() {
        defaultCommand = Drive()
    }

}