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

  def sortFiles: SortFiles // way to obtain dependency
}

trait SortFilesComponentImpl extends SortFilesComponent {
  this: DiskReaderComponent =>

  def sortFiles = new SortFilesImp

  class SortFilesImp extends SortFiles {
    def sort(input: String): Array[File] = {
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
