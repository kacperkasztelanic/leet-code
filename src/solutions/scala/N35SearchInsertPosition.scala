package solutions.scala

import scala.annotation.tailrec

object N35SearchInsertPosition {

  def searchInsert(nums: Array[Int], target: Int): Int =
    nums.zipWithIndex
      .find(p => p._1 >= target)
      .map(_._2)
      .getOrElse(nums.length)

  def searchInsert2(nums: Array[Int], target: Int): Int = {
    @tailrec
    def searchInsert2(i: Int): Int =
      if (i >= nums.length) nums.length
      else if (nums(i) >= target) i
      else searchInsert2(i + 1)

    searchInsert2(0)
  }

  def main(args: Array[String]): Unit = {
    assert(searchInsert2(Array(1, 3, 5, 6), 5) == 2)
    assert(searchInsert2(Array(1, 3, 5, 6), 2) == 1)
    assert(searchInsert2(Array(1, 3, 5, 6), 7) == 4)
    assert(searchInsert2(Array(1, 3, 5, 6), 0) == 0)
  }
}
