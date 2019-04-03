package solutions.scala.excel

object ExcelColumnsTests extends App {

  val getIndexTests = Map("A" -> 1, "Z" -> 26, "AA" -> 27, "ZZ" -> 702, "AAA" -> 703, "BZW" -> 2051, "CAA" -> 2055, "DZA" -> 3381)
  val getLettersTests = for ((k, v) <- getIndexTests) yield (v, k)

  val excelColumns = ExcelColumnsImpl
  getIndexTests.foreach(e => println(excelColumns.getIndex(e._1) == e._2))
  getLettersTests.foreach(e => println(excelColumns.getLetters(e._1) == e._2))
}
