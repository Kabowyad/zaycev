package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def javascriptRoutes = Action { implicit request =>
    Ok(Routes.javascriptRouter("jsRoutes")(
      routes.javascript.
    )
    )
  }

}