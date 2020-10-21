package solutions.scala

import scala.annotation.tailrec

object N1470ShuffleTheArray {

  def shuffle(nums: Array[Int], n: Int): Array[Int] = {
    val (x, y) = nums.splitAt(n)
    x.zip(y).flatMap(p => List(p._1, p._2))
  }

  def shuffle2(nums: Array[Int], n: Int): Array[Int] = {
    @tailrec
    def internal(i: Int, acc: List[Int]): List[Int] = {
      if (i == n) acc
      else internal(i + 1, acc ++ List(nums(i), nums(n + i)))
    }

    internal(0, Nil).toArray
  }
}
