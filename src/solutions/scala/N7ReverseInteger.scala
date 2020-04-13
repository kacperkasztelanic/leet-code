package solutions.scala

import scala.annotation.tailrec

object N7ReverseInteger {

  def reverse(x: Int): Int = {
    @tailrec
    def reverse(x: Int, rev: Int): Int = (x, rev) match {
      case (0, _) => rev
      case (_, _) if isOverflow(rev, x % 10) => 0
      case _ => reverse(x / 10, rev * 10 + x % 10)
    }

    def isOverflow(rev: Int, pop: Int): Boolean = (rev, pop) match {
      case (_, _) if rev > Int.MaxValue / 10 => true
      case (_, _) if rev == Int.MaxValue / 10 && pop % 10 > 7 => true
      case (_, _) if rev < Int.MinValue / 10 => true
      case (_, _) if rev == Int.MinValue / 10 && pop % 10 < -8 => true
      case _ => false
    }

    reverse(x, 0)
  }

  def reverse2(x: Int): Int = {
    @tailrec
    def reverse(x: Int, rev: Int): Int = {
      if (x == 0) rev
      else if (isOverflow(rev, x % 10)) 0
      else reverse(x / 10, rev * 10 + x % 10)
    }

    def isOverflow(rev: Int, pop: Int): Boolean = {
      if (rev > Int.MaxValue / 10 || rev == Int.MaxValue / 10 && pop > 7) true
      else rev < Int.MinValue / 10 || rev == Int.MinValue / 10 && pop < -8
    }

    reverse(x, 0)
  }
}
