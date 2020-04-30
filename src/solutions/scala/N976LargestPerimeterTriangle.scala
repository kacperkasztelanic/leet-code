package solutions.scala

import scala.annotation.tailrec

object N976LargestPerimeterTriangle {

  def largestPerimeter(arr: Array[Int]): Int =
    arr.sorted(Ordering.Int.reverse)
      .sliding(3, 1)
      .find(a => a(0) < a(1) + a(2))
      .map(_.sum)
      .getOrElse(0)

  def largestPerimeter2(arr: Array[Int]): Int = {
    @tailrec
    def largestPerimeter2(arr: Array[Int], i: Int): Int =
      if (i < 2) 0
      else if (arr(i) < arr(i - 1) + arr(i - 2)) arr(i) + arr(i - 1) + arr(i - 2)
      else largestPerimeter2(arr, i - 1)

    largestPerimeter2(arr.sorted, arr.length - 1)
  }

  def main(args: Array[String]): Unit = {
    assert(largestPerimeter2(Array(2, 1, 2)) == 5)
    assert(largestPerimeter2(Array(1, 2, 1)) == 0)
    assert(largestPerimeter2(Array(3, 2, 3, 4)) == 10)
    assert(largestPerimeter2(Array(3, 6, 2, 3)) == 8)
  }
}
