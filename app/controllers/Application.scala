package controllers

import play.api._
import play.api.mvc._
import play.twirl.api.Html
import service._

//object Application extends Application(DiskReaderImpl)

object Application extends Application with DiskReaderComponentImpl with SortFilesFromDiskImpl

class Application extends Controller {
  self:  DiskReaderComponent with SortFilesComponent =>

  def javascriptRoutes = Action { implicit request =>
    Ok(Routes.javascriptRouter("jsRoutes")(
    )).as("text/javascript")
  }

  def index = Action { request =>
    Ok(sortFiles.sort(diskReader.read()).mkString("\\n"))
  }
}

