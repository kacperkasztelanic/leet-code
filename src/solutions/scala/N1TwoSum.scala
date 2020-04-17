package solutions.scala

import scala.annotation.tailrec

object N1TwoSum {

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    @tailrec
    def twoSum(list: List[Int], map: Map[Int, Int]): Array[Int] = list match {
      case Nil => Array.emptyIntArray
      case h :: t =>
        val c = target - h
        val i = nums.length - (t.length + 1)
        if (map.contains(c)) Array(map(c), i)
        else twoSum(t, map + (h -> i))
    }

    twoSum(nums.toList, Map.empty)
  }

  def twoSum2(nums: Array[Int], target: Int): Array[Int] = {
    val indexByValue = nums.zipWithIndex.toMap
    nums.map(v => target - v)
      .zipWithIndex
      .find(e => indexByValue.contains(e._1) && indexByValue(e._1) != e._2)
      .map(e => Array(e._2, indexByValue(e._1)))
      .get
  }

  def twoSum3(nums: Array[Int], target: Int): Array[Int] = {
    for {
      x <- nums.zipWithIndex
      y <- nums.zipWithIndex
      if x._2 != y._2
      if x._1 + y._1 == target
    } yield Array(x._2, y._2).head
  }

  def main(args: Array[String]): Unit = {
    assert(twoSum(Array(2, 7, 11, 15), 9).sameElements(Array(0, 1)))
  }
}
