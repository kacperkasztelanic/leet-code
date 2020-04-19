package solutions.scala

import scala.annotation.tailrec

object N14LongestCommonPrefix {

  def longestCommonPrefix(strs: Array[String]): String = {
    def longestCommonPrefix(l: Int, r: Int): String = {
      if (l == r) strs(l)
      else {
        val mid = (l + r) / 2
        commonPrefix(longestCommonPrefix(l, mid), longestCommonPrefix(mid + 1, r))
      }
    }

    def commonPrefix(l: String, r: String): String = l.zip(r).takeWhile(e => e._1 == e._2).map(_._1).mkString

    Option(strs).filter(!_.isEmpty).map(a => longestCommonPrefix(0, a.length - 1)).getOrElse("")
  }

  def longestCommonPrefix2(strs: Array[String]): String = {
    def longestCommonPrefix2(l: Int, r: Int): String = {
      if (l == r) strs(l)
      else {
        val mid = (l + r) / 2
        commonPrefix(longestCommonPrefix2(l, mid).toList, longestCommonPrefix2(mid + 1, r).toList, Nil).mkString
      }
    }

    @tailrec
    def commonPrefix(l: List[Char], r: List[Char], acc: List[Char]): List[Char] = (l, r) match {
      case (h1 :: t1, h2 :: t2) =>
        if (h1 == h2) commonPrefix(t1, t2, h1 :: acc)
        else acc.reverse
      case _ => acc.reverse
    }

    Option(strs).filter(!_.isEmpty).map(a => longestCommonPrefix2(0, a.length - 1)).getOrElse("")
  }

  def longestCommonPrefix3(strs: Array[String]): String = {
    val sorted = Option(strs).filter(!_.isEmpty).getOrElse(Array("")).sorted
    sorted.head.zip(sorted.last).takeWhile(e => e._1 == e._2).map(_._1).mkString
  }

  def longestCommonPrefix4(strs: Array[String]): String = {
    @tailrec
    def longestCommonPrefix4(index: Int, acc: String): String = {
      val curr = strs.map(s => if (index < s.length) s(index) else ' ').toSet
      if (curr.size == 1 && curr.head != ' ') longestCommonPrefix4(index + 1, acc + curr.head)
      else acc
    }

    longestCommonPrefix4(0, "")
  }

  def main(args: Array[String]): Unit = {
    assert(longestCommonPrefix(Array("flower", "flow", "flight")) == "fl")
    assert(longestCommonPrefix(Array("dog", "racecar", "car")) == "")
  }
}
