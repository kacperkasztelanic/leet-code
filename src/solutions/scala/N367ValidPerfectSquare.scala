package solutions.scala

import scala.annotation.tailrec

object N367ValidPerfectSquare {

  def isPerfectSquare(num: Int): Boolean = {
    @tailrec
    def isPerfectSquare(low: Int, high: Int, ans: Int): Boolean =
      if (ans * ans == num || low > high) ans * ans == num
      else {
        val mid = low + (high - low) / 2
        if (mid >= num / mid) isPerfectSquare(low, mid - 1, mid)
        else isPerfectSquare(mid + 1, high, mid)
      }

    isPerfectSquare(1, num / 2, 1)
  }

  def main(args: Array[String]): Unit = {
    assert(isPerfectSquare(1))
    assert(isPerfectSquare(4))
    assert(!isPerfectSquare(14))
    assert(isPerfectSquare(16))
    assert(!isPerfectSquare(2147483647))
  }
}
