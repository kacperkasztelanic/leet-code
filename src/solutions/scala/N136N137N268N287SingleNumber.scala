package solutions.scala

import scala.annotation.tailrec

object N136N137N268N287SingleNumber {

  def singleNumber(nums: Array[Int]): Int = nums.fold(0)(_ ^ _)

  def singleNumberII(nums: Array[Int]): Int = {
    val longs = nums.map(_.toLong)
    ((longs.toSet.sum * 3 - longs.sum) / 2).toInt
  }

  def singleNumberII2(nums: Array[Int]): Int = {
    nums.groupBy(identity).mapValues(_.length).find(_._2 == 1).map(_._1).get
  }

  def missingNumber(nums: Array[Int]): Int = nums.zipWithIndex.map(p => p._1 ^ p._2).fold(nums.length)(_ ^ _)

  def findDuplicate(nums: Array[Int]): Int = {
    @tailrec
    def findDuplicate(i: Int, set: Set[Int]): Int =
      if (set(nums(i))) nums(i)
      else findDuplicate(i + 1, set + nums(i))

    findDuplicate(0, Set.empty)
  }

  def main(args: Array[String]): Unit = {
    assert(missingNumber(Array(3, 0, 1)) == 2)
    assert(missingNumber(Array(9, 6, 4, 2, 3, 5, 7, 0, 1)) == 8)
    assert(singleNumberII2(Array(2, 2, 3, 2)) == 3)
    assert(singleNumberII2(Array(0, 1, 0, 1, 0, 1, 99)) == 99)
    assert(findDuplicate(Array(1, 3, 4, 2, 2)) == 2)
    assert(findDuplicate(Array(3, 1, 3, 4, 2)) == 3)
  }
}
