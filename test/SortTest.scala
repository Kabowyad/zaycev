import entities.File
import org.specs2.mutable._
import play.api.test.WithApplication
import service.{DiskReaderComponentImpl, SortFilesComponentImpl}
/**
  * Created by user on 18/06/17.
  */
object fake extends DiskReaderComponentImpl with SortFilesComponentImpl
class SortTest extends Specification {
    "SortFiles" should {

        val input = "\"total 559576\n     14 First\n    68 Second\n 11920 Third\n     4 zina\n\""
        val ordered = List[File](File("Third", 11920), File("Second", 68), File("First", 14), File("zina", 4))
        val sortFiles = fake sortFiles
        "sort fine" in {
            val list = sortFiles.sort(input)
            list must_== ordered
        }
    }
}