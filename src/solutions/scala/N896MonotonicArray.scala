package solutions.scala

object N896MonotonicArray {

  def isMonotonic(arr: Array[Int]): Boolean = {
    false
  }

  def main(args: Array[String]): Unit = {
    assert(isMonotonic(Array(1, 2, 2, 3)))
    assert(isMonotonic(Array(6, 5, 4, 4)))
    assert(!isMonotonic(Array(1, 3, 2)))
    assert(isMonotonic(Array(1, 2, 4, 5)))
    assert(isMonotonic(Array(1, 1, 1)))
  }
}
