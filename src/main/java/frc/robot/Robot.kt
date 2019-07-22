package frc.robot

import edu.wpi.first.wpilibj.RobotBase
import edu.wpi.first.wpilibj.TimedRobot
import edu.wpi.first.wpilibj.command.Scheduler

object Robot : TimedRobot(){
    val drivetrain = Drivetrain()

    override fun robotInit() {
        
    }

    override fun robotPeriodic() {

    }

    override fun autonomousInit() {
        
    }

    override fun autonomousPeriodic() {
        Scheduler.getInstance().run()
    }

    override fun teleopInit() {
        
    }

    override fun teleopPeriodic() {
        Scheduler.getInstance().run()
    }

    override fun disabledInit() {
        
    }

    override fun disabledPeriodic() {
        
    }

}

fun main() {
    RobotBase.startRobot { Robot }
}