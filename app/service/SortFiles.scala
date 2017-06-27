package service

import scala.collection.mutable.ArrayBuffer
import entities.File

/**
  * Created by user on 04/06/17.
  */

trait SortFilesComponent {

  def sortFiles: SortFiles

  trait SortFiles {
    def sort(strings: String): Array[File]
  }
}

trait SortersFiles {
  this: SortFilesComponent =>

  def sortFilesFromDisk(strings: String): Array[File] = {
    sortFiles.sort(strings)
  }
}

trait SortFilesFromDiskImpl extends SortFilesComponent {

  def sortFiles = new SortFilesImpl

  class SortFilesImpl extends SortFiles {

    def sort(string: String) = {
      val strings = string.drop(string.indexOf(" ", string.indexOf(" ") +1))
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
