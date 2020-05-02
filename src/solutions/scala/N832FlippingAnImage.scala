package solutions.scala

object N832FlippingAnImage {

  def flipAndInvertImage(arr: Array[Array[Int]]): Array[Array[Int]] = arr.map(_.reverse.map(_ ^ 1))

  def flipAndInvertImageInPlace(arr: Array[Array[Int]]): Array[Array[Int]] = {
    arr.indices
      .map(i => arr(i).indices
        .takeWhile(j => j < (arr(i).length + 1) / 2)
        .map(j => {
          val tmp = arr(i)(j) ^ 1
          arr(i)(j) = arr(i)(arr(i).length - 1 - j) ^ 1
          arr(i)(arr(i).length - 1 - j) = tmp
        })
      )
    arr
  }
}
