package controllers

import play.api._
import play.api.mvc._
import play.twirl.api.Html
import service.{DiskReaderComponentImpl, DiskReaders, SortFilesFromDiskImpl, SortersFiles}


object Application extends Controller with DiskReaders with DiskReaderComponentImpl
with SortersFiles with SortFilesFromDiskImpl{

  def javascriptRoutes = Action { implicit request =>
    Ok(Routes.javascriptRouter("jsRoutes")(
    )).as("text/javascript")
  }

  def index = Action { request =>
    Ok(sortFilesFromDisk(readFromDisk).mkString("\\n"))
  }

}