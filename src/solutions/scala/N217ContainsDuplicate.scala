package solutions.scala

import scala.annotation.tailrec

object N217ContainsDuplicate {

  def containsDuplicate(nums: Array[Int]): Boolean = {
    @tailrec
    def containsDuplicate(nums: List[Int], seen: Set[Int]): Boolean = nums match {
      case h :: t =>
        if (seen(h)) true
        else containsDuplicate(t, seen + h)
      case Nil => false
    }

    containsDuplicate(nums.toList, Set.empty)
  }

  def containsDuplicate2(nums: Array[Int]): Boolean = nums.distinct.length != nums.length

  def main(args: Array[String]): Unit = {
    assert(containsDuplicate(Array(1, 2, 3, 1)))
    assert(!containsDuplicate(Array(1, 2, 3, 4)))
    assert(containsDuplicate(Array(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))
  }
}
