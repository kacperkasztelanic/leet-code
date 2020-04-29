package solutions.scala

import scala.annotation.tailrec

object N905SortArrayByParity {

  def sortArrayByParity(arr: Array[Int]): Array[Int] = {
    def swap(a: Int, b: Int, vector: Vector[Int]): Vector[Int] = {
      val temp = vector(a)
      vector.updated(a, vector(b)).updated(b, temp)
    }

    @tailrec
    def sortArrayByParity(l: Int, r: Int, vector: Vector[Int]): Vector[Int] = {
      if (l >= r) vector
      else {
        if (vector(l) % 2 == 1) sortArrayByParity(l, r - 1, swap(l, r, vector))
        else sortArrayByParity(l + 1, r, vector)
      }
    }

    sortArrayByParity(0, arr.length - 1, arr.toVector).toArray
  }


  def sortArrayByParity2(arr: Array[Int]): Array[Int] = {
    def swap(a: Int, b: Int): Unit = {
      arr(a) ^= arr(b)
      arr(b) ^= arr(a)
      arr(a) ^= arr(b)
    }

    @tailrec
    def sortArrayByParity2(l: Int, r: Int): Array[Int] = {
      if (l >= r) arr
      else {
        if (arr(l) % 2 == 1) {
          swap(l, r)
          sortArrayByParity2(l, r - 1)
        }
        else sortArrayByParity2(l + 1, r)
      }
    }

    sortArrayByParity2(0, arr.length - 1)
  }


  def sortArrayByParity3(arr: Array[Int]): Array[Int] = {
    def swap(a: Int, b: Int): Unit = {
      val temp = arr(a)
      arr(a) = arr(b)
      arr(b) = temp
    }

    @tailrec
    def sortArrayByParity3(l: Int, r: Int): Array[Int] = {
      if (l > r) arr
      else {
        if (arr(l) % 2 == 1) {
          swap(l, r)
          sortArrayByParity3(l, r - 1)
        }
        else sortArrayByParity3(l + 1, r)
      }
    }

    sortArrayByParity3(0, arr.length - 1)
  }

  def sortArrayByParity4(arr: Array[Int]): Array[Int] =
    arr.groupBy(_ % 2 == 1).toSeq.sortBy(_._1).map(_._2).fold(Array())(_ ++ _)

  def sortArrayByParity5(arr: Array[Int]): Array[Int] = {
    val partitioned = arr.partition(_ % 2 == 0)
    partitioned._1 ++ partitioned._2
  }

  def sortArrayByParity6(arr: Array[Int]): Array[Int] = arr.sortWith((a, b) => a % 2 < b % 2)

  def main(args: Array[String]): Unit = {
    println(sortArrayByParity(Array(1)).toList)
    println(sortArrayByParity(Array(3, 1, 2, 4)).toList)
  }
}
