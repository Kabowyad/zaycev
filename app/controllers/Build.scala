package controllers

import play.api.mvc.{Action, Controller}
import service.{DiskReaderComponentImpl, SortFilesComponentImpl}

/**
  * Created by user on 17/06/17.
  */

object real extends SortFilesComponentImpl with DiskReaderComponentImpl

object Build extends Controller {

  val sortFiles = real sortFiles

  def build = Action { request =>
    sortFiles.sort()
    Ok()
  }
}


