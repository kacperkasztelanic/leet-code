package solutions.scala

import scala.annotation.tailrec

object N1342ReduceNumberToZero {

  def numberOfSteps(num: Int): Int = {
    @tailrec
    def numberOfSteps(num: Int, acc: Int): Int =
      if (num == 0) acc
      else if (num % 2 == 1) numberOfSteps(num - 1, acc + 1)
      else numberOfSteps(num / 2, acc + 1)

    numberOfSteps(num, 0)
  }

  def main(args: Array[String]): Unit = {
    assert(numberOfSteps(14) == 6)
    assert(numberOfSteps(8) == 4)
    assert(numberOfSteps(123) == 12)
  }
}
