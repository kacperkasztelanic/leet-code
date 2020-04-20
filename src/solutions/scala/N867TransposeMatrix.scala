package solutions.scala

object N867TransposeMatrix {

  def transpose(A: Array[Array[Int]]): Array[Array[Int]] = A(0).indices.map(col => A.map(row => row(col))).toArray

  def transpose2(A: Array[Array[Int]]): Array[Array[Int]] = A.transpose

  def main(args: Array[String]): Unit = {
    assert(transpose(Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9)))
      .sameElements(Array(Array(1, 4, 7), Array(2, 5, 8), Array(3, 6, 9)))
    )
    assert(transpose(Array(Array(1, 2, 3), Array(4, 5, 6)))
      .sameElements(Array(Array(1, 4), Array(2, 5), Array(3, 6)))
    )
  }
}
