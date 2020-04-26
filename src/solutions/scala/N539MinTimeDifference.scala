package solutions.scala

object N539MinTimeDifference {

  def findMinDifference(timePoints: List[String]): Int = {
    def mins(timePoint: String): Int = {
      val split = timePoint.split(":").map(_.toInt)
      split(0) * 60 + split(1)
    }

    val converted = timePoints.map(mins).sorted
    (converted :+ converted.head + mins("24:00"))
      .sliding(2)
      .map(l => l.tail.head - l.head)
      .min
  }

  def main(args: Array[String]): Unit = {
    assert(findMinDifference(List("23:59", "00:00")) == 1)
    assert(findMinDifference(List("00:00", "23:59", "00:00")) == 0)
    assert(findMinDifference(List("01:01", "02:01")) == 60)
    assert(findMinDifference(List("05:31", "22:08", "00:35")) == 147)
  }
}
