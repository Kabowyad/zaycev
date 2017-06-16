package service

import scala.collection.mutable.ArrayBuffer
import entities.File

/**
  * Created by user on 04/06/17.
  */
trait SortFilesComponent {
  def sortFilesComponent: SortFiles

  trait SortFiles {
    def sort()
  }
}

trait SortFilesComponentImpl extends SortFilesComponent {
  this: DiskReaderComponent =>

  def sortFiles: sortFilesImpl

  class sortFilesImpl extends SortFiles {

    override def sort(): String = {
      val strings = new ArrayBuffer[String]()
      diskReader.read().split("\\n").map(x => strings += x)
      val size = strings.size
      for (i <- 1 to size) {
        val digitIndex = strings(i).indexWhere(_.isDigit)
        val substring = strings(i).substring(digitIndex, strings(i).length)
        val fileName = substring.substring(substring.indexOf(" ") + 1, substring.length)
        val fileSize = substring.substring(0, substring.indexOf(" ")).toInt
        val file = new File(fileName, fileSize)
        //TODO: Что дальше делать с моделью? Добавлять в какой-то лист и потом отображать или можно отдавать прямо так?
      }
    }
  }

}
