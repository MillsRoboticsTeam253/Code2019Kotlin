package frc.robot

import edu.wpi.first.wpilibj.command.Command

class Drive : Command() {

    var left = 0.0
    var right = 0.0

    init {
        requires(Robot.drivetrain)
    }

    override fun execute(){
        val throttle = OI.getThrottle()
        val turn = OI.getTurn()

        if(throttle != 0.0) {
            left = throttle + throttle * turn
            right = throttle - throttle * turn
        } else {
            left = turn
            right = -turn
        }

        Robot.drivetrain.set(left, right)
    }

    override fun end() = Robot.drivetrain.set(0.0, 0.0)
    override fun isFinished() = false
    override fun isInterruptible() = true
}