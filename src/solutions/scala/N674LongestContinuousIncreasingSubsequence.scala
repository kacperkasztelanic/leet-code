package solutions.scala

import scala.annotation.tailrec

object N674LongestContinuousIncreasingSubsequence {

  def findLengthOfLCIS(nums: Array[Int]): Int = {
    if (nums.isEmpty) 0
    else (1 until nums.length).scan(1)((max, index) => if (nums(index) > nums(index - 1)) max + 1 else 1).max
  }

  def findLengthOfLCIS2(nums: Array[Int]): Int = {
    @tailrec
    def findLengthOflCIS2(i: Int, curr: Int, max: Int): Int = {
      if (i >= nums.length) max
      else {
        if (nums(i) > nums(i - 1)) findLengthOflCIS2(i + 1, curr + 1, Math.max(curr + 1, max))
        else findLengthOflCIS2(i + 1, 1, max)
      }
    }

    if (nums.isEmpty) 0
    else findLengthOflCIS2(1, 1, 1)
  }

  def main(args: Array[String]): Unit = {
    assert(findLengthOfLCIS2(Array(1, 3, 5, 4, 7)) == 3)
    assert(findLengthOfLCIS2(Array(2, 2, 2, 2, 2)) == 1)
    assert(findLengthOfLCIS2(Array()) == 0)
  }
}
