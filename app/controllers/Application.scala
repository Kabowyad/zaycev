package controllers

import play.api._
import play.api.mvc._
import play.twirl.api.Html
import service.{DiskReaderComponentImpl, SortFilesComponentImpl}

object real extends SortFilesComponentImpl with DiskReaderComponentImpl

object Application extends Controller {

  val sortFiles = real sortFiles
  val diskReader = real diskReader

  def javascriptRoutes = Action { implicit request =>
    Ok(Routes.javascriptRouter("jsRoutes")(
    )).as("text/javascript")
  }

  def index = Action { request =>
    Ok(sortFiles.sort(diskReader.read()).mkString("\n"))
  }

}