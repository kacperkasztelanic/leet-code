package solutions.scala

case object N387FirstUniqueCharacter {

  def firstUniqChar(s: String): Int = {
    val countByChar = s.groupBy(identity).mapValues(_.length)
    s.zipWithIndex.find(p => countByChar(p._1) == 1).map(_._2).getOrElse(-1)
  }

  def firstUniqChar2(s: String): Int = {
    s.zipWithIndex
      .groupBy(_._1)
      .values
      .map(s => (s.head._2, s.size))
      .filter(p => p._2 == 1)
      .map(_._1)
      .reduceOption(_ min _)
      .getOrElse(-1)
  }

  def main(args: Array[String]): Unit = {
    assert(firstUniqChar("leetcode") == 0)
    assert(firstUniqChar("loveleetcode") == 2)
  }
}
