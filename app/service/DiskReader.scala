package service

import sys.process._

trait DiskReaderComponent {
  def diskReader: DiskReader

  trait DiskReader {
    def read(): String
  }
}

trait DiskReaders {
  this: DiskReaderComponent =>

  def readFromDisk: String = {
    diskReader.read()
  }
}

trait DiskReaderComponentImpl extends DiskReaderComponent {
  def diskReader = new DiskReaderImpl
  def cdCommand = Seq("ls", "-s", "/home/yan").!!

  class DiskReaderImpl extends DiskReader {
    def read(): String = {
      cdCommand
    }
  }
}

