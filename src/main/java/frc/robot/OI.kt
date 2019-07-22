package frc.robot

import com.kauailabs.navx.frc.AHRS
import edu.wpi.first.wpilibj.GenericHID
import edu.wpi.first.wpilibj.SPI
import edu.wpi.first.wpilibj.XboxController

object OI {
    private val xboxcontroller = XboxController(0)

    fun getThrottle() = deadbandX(xboxcontroller.getY(GenericHID.Hand.kLeft), Constants.kJoystickDeadband)
    fun getTurn() = deadbandX(xboxcontroller.getX(GenericHID.Hand.kRight), Constants.kJoystickDeadband)

    private fun deadbandX(input : Double, deadband : Double): Double {
        return when {
            kotlin.math.abs(input)<=deadband -> 0.0
            kotlin.math.abs(input) == 1.0 -> input
            else -> 1 / (1 - deadband) * (input + kotlin.math.sign(-input) * deadband)
        }
    }
}