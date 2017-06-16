package controllers

import play.api.mvc.Action
import service.SortFilesComponent

/**
  * Created by user on 04/06/17.
  */
trait BuildController {
  def sortFiles: SortFilesComponent

  def build() = Action {request =>
    sortFiles.sortFilesComponent.sort() {}
  }

}
