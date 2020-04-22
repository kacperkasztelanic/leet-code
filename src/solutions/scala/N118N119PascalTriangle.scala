package solutions.scala

object N118N119PascalTriangle {

  def generate(numRows: Int): List[List[Int]] = {
    val pascal = Stream.iterate(List(1))(a => (0 +: a, a :+ 0).zipped.map(_ + _))
    pascal.take(numRows).toList
  }

  def getRow(rowIndex: Int): List[Int] = {
    val pascal = Stream.iterate(List(1))(a => (0 +: a, a :+ 0).zipped.map(_ + _))
    pascal.slice(rowIndex, rowIndex + 1).head
  }

  def pascal(c: Int, r: Int): Int =
    if (c == 0 || c == r || r == 0) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
}
