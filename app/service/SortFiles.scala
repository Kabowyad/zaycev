package service

import scala.collection.mutable.ArrayBuffer
import entities.File

/**
  * Created by user on 04/06/17.
  */
// interface
trait SortFilesComponent { // exrpessing dependency
  trait SortFiles { // Interface exposed to File
    def sort(input: String): Array[File]
  }

  val sortFiles: SortFiles // way to obtain dependency
}

trait SortFilesComponentImpl extends SortFilesComponent {
  self: DiskReaderComponent =>

  override val sortFiles: SortFiles = new SortFiles {
    override def sort(input: String): Array[File] = {
      //"     4 Desktop"
      val strings = input.drop(input.indexOf(" ", input.indexOf(" ") +1))
        .split("\\n")
        .map{ s =>
          val parts = s.trim.split(" ", 2)
          (parts(0).toLong, parts(1))
          new File(parts(1), parts(0).toInt)
        }
      strings.sortWith(_.size > _.size)
    }
  }
}

//val fileList = strings.foldLeft(List[File]()) {(z,f) =>
//  val digitIndex = f.indexWhere(_.isDigit)
//  val sub = f.substring(digitIndex, f.length)
//  val name = sub.substring(sub.indexOf(" ") + 1, sub.length)
//  val size = sub.substring(0, sub.indexOf(" ")).toInt
//  z :+ File(name, size)
//  }

//val size = strings.size
//var list = List[File]()
//for (i <- 1 to size-1) {
//  val digitIndex = strings(i).indexWhere(_.isDigit)
//  val substring = strings(i).substring(digitIndex, strings(i).length)
//  val fileName = substring.substring(substring.indexOf(" ") + 1, substring.length)
//  val fileSize = substring.substring(0, substring.indexOf(" ")).toInt
//  val file = new File(fileName, fileSize)
//  list = file :: list
//}