package solutions.scala

import scala.annotation.tailrec

object N11ContainerWithMostWater {

  def maxArea(height: Array[Int]): Int = {
    def area(i: Int, j: Int): Int = Math.min(height(i), height(j)) * (j - i)

    @tailrec
    def maxArea(i: Int, j: Int, max: Int): Int = {
      val newMax = Math.max(max, area(i, j))
      if (i >= j) newMax
      else if (height(i) >= height(j)) maxArea(i, j - 1, newMax)
      else maxArea(i + 1, j, newMax)
    }

    maxArea(0, height.length - 1, 0)
  }

  def maxArea2(height: Array[Int]): Int = {
    def area(i: Int, j: Int): Int = Math.min(height(i), height(j)) * (j - i)

    (for {
      x <- height.zipWithIndex
      y <- height.zipWithIndex
      if x._2 < y._2
    } yield area(x._2, y._2)).max
  }

  def main(args: Array[String]): Unit = {
    assert(maxArea(Array(1, 8, 6, 2, 5, 4, 8, 3, 7)) == 49)
    assert(maxArea2(Array(1, 8, 6, 2, 5, 4, 8, 3, 7)) == 49)
  }
}
