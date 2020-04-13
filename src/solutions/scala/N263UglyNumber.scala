package solutions.scala

import scala.annotation.tailrec

object N263UglyNumber {

  def isUgly(n: Int): Boolean =
    n > 0 && (n == 1 || List(2, 3, 5).exists(x => n % x == 0 && isUgly(n / x)))

  @tailrec
  def isUgly2(n: Int): Boolean = {
    if (n <= 0) false
    else if (n == 1) true
    else if (n % 2 == 0) isUgly2(n / 2)
    else if (n % 3 == 0) isUgly2(n / 3)
    else if (n % 5 == 0) isUgly2(n / 5)
    else false
  }
}
