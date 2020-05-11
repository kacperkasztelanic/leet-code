package solutions.scala

import scala.annotation.tailrec

object N200NumberOfIslands {

  def numIslands(grid: Array[Array[Char]]): Int = {
    def discover(i: Int, j: Int, seen: Map[Int, Set[Int]]): (Int, Map[Int, Set[Int]]) =
      if (i < 0 || i >= grid.length || j < 0 || j >= grid(i).length || seen(i)(j) || grid(i)(j) == '0') (0, seen)
      else {
        val s: Map[Int, Set[Int]] = seen.updated(i, seen(i) + j)
        val a = discover(i + 1, j, s)
        val b = discover(i - 1, j, a._2)
        val c = discover(i, j + 1, b._2)
        val d = discover(i, j - 1, c._2)
        (1, d._2)
      }

    @tailrec
    def rows(i: Int, seen: Map[Int, Set[Int]], acc: Int): (Int, Map[Int, Set[Int]]) = {
      @tailrec
      def cols(i: Int, j: Int, seen: Map[Int, Set[Int]], acc: Int): (Int, Map[Int, Set[Int]]) = {
        if (j < grid(i).length) {
          val a = discover(i, j, seen)
          cols(i, j + 1, a._2, acc + a._1)
        }
        else (acc, seen)
      }

      if (i < grid.length) {
        val a = cols(i, 0, seen, acc)
        rows(i + 1, a._2, Math.max(acc, a._1))
      }
      else (acc, seen)
    }

    rows(0, Map.empty.withDefaultValue(Set.empty), 0)._1
  }

  def main(args: Array[String]): Unit = {
    assert(
      numIslands(
        Array(
          Array('1', '1', '1', '1', '0'),
          Array('1', '1', '0', '1', '0'),
          Array('1', '1', '0', '0', '0'),
          Array('0', '0', '0', '0', '0')
        )
      ) == 1
    )
    assert(
      numIslands(
        Array(
          Array('1', '1', '0', '0', '0'),
          Array('1', '1', '0', '0', '0'),
          Array('0', '0', '1', '0', '0'),
          Array('0', '0', '0', '1', '1')
        )
      ) == 3
    )
    assert(
      numIslands( //
        Array.empty
      ) == 0
    )
  }
}
