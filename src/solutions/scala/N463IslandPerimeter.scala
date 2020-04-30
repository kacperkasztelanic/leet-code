package solutions.scala

object N463IslandPerimeter {

  def islandPerimeter(grid: Array[Array[Int]]): Int = {
    def countEdges(i: Int, j: Int): Int = {
      val a = if (i + 1 == grid.length || grid(i + 1)(j) == 0) 1 else 0
      val b = if (i == 0 || grid(i - 1)(j) == 0) 1 else 0
      val c = if (j + 1 == grid(i).length || grid(i)(j + 1) == 0) 1 else 0
      val d = if (j == 0 || grid(i)(j - 1) == 0) 1 else 0
      a + b + c + d
    }

    (for {
      i <- grid.indices
      j <- grid(i).indices
      if (grid(i)(j) == 1)
    } yield countEdges(i, j)).sum
  }

  def main(args: Array[String]): Unit = {
    assert( //
      islandPerimeter( //
        Array( //
          Array(0, 1, 0, 0), //
          Array(1, 1, 1, 0), //
          Array(0, 1, 0, 0), //
          Array(1, 1, 0, 0) //
        ) //
      ) == 16 //
    )
  }
}
