package solutions.scala

import scala.annotation.tailrec

object N219ContainsDuplicateII {

  def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = {
    @tailrec
    def containsNearbyDuplicate(i: Int, seen: Set[Int]): Boolean = {
      if (i >= nums.length) false
      else if (seen(nums(i))) true
      else {
        if (seen.size < k) containsNearbyDuplicate(i + 1, seen + nums(i))
        else containsNearbyDuplicate(i + 1, seen + nums(i) - nums(i - k))
      }
    }

    containsNearbyDuplicate(0, Set.empty)
  }

  def containsNearbyDuplicate2(nums: Array[Int], k: Int): Boolean = {
    def existWithinConstraint(indices: Array[Int]): Boolean = {
      indices
        .sliding(2)
        .exists {
          case Array(x, y) => y - x <= k
          case _ => false
        }
    }

    nums
      .zipWithIndex
      .groupBy(_._1)
      .values
      .exists(v => existWithinConstraint(v.map(_._2)))
  }

  def main(args: Array[String]): Unit = {
    assert(containsNearbyDuplicate2(Array(1, 2, 3, 1), 3))
    assert(containsNearbyDuplicate2(Array(1, 0, 1, 1), 1))
    assert(!containsNearbyDuplicate2(Array(1, 2, 3, 1, 2, 3), 2))
  }
}
