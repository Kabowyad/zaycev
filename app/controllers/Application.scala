package controllers

import play.api._
import play.api.mvc._
import play.twirl.api.Html
import service.{DiskReaderComponentImpl, SortFilesComponentImpl}

object real extends SortFilesComponentImpl with DiskReaderComponentImpl

object Application extends Controller {

  val serviceComponent = new SortFilesComponentImpl with DiskReaderComponentImpl{}

  val service = serviceComponent.sortFiles

  def javascriptRoutes = Action { implicit request =>
    Ok(Routes.javascriptRouter("jsRoutes")(
    )).as("text/javascript")
  }

  def index = Action { request =>
    Ok(service.sort().mkString("\n"))
  }

}