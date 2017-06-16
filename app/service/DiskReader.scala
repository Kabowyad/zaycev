package service

import sys.process._
/**
  * Created by user on 04/06/17.
  */
trait DiskReaderComponent {
  def diskReader: DiskReader

  trait DiskReader {
    def read(): String
  }
}

trait DiskReaderComponentImpl extends DiskReaderComponent {
  def diskReader = new DiskReaderImpl

  class DiskReaderImpl extends DiskReader {
    val cdCommand = "ls -s /~"!!

    override def read(): String = {
      cdCommand
    }
  }
}
