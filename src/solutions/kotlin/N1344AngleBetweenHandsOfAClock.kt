package solutions.kotlin

import kotlin.math.abs
import kotlin.math.min

class N1344AngleBetweenHandsOfAClock {

    companion object{

        private const val FULL_CIRCLE: Int = 360
        private const val HOURS_ON_CIRCLE: Int = 12
        private const val MINUTES_IN_HOUR: Int = 60
        private const val HOUR_ANGLE_IN_HOUR: Int = 360 / 12
        private const val MINUTE_ANGLE_IN_MINUTE: Int = 360 / 60
        private const val HOUR_ANGLE_IN_MINUTE: Double = HOUR_ANGLE_IN_HOUR.toDouble() / MINUTES_IN_HOUR

        @JvmStatic
        fun main(args: Array<String>) {
            val app = N1344AngleBetweenHandsOfAClock()
            assert(app.angleClock(12, 30).compareTo(165) == 0)
            assert(app.angleClock(3, 30).compareTo(75) == 0)
            assert(app.angleClock(3, 15).compareTo(7.5) == 0)
            assert(app.angleClock(4, 50).compareTo(155) == 0)
            assert(app.angleClock(12, 0).compareTo(0) == 0)
        }
    }

    fun angleClock(hour: Int, minutes: Int): Double {
        val h = (hour % HOURS_ON_CIRCLE * HOUR_ANGLE_IN_HOUR) + (minutes * HOUR_ANGLE_IN_MINUTE)
        val m = minutes * MINUTE_ANGLE_IN_MINUTE
        val angle = abs(m - h)
        return min(FULL_CIRCLE - angle, angle)
    }
}