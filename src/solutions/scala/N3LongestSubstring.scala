package solutions.scala

import scala.annotation.tailrec

object N3LongestSubstring {

  def lengthOfLongestSubstring(s: String): Int = {
    @tailrec
    def lengthOfLongestSubstring(set: Set[Char], max: Int, i: Int, j: Int): Int =
      if (i < s.length && j < s.length) {
        if (!set.contains(s.charAt(j))) lengthOfLongestSubstring(set + s.charAt(j), Math.max(max, j + 1 - i), i, j + 1)
        else lengthOfLongestSubstring(set - s.charAt(i), max, i + 1, j)
      }
      else max

    lengthOfLongestSubstring(Set.empty, 0, 0, 0)
  }

  def lengthOfLongestSubstring2(s: String): Int = {
    @tailrec
    def lengthOfLongestSubstring(list: List[Char], current: List[Char], max: Int): Int = list match {
      case h :: t =>
        val index = current.indexOf(h)
        if (index == -1) lengthOfLongestSubstring(t, current :+ h, max)
        else lengthOfLongestSubstring(t, current.slice(index + 1, current.size) :+ h, Math.max(current.size, max))
      case Nil => Math.max(max, current.size)
    }

    lengthOfLongestSubstring(s.toList, List.empty, 0)
  }


  def main(args: Array[String]): Unit = {
    assert(lengthOfLongestSubstring("abcabcbb") == 3)
    assert(lengthOfLongestSubstring("bbbbb") == 1)
    assert(lengthOfLongestSubstring("pwwkew") == 3)
  }
}
