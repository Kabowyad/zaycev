package service

import sys.process._
/**
  * Created by user on 04/06/17.
  */
//Interface
trait DiskReaderComponent {  //Expressing dependency
  def diskReader: DiskReader // Way to obtain dependency

  trait DiskReader { // Interface exposes to
    def read(): String
  }
}

trait DiskReaderComponentImpl extends DiskReaderComponent {
  def cdCommand = Seq("ls", "-s", "/home/yan").!!
  def diskReader = new DiskReader()

  class DiskReader() extends DiskReader {
    def read = cdCommand
  }

}

