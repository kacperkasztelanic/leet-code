package solutions.scala

object N1528ShuffleString {

  def restoreString(s: String, indices: Array[Int]): String =
    s.toCharArray
      .zip(indices)
      .sortBy(_._2)
      .map(_._1)
      .mkString

  def main(args: Array[String]): Unit = {
    assert(restoreString("codeleet", Array(4, 5, 6, 7, 0, 2, 1, 3)) == "leetcode")
    assert(restoreString("abc", Array(0, 1, 2)) == "abc")
    assert(restoreString("aiohn", Array(3, 1, 4, 2, 0)) == "nihao")
    assert(restoreString("aaiougrt", Array(4, 0, 2, 6, 7, 3, 1, 5)) == "arigatou")
    assert(restoreString("art", Array(1, 0, 2)) == "rat")
  }
}
