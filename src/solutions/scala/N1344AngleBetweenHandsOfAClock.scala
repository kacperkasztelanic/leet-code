package solutions.scala

object N1344AngleBetweenHandsOfAClock {

  private val FULL_CIRCLE: Int = 360
  private val HOURS_ON_CIRCLE: Int = 12
  private val MINUTES_IN_HOUR: Int = 60
  private val HOUR_ANGLE_IN_HOUR: Int = 360 / 12
  private val MINUTE_ANGLE_IN_MINUTE: Int = 360 / 60
  private val HOUR_ANGLE_IN_MINUTE: Double = HOUR_ANGLE_IN_HOUR.toDouble / MINUTES_IN_HOUR

  def angleClock(hour: Int, minutes: Int): Double = {
    val h = (hour % HOURS_ON_CIRCLE * HOUR_ANGLE_IN_HOUR) + (minutes * HOUR_ANGLE_IN_MINUTE)
    val m = minutes * MINUTE_ANGLE_IN_MINUTE
    val angle = Math.abs(m - h)
    Math.min(FULL_CIRCLE - angle, angle)
  }

  def main(args: Array[String]): Unit = {
    assert(angleClock(12, 30) == 165)
    assert(angleClock(3, 30) == 75)
    assert(angleClock(3, 15) == 7.5)
    assert(angleClock(4, 50) == 155)
    assert(angleClock(12, 0) == 0)
  }
}
