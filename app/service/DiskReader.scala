package service

import sys.process._
/**
  * Created by user on 04/06/17.
  */
//Interface
trait DiskReaderComponent {  //Expressing dependency
  val diskReader: DiskReader // Way to obtain dependency

  trait DiskReader { // Interface exposes to
    def read(): String
  }
}

trait DiskReaderComponentImpl extends DiskReaderComponent {
  override val diskReader : DiskReader = new DiskReader {
    def cdCommand = Seq("ls", "-s", "/home/yan").!!

    override def read(): String = {
      cdCommand
    }
  }
}

