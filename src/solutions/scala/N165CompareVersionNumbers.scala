package solutions.scala

object N165CompareVersionNumbers {

  def compareVersion(version1: String, version2: String): Int = {
    def parse(s: String): Array[Int] = s.split("\\.").map(_.toInt)

    parse(version1)
      .zipAll(parse(version2), 0, 0)
      .find(p => p._1 != p._2)
      .map(p => p._1 compareTo p._2)
      .getOrElse(0)
  }

  def main(args: Array[String]): Unit = {
    assert(compareVersion("0.1", "1.1") == -1)
    assert(compareVersion("1.0.1", "1") == 1)
    assert(compareVersion("7.5.2.4", "7.5.3") == -1)
    assert(compareVersion("1.01", "1.001") == 0)
    assert(compareVersion("1.0", "1.0.0") == 0)
  }
}
