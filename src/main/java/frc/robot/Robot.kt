package frc.robot

import edu.wpi.first.wpilibj.RobotBase
import edu.wpi.first.wpilibj.TimedRobot

object Robot : TimedRobot(){
    override fun robotInit() {
        super.robotInit()
    }

    override fun robotPeriodic() {
        super.robotPeriodic()
    }

    override fun autonomousInit() {
        super.autonomousInit()
    }

    override fun autonomousPeriodic() {
        super.autonomousPeriodic()
    }

    override fun teleopInit() {
        super.teleopInit()
    }

    override fun teleopPeriodic() {
        super.teleopPeriodic()
    }

    override fun disabledInit() {
        super.disabledInit()
    }

    override fun disabledPeriodic() {
        super.disabledPeriodic()
    }

}

fun main() {
    RobotBase.startRobot { Robot }
}