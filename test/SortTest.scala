import org.specs2._
import service.{DiskReaderComponentImpl, SortFilesComponentImpl}

/**
  * Created by user on 18/06/17.
  */

object fake extends DiskReaderComponentImpl with SortFilesComponentImpl
class SortTest extends Specification{
    val sortFiles = fake sortFiles
    "SortTest" should  {

    }
}
