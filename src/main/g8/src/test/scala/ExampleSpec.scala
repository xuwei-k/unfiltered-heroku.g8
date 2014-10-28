package com.example

import org.specs2.mutable.Specification

object ExampleSpec extends Specification with unfiltered.specs2.jetty.Served {

  def setup = { _.plan(new App) }

  "The example app" should {
    "serve unfiltered requests" in {
      val request = scalaj.http.Http(host.to_uri.toString)
      request.asString must_== "hello"
      request.responseCode must_== 200
    }
  }
}
