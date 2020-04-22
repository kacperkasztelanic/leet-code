package solutions.scala

import scala.annotation.tailrec

object N896MonotonicArray {

  def isMonotonic(arr: Array[Int]): Boolean = {
    @tailrec
    def isMonotonic(i: Int, in: Boolean, de: Boolean): Boolean =
      if (i >= arr.length - 1) in || de
      else isMonotonic(i + 1, if (arr(i + 1) < arr(i)) false else in, if (arr(i + 1) > arr(i)) false else de)

    isMonotonic(0, in = true, de = true)
  }

  def isMonotonic2(arr: Array[Int]): Boolean = {
    @tailrec
    def isMonotonic2(i: Int, acc: Int): Boolean =
      if (i >= arr.length - 1) true
      else {
        val c = arr(i + 1).compareTo(arr(i))
        if (c != 0) {
          if (acc != 0 && c != acc) false
          else isMonotonic2(i + 1, c)
        }
        else isMonotonic2(i + 1, acc)
      }

    isMonotonic2(0, 0)
  }

  def main(args: Array[String]): Unit = {
    assert(isMonotonic(Array(1, 2, 2, 3)))
    assert(isMonotonic(Array(6, 5, 4, 4)))
    assert(!isMonotonic(Array(1, 3, 2)))
    assert(isMonotonic(Array(1, 2, 4, 5)))
    assert(isMonotonic(Array(1, 1, 1)))
  }
}
