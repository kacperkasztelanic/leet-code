package solutions.scala

import scala.annotation.tailrec

object N633SumOfSquareNumbers {

  def judgeSquareSum(c: Int): Boolean = {
    @tailrec
    def judgeSquareSum(left: Int, right: Int): Boolean =
      if (left > right) false
      else {
        val sum = left * left + right * right
        if (sum > c) judgeSquareSum(left, right - 1)
        else if (sum < c) judgeSquareSum(left + 1, right)
        else true
      }

    judgeSquareSum(0, Math.sqrt(c).intValue() + 1)
  }

  def judgeSquareSum2(c: Int): Boolean = {
    @tailrec
    def isPerfectSquare(low: Int, high: Int, n: Int): Boolean =
      if (low > high) false
      else {
        val mid = low + (high - low) / 2
        if (mid * mid == n) true
        else if (mid >= n / mid) isPerfectSquare(low, mid - 1, n)
        else isPerfectSquare(mid + 1, high, n)
      }

    def isPerfectSquare2(n: Int): Boolean = isPerfectSquare(1, n, n)

    c == 0 || Iterator.iterate(0)(_ + 1).takeWhile(a => a * a <= c).exists(a => isPerfectSquare2(c - a * a))
  }

  def main(args: Array[String]): Unit = {
    assert(!judgeSquareSum(2147483646))
    assert(!judgeSquareSum(999999999))
    assert(judgeSquareSum(0))
    assert(judgeSquareSum(2))
    assert(judgeSquareSum(5))
    assert(judgeSquareSum(4))
    assert(!judgeSquareSum(7))
    assert(!judgeSquareSum(3))
  }
}
