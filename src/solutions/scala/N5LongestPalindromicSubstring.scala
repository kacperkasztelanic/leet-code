package solutions.scala

import scala.annotation.tailrec

object N5LongestPalindromicSubstring {

  def longestPalindrome(s: String): String = {
    @tailrec
    def expandAroundCenter(left: Int, right: Int): Int = {
      if (left < 0 || right >= s.length || s.charAt(left) != s.charAt(right)) right - left - 1
      else expandAroundCenter(left - 1, right + 1)
    }

    @tailrec
    def longestPalindrome(i: Int, start: Int, end: Int): String =
      if (i >= s.length) s.substring(start, end + 1)
      else {
        val len = Math.max(expandAroundCenter(i, i), expandAroundCenter(i, i + 1))
        if (len > end - start) longestPalindrome(i + 1, i - (len - 1) / 2, i + len / 2)
        else longestPalindrome(i + 1, start, end)

      }

    Option(s)
      .filter(!_.isEmpty)
      .map(_ => longestPalindrome(0, 0, 0))
      .getOrElse("")
  }

  def main(args: Array[String]): Unit = {
    assert(Iterator("bab", "aba").contains(longestPalindrome("babad")))
    assert(longestPalindrome("cbbd") == "bb")
    assert(longestPalindrome("") == "")
  }
}
