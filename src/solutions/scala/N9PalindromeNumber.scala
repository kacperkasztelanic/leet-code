package solutions.scala

import scala.annotation.tailrec

object N9PalindromeNumber {

  def isPalindrome(x: Int): Boolean = {
    @tailrec
    def isPalindrome(x: Int, rev: Int): Boolean = (x, rev) match {
      case _ if x > rev => isPalindrome(x / 10, rev * 10 + x % 10)
      case _ => x == rev || x == rev / 10
    }

    !(x < 0 || (x % 10 == 0 && x != 0)) && isPalindrome(x, 0)
  }

  def isPalindrome2(x: Int): Boolean = {
    if (x < 0 || x % 10 == 0 && x != 0) {
      return false
    }
    var copy = x
    var reverted = 0
    while (copy > reverted) {
      reverted = reverted * 10 + copy % 10
      copy = copy / 10
    }
    copy == reverted || copy == reverted / 10
  }

  def isPalindrome3(x: Int): Boolean = {
    x.toString.reverse.filter(Character.isDigit).toLong == x
  }
}
