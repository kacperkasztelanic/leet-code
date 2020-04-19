package solutions.scala

object N15ThreeSum {

  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val indexByValue = nums.zipWithIndex.toMap

    def twoSum(nums: Array[Int], target: Int, banned: Int): List[List[Int]] = {
      def isAllowed(e: (Int, Int)): Boolean = {
        val sought = target - e._1
        e._2 != banned && indexByValue.contains(sought) && indexByValue(sought) != banned && indexByValue(sought) != e._2
      }

      nums.zipWithIndex
        .filter(isAllowed)
        .map(e => List(e._1, target - e._1))
        .toList
    }

    nums.zipWithIndex
      .groupBy(_._1)
      .map(_._2.head)
      .flatMap(e => twoSum(nums, 0 - e._1, e._2).map(l => (e._1 :: l).sorted))
      .toList
      .distinct
  }

  def main(args: Array[String]): Unit = {
    assert(threeSum(Array(-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6)).toSet == Set(List(-4, -2, 6), List(-4, 0, 4), List(-4, 1, 3), List(-4, 2, 2), List(-2, -2, 4), List(-2, 0, 2)))
    assert(threeSum(Array(-1, 0, 1, 2, -1, -4)).toSet == Set(List(-1, 0, 1), List(-1, -1, 2)))
    assert(threeSum(Array(0, 0, 0, 0, 0, 0)).toSet == Set(List(0, 0, 0)))
  }
}
