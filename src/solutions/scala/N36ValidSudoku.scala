package solutions.scala

import scala.annotation.tailrec

object N36ValidSudoku {

  def isValidSudoku(board: Array[Array[Char]]): Boolean = {
    def isValidPart(part: Seq[Char]): Boolean = {
      val withoutDots = part.filter(c => c != '.')
      withoutDots.toSet.size == withoutDots.size
    }

    @tailrec
    def isValidSudoku(i: Int): Boolean = i match {
      case 9 => true
      case i =>
        val rowColSquare = 0.until(9).unzip3(j => (board(i)(j), board(j)(i), board((i / 3) * 3 + j / 3)((i % 3) * 3 + j % 3)))
        if (rowColSquare.productIterator.asInstanceOf[Iterator[IndexedSeq[Char]]].exists(p => !isValidPart(p))) false
        else isValidSudoku(i + 1)
    }

    isValidSudoku(0)
  }

  def main(args: Array[String]): Unit = {
    val example1 = Array[Array[Char]](
      Array('5', '3', '.', '.', '7', '.', '.', '.', '.'),
      Array('6', '.', '.', '1', '9', '5', '.', '.', '.'),
      Array('.', '9', '8', '.', '.', '.', '.', '6', '.'),
      Array('8', '.', '.', '.', '6', '.', '.', '.', '3'),
      Array('4', '.', '.', '8', '.', '3', '.', '.', '1'),
      Array('7', '.', '.', '.', '2', '.', '.', '.', '6'),
      Array('.', '6', '.', '.', '.', '.', '2', '8', '.'),
      Array('.', '.', '.', '4', '1', '9', '.', '.', '5'),
      Array('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )
    val example2 = Array[Array[Char]](
      Array('8', '3', '.', '.', '7', '.', '.', '.', '.'),
      Array('6', '.', '.', '1', '9', '5', '.', '.', '.'),
      Array('.', '9', '8', '.', '.', '.', '.', '6', '.'),
      Array('8', '.', '.', '.', '6', '.', '.', '.', '3'),
      Array('4', '.', '.', '8', '.', '3', '.', '.', '1'),
      Array('7', '.', '.', '.', '2', '.', '.', '.', '6'),
      Array('.', '6', '.', '.', '.', '.', '2', '8', '.'),
      Array('.', '.', '.', '4', '1', '9', '.', '.', '5'),
      Array('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )
    val example3 = Array[Array[Char]](
      Array('.', '.', '.', '.', '5', '.', '.', '1', '.'),
      Array('.', '4', '.', '3', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '3', '.', '.', '1'),
      Array('8', '.', '.', '.', '.', '.', '.', '2', '.'),
      Array('.', '.', '2', '.', '7', '.', '.', '.', '.'),
      Array('.', '1', '5', '.', '.', '.', '.', '.', '.'),
      Array('.', '.', '.', '.', '.', '2', '.', '.', '.'),
      Array('.', '2', '.', '9', '.', '.', '.', '.', '.'),
      Array('.', '.', '4', '.', '.', '.', '.', '.', '.')
    )

    assert(isValidSudoku(example1))
    assert(!isValidSudoku(example2))
    assert(!isValidSudoku(example3))
  }
}
