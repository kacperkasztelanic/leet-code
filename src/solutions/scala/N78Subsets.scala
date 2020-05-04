package solutions.scala

import scala.annotation.tailrec
import scala.math.pow

object N78Subsets {

  def subsets(nums: Array[Int]): List[List[Int]] = {
    @tailrec
    def subsets(nums: List[Int], acc: List[List[Int]]): List[List[Int]] = nums match {
      case Nil => acc
      case h :: t => subsets(t, acc ++ acc.map(_ :+ h))
    }

    subsets(nums.toList, List(Nil))
  }

  def subsets2(nums: Array[Int]): List[List[Int]] = {
    val list = nums.toList
    (0 to list.length).flatMap(n => list.combinations(n)).toList
  }

  def subsets3(nums: Array[Int]): List[List[Int]] =
    (pow(2, nums.length).asInstanceOf[Int] until pow(2, nums.length + 1).asInstanceOf[Int])
      .map(_.toBinaryString.substring(1))
      .map(i => nums.indices
        .filter(j => i(j) == '1')
        .map(j => nums(j))
        .toList
      )
      .toList
}
