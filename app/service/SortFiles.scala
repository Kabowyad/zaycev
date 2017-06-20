package service

import scala.collection.mutable.ArrayBuffer
import entities.File

/**
  * Created by user on 04/06/17.
  */
// interface
trait SortFilesComponent { // exrpessing dependency
  trait SortFiles { // Interface exposed to File
    def sort(input: String): List[File]
  }

  val sortFiles: SortFiles // way to obtain dependency
}

trait SortFilesComponentImpl extends SortFilesComponent {
  self: DiskReaderComponent =>

  override val sortFiles: SortFiles = new SortFiles {
    override def sort(input: String): List[File] = {
      val strings = input.split("\\n")
            val size = strings.size
            var list = List[File]()
            for (i <- 1 to size) {
              val digitIndex = strings(i).indexWhere(_.isDigit)
              val substring = strings(i).substring(digitIndex, strings(i).length)
              val fileName = substring.substring(substring.indexOf(" ") + 1, substring.length)
              val fileSize = substring.substring(0, substring.indexOf(" ")).toInt
              val file = new File(fileName, fileSize)
              list = file :: list
            }
            list.sortWith(_.size > _.size)
    }
  }
}
