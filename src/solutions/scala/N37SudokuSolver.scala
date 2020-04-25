package solutions.scala

object N37SudokuSolver {

  def solveSudoku(board: Array[Array[Char]]): Unit = {
    def possibleDigits(board: Array[Array[Char]], r: Int, c: Int): Seq[Char] = {
      def cells(i: Int) = Seq(board(r)(i), board(i)(c), board(3 * (r / 3) + i / 3)(3 * (c / 3) + i % 3))

      ('1' to '9').diff(board.indices.flatMap(cells))
    }

    def solve(board: Array[Array[Char]], cell: Int = 0): Option[Array[Array[Char]]] =
      (cell % 9, cell / 9) match {
        case (0, 9) => Some(board)
        case (r, c) if board(r)(c) != '.' => solve(board, cell + 1)
        case (r, c) =>
          possibleDigits(board, r, c)
            .flatMap(n => solve(board.updated(r, board(r).updated(c, n))))
            .headOption
      }

    val res = solve(board).head
    for {
      i <- 0 until 9
      j <- 0 until 9
    } yield board(i)(j) = res(i)(j)
  }
}
