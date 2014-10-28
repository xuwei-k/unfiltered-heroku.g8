name := "$name$"

version := "$version$"

scalaVersion := "$scala_version$"

val unfilteredVersion = "$unfiltered_version$"

libraryDependencies ++= Seq("filter", "jetty").map(module =>
  "net.databinder" %% ("unfiltered-" + module) % unfilteredVersion
)

libraryDependencies ++= (
  ("net.databinder" %% "unfiltered-specs2" % unfilteredVersion % "test") ::
  ("org.scalaj" %% "scalaj-http" % "$scalajhttp_version$" % "test") ::
  Nil
)

scalacOptions ++= (
  "-deprecation" ::
  "-unchecked" ::
  "-language:existentials" ::
  "-language:higherKinds" ::
  "-language:implicitConversions" ::
  Nil
)

packageArchetype.java_application

enablePlugins(HerokuPlugin)

HerokuPlugin.autoImport.herokuAppName in Compile := "$heroku_app_name$"
