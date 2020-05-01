package solutions.scala

import scala.annotation.tailrec

object N125N680ValidPalindrome {

  def isPalindrome(s: String): Boolean = {
    @tailrec
    def isPalindrome(i: Int, j: Int): Boolean =
      if (i >= j) true
      else
        (s.charAt(i).isLetterOrDigit, s.charAt(j).isLetterOrDigit) match {
          case (false, false) => isPalindrome(i + 1, j - 1)
          case (true, false) => isPalindrome(i, j - 1)
          case (false, true) => isPalindrome(i + 1, j)
          case (true, true) =>
            if (s.charAt(i).toLower == s.charAt(j).toLower) isPalindrome(i + 1, j - 1)
            else false
        }

    isPalindrome(0, s.length - 1)
  }

  def isPalindrome2(s: String): Boolean = {
    val str = s.filter(_.isLetterOrDigit).map(_.toLower)
    str == str.reverse
  }

  def validPalindrome(s: String): Boolean = {
    def checkPalindrome(s: String): Boolean = s.reverse == s

    @tailrec
    def validPalindrome(i: Int): Boolean =
      if (i >= s.length / 2) true
      else {
        val j = s.length - 1 - i
        if (s.charAt(i) != s.charAt(j)) checkPalindrome(s.substring(i + 1, j + 1)) || checkPalindrome(s.substring(i, j))
        else validPalindrome(i + 1)
      }

    validPalindrome(0)
  }

  def validPalindrome2(s: String): Boolean = {
    def checkPalindrome(s: String): Boolean = s.reverse == s

    (0 until s.length / 2)
      .iterator
      .map(i =>
        if (s.charAt(i) != s.charAt(s.length - 1 - i))
          checkPalindrome(s.substring(i + 1, s.length - i))
            || checkPalindrome(s.substring(i, s.length - 1 - i))
        else true
      )
      .takeWhile(identity)
      .size == s.length / 2
  }

  def main(args: Array[String]): Unit = {
    assert(isPalindrome("A man, a plan, a canal: Panama"))
    assert(!isPalindrome("race a car"))
    assert(validPalindrome("aba"))
    assert(validPalindrome("abca"))
    assert(validPalindrome(""))
    assert(validPalindrome("a"))
  }
}
