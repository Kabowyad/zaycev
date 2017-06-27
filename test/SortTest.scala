import entities.File
import org.specs2.mutable._
import play.api.test.WithApplication
import service._
import play.api.test._

/**
  * Created by user on 18/06/17.
  */

class SortTest extends Specification
  with SortersFiles
  with SortFilesFromDiskImpl {
    "SortFiles" should {

        "sort fine" in new WithApplication {
            val input = "\"total 559576\n     14 First\n    68 Second\n 11920 Third\n     4 zina\n\""
            val ordered = List[File](File("Third", 11920), File("Second", 68), File("First", 14), File("zina", 4))
            val sort = sortFiles.sort(input)

            sort must_== ordered
        }
    }
}