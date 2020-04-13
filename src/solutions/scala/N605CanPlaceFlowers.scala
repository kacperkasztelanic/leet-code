package solutions.scala

object N605CanPlaceFlowers {

  def canPlaceFlowers(flowerbed: Array[Int], n: Int): Boolean =
    (-2 +: flowerbed.indices.filter(x => flowerbed(x) == 1) :+ flowerbed.length + 1)
      .sliding(2).map {
      case Seq(s, e) =>
        val num = e - s - 1
        if (num % 2 == 0) num / 2 - 1 else num / 2
    }.sum >= n

  def main(args: Array[String]): Unit = {
    println(canPlaceFlowers(List(0, 1, 0, 0, 0, 1, 0, 1).toArray, 1))
  }
}
