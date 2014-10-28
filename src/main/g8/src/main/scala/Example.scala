package com.example

import unfiltered.request._
import unfiltered.response._

final class App extends unfiltered.filter.Plan {
  def intent = {
    case GET(r) =>
      Ok ~> ResponseString("hello")
  }
}

object Server {
  def main(args: Array[String]) {
    val port = scala.util.Properties.envOrElse("PORT", "$default_port_number$").toInt
    unfiltered.jetty.Server.http(port).plan(new App).run
  }
}
